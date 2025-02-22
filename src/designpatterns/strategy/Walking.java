package designpatterns.strategy;

public class Walking implements MovementStrategy{

    @Override
    public void move() {
        System.out.println("Character is Walking");
    }
}
