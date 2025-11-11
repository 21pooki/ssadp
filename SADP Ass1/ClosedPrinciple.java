import java.util.Scanner;

abstract class Shape {
    public abstract double calculateArea();
}

class Circle extends Shape {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Square extends Shape {
    private double side;
    public Square(double side) {
        this.side = side;
    }
    @Override
    public double calculateArea() {
        return side * side;
    }
}

class Triangle extends Shape {
    private double base;
    private double height;
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

//  This must match the filename ClosedPrinciple.java
 class ClosedPrinciple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a shape (circle, square, triangle): ");
        String shapeType = scanner.nextLine().toLowerCase();

        Shape shape = null;

        switch (shapeType) {
            case "circle":
                System.out.print("Enter radius: ");
                double radius = scanner.nextDouble();
                shape = new Circle(radius);
                break;
            case "square":
                System.out.print("Enter side length: ");
                double side = scanner.nextDouble();
                shape = new Square(side);
                break;
            case "triangle":
                System.out.print("Enter base: ");
                double base = scanner.nextDouble();
                System.out.print("Enter height: ");
                double height = scanner.nextDouble();
                shape = new Triangle(base, height);
                break;
            default:
                System.out.println("Invalid shape!");
                System.exit(0);
        }

        System.out.println("Area = " + shape.calculateArea());
        scanner.close();
    }
}
