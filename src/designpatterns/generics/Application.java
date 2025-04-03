package designpatterns.generics;

public class Application {
    public static void main(String[] args) {
        System.out.println("We are here in applying generics application");
        Food vegetable = new Vegetable("Loki");
        Food fruit = new Fruit("mango");
        System.out.println(Math.pow(3,3));
        FoodContainer<Fruit> fruitContainer = new FoodContainer<>(fruit);
        FoodContainer<Vegetable> vegetableContainer = new FoodContainer<>(vegetable);
        fruitContainer.printFoodName();
        vegetableContainer.printFoodName();

    }
}
