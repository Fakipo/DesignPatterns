package designpatterns.factorypattern;

import java.util.ArrayList;
import java.util.List;

public class Burger implements FastFood{
    @Override
    public void printFood() {
        System.out.println("Burger");
    }

    @Override
    public String getFoodName() {
        return "The Burger";
    }

    @Override
    public List<String> getFoodIngredients() {
        List<String> foodIngredientsList = new ArrayList<>();
        foodIngredientsList.add("Bun");
        foodIngredientsList.add("Patty");
        foodIngredientsList.add("Lettuce");
        foodIngredientsList.add("Cheese");
        return foodIngredientsList;
    }
}
