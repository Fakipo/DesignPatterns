package designpatterns.strategy;

public class Flying implements MovementStrategy{
    @Override
    public void move() {
        System.out.println("Character is flying");
    }
}
