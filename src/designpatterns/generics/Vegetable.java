package designpatterns.generics;

public class Vegetable implements Food{
    String color;
    String name;
    public Vegetable(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return this.name;
    }

    public String getColor(){
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
