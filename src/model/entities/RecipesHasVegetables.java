/**
 * 
 */
package model.entities;

/**
 * @author GaBi
 * @since 05.05.2016
 * @version v 1.0
 */
public class RecipesHasVegetables {
	private int recipesId;
	private int vegetablesId;
	private int quantity;
	
	/**
	 * 
	 */
	public RecipesHasVegetables() {
		
	}
	
	/**
	 * @param recipesId
	 * @param vegetablesId
	 * @param quantity
	 */
	public RecipesHasVegetables(int recipesId, int vegetablesId, int quantity) {
		super();
		this.recipesId = recipesId;
		this.vegetablesId = vegetablesId;
		this.quantity = quantity;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RecipesHasVegetables [recipesId=" + recipesId + ", vegetablesId=" + vegetablesId + ", "
				+ "quantity=" + quantity + "]";
	}

	/**
	 * @return the recipesId
	 */
	public int getRecipesId() {
		return recipesId;
	}

	/**
	 * @param recipesId the recipesId to set
	 */
	public void setRecipesId(int recipesId) {
		this.recipesId = recipesId;
	}

	/**
	 * @return the vegetablesId
	 */
	public int getVegetablesId() {
		return vegetablesId;
	}

	/**
	 * @param vegetablesId the vegetablesId to set
	 */
	public void setVegetablesId(int vegetablesId) {
		this.vegetablesId = vegetablesId;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}
