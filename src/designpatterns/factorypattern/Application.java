package designpatterns.factorypattern;

import java.util.Scanner;

public class Application {
    public static void main(String[] args){
        System.out.println("Hello please choose one fast food");
        System.out.println("Press 1 for Burger");
        System.out.println("Press 2 for Pizza");
        Scanner ob = new Scanner(System.in);
        int choice = ob.nextInt();
        FastFoodFactory factory = new FastFoodFactory();
        FastFood food = factory.generateFastFood(choice);
        if(food == null){
            System.out.println("No fast food factory available");
            return;
        }
        System.out.println("Name : " + food.getFoodName());
        System.out.println("Ingredients = " + food.getFoodIngredients().toString());
    }
}
