package designpatterns.generics;

import java.util.ArrayList;
import java.util.List;

public class FoodContainer<T extends Food>{
    T food;
    public FoodContainer(Food food) {
        this.food = (T) food;
    }
    public void printFoodName(){
        System.out.println(food.getName());
    }
}
