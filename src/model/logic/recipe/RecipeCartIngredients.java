package model.logic.recipe;

import model.entities.*;

/**
 *
 * @author GaBi
 */
public class RecipeCartIngredients {

    Vegetables vegetable;
    int quantity;

    public RecipeCartIngredients(Vegetables vegetable) {
        this.vegetable = vegetable;
        quantity = 1;
    }

    public Vegetables getVegetable() {
        return vegetable;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void incrementQuantity() {
        quantity++;
    }

    public void decrementQuantity() {
        quantity--;
    }

    public int getTotal() {
        int calories = 0;
        calories = (this.getQuantity() * vegetable.getWeight());
        return calories;
    }
    
    public int getWeight() {
        int calories = 0;
        calories = (this.getQuantity() * 100);
        return calories;
    }

}