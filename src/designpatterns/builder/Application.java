package designpatterns.builder;

public class Application {
    public static void main(String[] args) {
        System.out.println("Welcome to builder design pattern we are building a computer");
        Director director = new Director();

        ComputerBuilder laptopBuilder = new LaptopBuilder();
        director.setBuilder(laptopBuilder);
        Computer laptop = director.constructLaptop();
        System.out.println(laptop.toString());

        ComputerBuilder PCBuilder = new LaptopBuilder();
        director.setBuilder(PCBuilder);
        Computer PC = director.constructPC();
        System.out.println(PC.toString());
    }
}
