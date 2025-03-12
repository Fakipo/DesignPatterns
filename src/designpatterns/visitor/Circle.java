package designpatterns.visitor;

public class Circle implements Shape {
    int radius;
    public Circle(int radius) {
        this.radius = radius;
    }
    @Override
    public void accept(ShapeVisitor shapeVisitor) {
        shapeVisitor.visit(this);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
