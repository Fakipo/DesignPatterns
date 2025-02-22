package designpatterns.strategy;

public class RunStrategy implements MovementStrategy{

    @Override
    public void move() {
        System.out.println("Character is running");
    }
}
