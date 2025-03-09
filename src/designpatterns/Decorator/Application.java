package designpatterns.Decorator;

public class Application    {
    public static void main(String[] args) {
        System.out.println("Hello and welcome to Decorator design pattern");
        Coffee coffee = new SimpleCoffee();
        System.out.println("simple coffee price = " +  coffee.getCoffeePrice());
        coffee = new SugarDecorator(coffee);
        System.out.println("Sugar added to coffee = " +  coffee.getCoffeePrice());
        coffee = new MilkDecorator(coffee);
        System.out.println("Milk and Sugar added to coffee = " +  coffee.getCoffeePrice());
    }
}
