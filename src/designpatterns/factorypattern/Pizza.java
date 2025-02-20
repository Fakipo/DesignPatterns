package designpatterns.factorypattern;

import java.util.ArrayList;
import java.util.List;

public class Pizza implements FastFood{

    @Override
    public void printFood() {
        System.out.println("Pizza");
    }

    @Override
    public String getFoodName() {
        return "The Pizza";
    }

    @Override
    public List<String> getFoodIngredients() {
        List<String> foodIngredientsList = new ArrayList<>();
        foodIngredientsList.add("Pizza Crust");
        foodIngredientsList.add("Cheese");
        foodIngredientsList.add("Pepperoni");
        foodIngredientsList.add("Marinara Sauce");
        return foodIngredientsList;
    }
}
