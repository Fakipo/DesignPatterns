package designpatterns.factorypattern;

public class FastFoodFactory {

    public FastFood generateFastFood(int foodName){
        if(foodName == 1){
            return new Burger();
        }else if(foodName == 2){
            return new Pizza();
        }
        return null;
    }
}
