/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.logic.recipe;

import model.entities.*;
import java.util.*;

/**
 *
 * @author GaBi
 */
public class RecipeCart {

    List<RecipeCartIngredients> ingredients;
    int numberOfIngredients;
    int totalKcal;
    int totalWeight;

    public RecipeCart() {
        ingredients = new ArrayList<RecipeCartIngredients>();
        numberOfIngredients = 0;
        totalKcal = 0;
        totalWeight = 0;
    }

    /**
     * Adds a <code>RecipeCartIngredients</code> to the <code>RecipeCart</code>'s
     * <code>ingredients</code> list. If ingredient of the specified <code>vegetable</code>
     * already exists in recipe cart list, the quantity of that ingredient is
     * incremented.
     *
     * @param vegetable the <code>Vegetable</code> that defines the type of recipe cart item
     * @see RecipeCartIngredients
     */
    public synchronized void addItem(Vegetables vegetable) {

        boolean newIngredient = true;

        for (RecipeCartIngredients rcItem : ingredients) {

            if (rcItem.getVegetable().getId() == vegetable.getId()) {

                newIngredient = false;
                rcItem.incrementQuantity();
            }
        }

        if (newIngredient) {
            RecipeCartIngredients rcItem = new RecipeCartIngredients(vegetable);
            ingredients.add(rcItem);
        }
    }

    /**
     * Updates the <code>RecipeCartIngredients</code> of the specified
     * <code>vegetable</code> to the specified quantity. If '<code>0</code>'
     * is the given quantity, the <code>RecipeCartIngredients</code> is removed
     * from the <code>RecipeCart</code>'s <code>ingredients</code> list.
     *
     * @param vegetable the <code>Vegetable</code> that defines the type of recipe cart ingredient
     * @param quantity the number which the <code>RecipeCartIngredients</code> is updated to
     * @see RecipeCartIngredients
     */
    public synchronized void update(Vegetables vegetable, String quantity) {

        int qty = -1;

        // cast quantity as short
        qty = Short.parseShort(quantity);

        if (qty >= 0) {

            RecipeCartIngredients ingredient = null;

            for (RecipeCartIngredients rcItem : ingredients) {

                if (rcItem.getVegetable().getId() == vegetable.getId()) {

                    if (qty != 0) {
                        // set ingredient quantity to new value
                        rcItem.setQuantity(qty);
                    } else {
                        // if quantity equals 0, save ingredient and break
                        ingredient = rcItem;
                        break;
                    }
                }
            }

            if (ingredient != null) {
                // remove from recipe cart
                ingredients.remove(ingredient);
            }
        }
    }

    /**
     * Returns the list of <code>RecipeCartIngredients</code>.
     *
     * @return the <code>ingredients</code> list
     * @see RecipeCartIngredients
     */
    public synchronized List<RecipeCartIngredients> getIngredients() {

        return ingredients;
    }

    /**
     * Returns the sum of quantities for all ingredients maintained in recipe cart
     * <code>ingredients</code> list.
     *
     * @return the number of ingredients in recipe cart
     * @see RecipeCartIngredients
     */
    public synchronized int getNumberOfIngredients() {

        numberOfIngredients = 0;

        for (RecipeCartIngredients rcItem : ingredients) {

            numberOfIngredients += rcItem.getQuantity();
        }

        return numberOfIngredients;
    }

    /**
     * Returns the sum of the vegetable price multiplied by the quantity for all
     * ingredients in recipe cart list. This is the totalKcal.
     *
     * @return the totalKcal of all ingredients times their quantities
     * @see RecipeCartIngredients
     */
    public synchronized void getKcal() {

        int calories = 0;

        for (RecipeCartIngredients rcItem : ingredients) {

        	calories += (rcItem.getTotal());
        }
        
        totalKcal = calories;
    }

    /**
     * Returns the totalKcal of the order for the given
     * <code>RecipeCart</code> instance.
     *
     * @return the totalKcal of all ingredients times their quantities
     */
    public synchronized int getTotalKcal() {
    	getKcal();
        return totalKcal;
    }

    public synchronized void getWeight() {

        int weight = 0;

        for (RecipeCartIngredients rcItem : ingredients) {
        	
        	weight += (rcItem.getWeight());
        }
        
        totalWeight = weight;
    }

    /**
     *
     */
    public synchronized int getTotalWeight() {
    	getWeight();
        return totalWeight;
    }
    
    
    /**
     * Empties the recipe cart. All ingredients are removed from the recipe cart
     * <code>ingredients</code> list, <code>numberOfIngredients</code>, <code>totalWeight</code> and
     * <code>totalKcal</code> are reset to '<code>0</code>'.
     *
     * @see RecipeCartIngredients
     */
    public synchronized void clear() {
        ingredients.clear();
        numberOfIngredients = 0;
        totalKcal = 0;
        totalWeight = 0;
    }

}