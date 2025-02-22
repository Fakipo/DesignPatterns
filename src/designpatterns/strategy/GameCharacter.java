package designpatterns.strategy;

public class GameCharacter {
    private String name;
    private MovementStrategy movementStrategy;
    public GameCharacter(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public MovementStrategy getMovementStrategy() {
        return movementStrategy;
    }
    public void setMovementStrategy(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }
    public void move() {
        System.out.print(name + ": ");
        if (movementStrategy != null) {
            movementStrategy.move();
        } else {
            System.out.println("There is no movement");
        }
    }
}
