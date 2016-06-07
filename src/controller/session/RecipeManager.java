package controller.session;

import model.logic.recipe.RecipeCart;
import model.logic.recipe.RecipeCartIngredients;
import model.entities.*;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author GaBi
 */
public class RecipeManager {

    @PersistenceContext
    private EntityManager em;

    public Recipes addRecipe(RecipeCart rCart) {

        // set up recipe
        Recipes recipe = new Recipes();
        recipe.setWeight(rCart.getTotalWeight());
        recipe.setKcal(rCart.getTotalKcal());

        em.persist(recipe);
        return recipe;
    }

    public RecipesHasVegetables addRecipesIngredients(Recipes recipe, RecipeCart rCart) {

        em.flush();
        RecipesHasVegetables recipeItem = null;
        List<RecipeCartIngredients> ingredients = rCart.getIngredients();

        // iterate through recipe cart and create RecipesHasVegetables
        for (RecipeCartIngredients rcItem : ingredients) {
        	
        	// set up primary key 
            int vegetableId = rcItem.getVegetable().getId();
            int recipeId = recipe.getId();
            int quantity = rcItem.getQuantity();

            recipeItem = new RecipesHasVegetables(recipeId, vegetableId, quantity);

            em.persist(recipeItem);
        }
		return recipeItem;
    }
}