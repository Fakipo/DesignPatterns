package designpatterns.decorator;

public abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }
    public int getCoffeePrice() {
        return decoratedCoffee.getCoffeePrice();
    }
}
