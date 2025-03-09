package designpatterns.Decorator;

public class SugarDecorator extends CoffeeDecorator{
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }
    @Override
    public int getCoffeePrice(){
        return decoratedCoffee.getCoffeePrice() + 5;
    }
}
