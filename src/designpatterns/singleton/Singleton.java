package designpatterns.singleton;

public class Singleton {
    private static final Singleton instance = new Singleton();

    private Singleton() {} // Private constructor to prevent instantiation

    public static Singleton getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }

}
