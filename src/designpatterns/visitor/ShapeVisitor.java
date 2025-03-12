package designpatterns.visitor;

public interface ShapeVisitor {
    void visit(Rectangle rect);
    void visit(Circle circle);
    void visit(Triangle triangle);
}
