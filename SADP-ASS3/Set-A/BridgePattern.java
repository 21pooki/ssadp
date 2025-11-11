import java.util.Scanner;

// Implementor interface: VehicleWorkshop
interface Workshop {
    void work();
}

// Concrete Implementors
class ProduceWorkshop implements Workshop {
    public void work() {
        System.out.print("Produced ");
    }
}

class AssembleWorkshop implements Workshop {
    public void work() {
        System.out.print("Assembled ");
    }
}

// Abstraction: Vehicle
abstract class Vehicle {
    protected Workshop workshop1;
    protected Workshop workshop2;

    protected Vehicle(Workshop w1, Workshop w2) {
        this.workshop1 = w1;
        this.workshop2 = w2;
    }

    abstract void manufacture();
}

// Refined Abstractions
class Car extends Vehicle {
    Car(Workshop w1, Workshop w2) { super(w1, w2); }

    void manufacture() {
        workshop1.work();
        workshop2.work();
        System.out.println("Car.");
    }
}

class Bike extends Vehicle {
    Bike(Workshop w1, Workshop w2) { super(w1, w2); }

    void manufacture() {
        workshop1.work();
        workshop2.work();
        System.out.println("Bike.");
    }
}

// Client
 class BridgePattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose vehicle to manufacture:");
        System.out.println("1. Car");
        System.out.println("2. Bike");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        Workshop produce = new ProduceWorkshop();
        Workshop assemble = new AssembleWorkshop();
        Vehicle vehicle;

        if (choice == 1) {
            vehicle = new Car(produce, assemble);
        } else if (choice == 2) {
            vehicle = new Bike(produce, assemble);
        } else {
            System.out.println("Invalid choice!");
            sc.close();
            return;
        }

        vehicle.manufacture(); // Produce and assemble the chosen vehicle
        sc.close();
    }
}
