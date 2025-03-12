package designpatterns.visitor;

public class Application {
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        Rectangle rectangle = new Rectangle(5, 5);
        Triangle triangle = new Triangle(10, 5);

        ShapeVisitor areaShapeVisitor = new AreaShapeVisitor();
        areaShapeVisitor.visit(circle);
        areaShapeVisitor.visit(rectangle);
        areaShapeVisitor.visit(triangle);
        System.out.println();
        ShapeVisitor nameShapeVisitor = new PrintShapeVisitor();
        nameShapeVisitor.visit(circle);
        nameShapeVisitor.visit(rectangle);
        nameShapeVisitor.visit(triangle);
    }
}
