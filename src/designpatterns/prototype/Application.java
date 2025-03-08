package designpatterns.prototype;

public class Application {
    public static void main(String[] args){
        System.out.println("Hello this is the prototype model");

        Circle c1 = new Circle(7, 154, new Color("black"));
        Circle c2 = (Circle) c1.clone();
        c1.draw();
        c2.draw();
    }
}

