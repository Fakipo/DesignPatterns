package designpatterns.visitor;

public interface Shape {
    public void accept(ShapeVisitor shapeVisitor);
}
