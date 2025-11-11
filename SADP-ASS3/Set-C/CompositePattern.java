import java.util.*;

// Component
interface Employee {
    void showDetails();
}

// Leaf
class Worker implements Employee {
    private String name;
    private String role;

    public Worker(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public void showDetails() {
        System.out.println(role + ": " + name);
    }
}

// Composite
class Manager implements Employee {
    private String name;
    private String role;
    private List<Employee> team = new ArrayList<>();

    public Manager(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public void add(Employee e) { team.add(e); }
    public void remove(Employee e) { team.remove(e); }

    public void showDetails() {
        System.out.println(role + ": " + name);
        for (Employee e : team) {
            System.out.print("   "); // indent for hierarchy
            e.showDetails();
        }
    }
}

// Client
class CompositePattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter manager name: ");
        String mgrName = sc.nextLine();
        Manager manager = new Manager(mgrName, "Manager");

        System.out.print("Enter number of team members: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter employee type (worker/manager): ");
            String type = sc.nextLine().toLowerCase();
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            if (type.equals("worker")) {
                System.out.print("Enter role: ");
                String role = sc.nextLine();
                manager.add(new Worker(name, role));
            } else if (type.equals("manager")) {
                manager.add(new Manager(name, "Manager"));
            } else {
                System.out.println("Invalid type, skipping...");
            }
        }

        System.out.println("\nEmployee Hierarchy:");
        manager.showDetails();

        sc.close();
    }
}
