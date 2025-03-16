package designpatterns.generics;

public class Fruit implements Food{

    private String name;
    public Fruit(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
