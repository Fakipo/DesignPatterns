package designpatterns.prototype;

public class Circle implements Shape {

    int radius;
    int area;
    Color color;
    public Circle(int radius, int area, Color color) {
        this.radius = radius;
        this.area = area;
        this.color = color;
    }
    @Override
    public Shape clone() {
        return new Circle(this.radius, this.area, this.color);
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle with radius " + radius + " and area " + area + " and color " + color.getColorName());
    }
}
