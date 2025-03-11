package designpatterns.decorator;

public class MilkDecorator extends CoffeeDecorator{

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int getCoffeePrice(){
        return decoratedCoffee.getCoffeePrice() + 2;
    }
}
