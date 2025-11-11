import java.util.Scanner;

// 1. Small, focused interfaces
interface Workable {
    void work();
}

interface Feedable {
    void eat();
}

interface Restable {
    void sleep();
}

interface Payable {
    void getPaid();
}

// 2. HumanWorker implements all four interfaces
class HumanWorker implements Workable, Feedable, Restable, Payable {
    @Override
    public void work() { System.out.println("Human working..."); }

    @Override
    public void eat() { System.out.println("Human eating..."); }

    @Override
    public void sleep() { System.out.println("Human sleeping..."); }

    @Override
    public void getPaid() { System.out.println("Human getting paid..."); }
}

// 3. RobotWorker implements only Workable and Payable
class RobotWorker implements Workable, Payable {
    @Override
    public void work() { System.out.println("Robot working..."); }

    @Override
    public void getPaid() { System.out.println("Robot getting paid..."); }
}

// 4. Main class
 class ISP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose worker type:");
        System.out.println("1 - Human Worker");
        System.out.println("2 - Robot Worker");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            HumanWorker human = new HumanWorker();
            System.out.println("\n---- Human Worker ----");
            human.work();
            human.eat();
            human.sleep();
            human.getPaid();
        } else if (choice == 2) {
            RobotWorker robot = new RobotWorker();
            System.out.println("\n---- Robot Worker ----");
            robot.work();
            robot.getPaid();
        } else {
            System.out.println("Invalid choice!");
        }

        scanner.close();
    }
}
