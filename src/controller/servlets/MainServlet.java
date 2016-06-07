package controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.session.RecipeManager;
import model.dao.ClassificationDao;
import model.dao.DaoFactory;
import model.dao.VegetablesDao;
import model.entities.Recipes;
import model.entities.RecipesHasVegetables;
import model.entities.Vegetables;
import model.logic.recipe.RecipeCart;


/**
 * Servlet implementation class ClassificationServlet
 */
@WebServlet(name = "MainServlet",
			loadOnStartup = 1,
			urlPatterns = {"/classification",
						   "/addToRecipe",
						   "/viewRecipe",
						   "/updateRecipe",
						   "/createSalad",
						   "/bonAppetit",
						   "/chooseLanguage"})
public class MainServlet extends HttpServlet {
   
    private RecipeManager recipeManager;
	private static final long serialVersionUID = 1L;
	
	DaoFactory daoFactory = DaoFactory.getInstance();
	ClassificationDao classificationDao = daoFactory.createClassificationDao();
	VegetablesDao vegetablesDao = daoFactory.createVegetablesDao();
	
	
	@Override
    public void init() throws ServletException {
		
        // store classification list in servlet context
        getServletContext().setAttribute("classificationsList", classificationDao.findAll());
    }
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer classificationID = 1;
		
		String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        try{
        	classificationID = Integer.parseInt(request.getQueryString());
        } catch (NumberFormatException ex) {
        	// use default value of classificationID
        }
        getServletContext().setAttribute("selectedClassification", classificationDao.find(classificationID));
        getServletContext().setAttribute("classificationVegetables", vegetablesDao.findByClassificationID(classificationID));
        
        // if classification page is requested
        if (userPath.equals("/classification")) {
        	
        // if cart page is requested
        } else if (userPath.equals("/viewRecipe")) {

            String clear = request.getParameter("clear");

            if ((clear != null) && clear.equals("true")) {

                RecipeCart rCart = (RecipeCart) session.getAttribute("rCart");
                rCart.clear();
            }

            userPath = "/recipe";

        // if user switches language
        } else if (userPath.equals("/chooseLanguage")) {
            // TODO: Implement language request

        }

        // use RequestDispatcher to forward request internally
        String url = "/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }		
	}

	/**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");  // ensures that user input is interpreted as
        										// 8-bit Unicode (e.g., for Czech characters)

		String userPath = request.getServletPath();
		HttpSession session = request.getSession();
		RecipeCart rCart = (RecipeCart) session.getAttribute("rCart");

		// if addToRecipe action is called
		if (userPath.equals("/addToRecipe")) {

			// if user is adding ingredient to recipeCart for first time
			// create RecipeCart object and attach it to user session
			if (rCart == null) {

				rCart = new RecipeCart();
				session.setAttribute("rCart", rCart);
			}

			// get user input from request
			String vegetableId = request.getParameter("vegetableId");

			if (!vegetableId.isEmpty()) {

				Vegetables vegetable = vegetablesDao.find(Integer.parseInt(vegetableId));
				rCart.addItem(vegetable);
			}
			
			userPath = "/classification";

			// if updateRecipe action is called
		} else if (userPath.equals("/updateRecipe")) {

			// get input from request
			String vegetableId = request.getParameter("vegetableId");
			String quantity = request.getParameter("quantity");

				Vegetables vegetable = vegetablesDao.find(Integer.parseInt(vegetableId));
				rCart.update(vegetable, quantity);

				userPath = "/recipe";


		// if createSalad action is called
		} else if (userPath.equals("/createSalad")) {
			
			if (rCart != null) {

				Recipes newRecipe = recipeManager.addRecipe(rCart);
				
				// if order processed successfully send user to bonAppetit page
				if ( newRecipe != null) {
					
					RecipesHasVegetables newRecipesIngredients = recipeManager.addRecipesIngredients(newRecipe, rCart);
					
					// dissociate shopping cart from session
					rCart = null;

					// end session
					session.invalidate();

//					// place order details in request scope
					request.setAttribute("newRecipe", newRecipe);
					request.setAttribute("newRecipesIngredients", newRecipesIngredients);

					userPath = "/bonAppetit";

					// otherwise, send back to recipe page and display error
				} else {
					userPath = "/recipe";
					request.setAttribute("recipeFailureFlag", true);
				} 
			} 
		}

		// use RequestDispatcher to forward request internally
		String url = "/view" + userPath + ".jsp";

		try {
			request.getRequestDispatcher(url).forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
