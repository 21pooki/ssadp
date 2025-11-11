import java.util.Scanner;

// Prototype interface
interface Shape extends Cloneable {
    Shape clone();  // Prototype method
    void draw();
}

// Concrete Circle
class Circle implements Shape {
    private int radius;

    Circle(int radius) { this.radius = radius; }

    public void draw() { System.out.println("Drawing Circle with radius: " + radius); }

    public Shape clone() {
        return new Circle(this.radius);  // Simple clone
    }
}

// Concrete Rectangle
class Rectangle implements Shape {
    private int width, height;

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void draw() { System.out.println("Drawing Rectangle: " + width + "x" + height); }

    public Shape clone() {
        return new Rectangle(this.width, this.height);  // Simple clone
    }
}

// Client
 class Prototyped {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Choose shape to clone (Circle/Rectangle): ");
        String choice = sc.next();

        Shape original = null;
        if(choice.equalsIgnoreCase("Circle")) {
            System.out.print("Enter radius: ");
            int r = sc.nextInt();
            original = new Circle(r);
        } else if(choice.equalsIgnoreCase("Rectangle")) {
            System.out.print("Enter width: ");
            int w = sc.nextInt();
            System.out.print("Enter height: ");
            int h = sc.nextInt();
            original = new Rectangle(w, h);
        } else {
            System.out.println("Invalid choice!");
            sc.close();
            return;
        }

        System.out.println("\nOriginal Shape:");
        original.draw();

        // Clone the shape
        Shape clonedShape = original.clone();
        System.out.println("Cloned Shape:");
        clonedShape.draw();

        sc.close();
    }
}
