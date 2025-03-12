package designpatterns.visitor;

public class AreaShapeVisitor implements ShapeVisitor {

    @Override
    public void visit(Rectangle rect) {
        System.out.println("area of rect = " + (rect.getHeight() * rect.getWidth()));
    }

    @Override
    public void visit(Circle circle) {
        System.out.println("area of circle = " + ((double) (3.14 * circle.getRadius() * circle.getRadius())));

    }

    @Override
    public void visit(Triangle triangle) {
        System.out.println("area of Triangele = " + ((double) (0.5 * triangle.getBase() * triangle.getHeight())));
    }


}
