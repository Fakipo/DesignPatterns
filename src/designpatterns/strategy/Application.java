package designpatterns.strategy;

public class Application {
    public static void main(String[] args){
        System.out.println("Welcome to Strategy Design Pattern");
        System.out.println("We are not giving user a choice this time because we are not building anything");
        System.out.println("We are playing a game, you just watch :)");

        GameCharacter hero = new GameCharacter("Hero");
        GameCharacter villain = new GameCharacter("Villain");

        hero.setMovementStrategy(new Walking());
        villain.setMovementStrategy(new Flying());

        hero.move();
        villain.move();

        villain.setMovementStrategy(new RunStrategy());
        hero.setMovementStrategy(new RunStrategy());
        hero.move();
        villain.move();
    }
}
