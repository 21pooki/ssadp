import java.util.Scanner;

// 1. Base Bird class
abstract class Bird {
    private String name;

    public Bird(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void eat() {
        System.out.println(name + " is eating.");
    }
}

// 2. FlyingBird interface
interface FlyingBird {
    void fly();
}

// 3. Sparrow class (can fly)
class Sparrow extends Bird implements FlyingBird {
    public Sparrow(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(getName() + " is flying high!");
    }
}

// 4. Penguin class (cannot fly)
class Penguin extends Bird {
    public Penguin(String name) {
        super(name);
    }

    public void swim() {
        System.out.println(getName() + " is swimming!");
    }
}

// 5. Demo class with user input
class LSP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a bird type:");
        System.out.println("1 - Sparrow (can fly)");
        System.out.println("2 - Penguin (cannot fly, can swim)");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter bird name: ");
        String name = scanner.nextLine();

        if (choice == 1) {
            Sparrow sparrow = new Sparrow(name);
            System.out.println("\n---- Sparrow ----");
            sparrow.eat();
            sparrow.fly();
        } else if (choice == 2) {
            Penguin penguin = new Penguin(name);
            System.out.println("\n---- Penguin ----");
            penguin.eat();
            penguin.swim();
        } else {
            System.out.println("Invalid choice!");
        }

        scanner.close();
    }
}
