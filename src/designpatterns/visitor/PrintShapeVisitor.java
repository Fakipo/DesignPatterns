package designpatterns.visitor;

public class PrintShapeVisitor implements ShapeVisitor {

    @Override
    public void visit(Rectangle rect) {
        System.out.println("printing rect " + "width = " + rect.getWidth() + ", height = " + rect.getHeight());
    }

    @Override
    public void visit(Circle circle) {
        System.out.println("printing circle " + "radius = " + circle.getRadius());

    }

    @Override
    public void visit(Triangle triangle) {
        System.out.println("Printing Triangle " + "height = " + triangle.getHeight() + " base = " + triangle.getBase()); ;
    }
}
