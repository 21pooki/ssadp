import java.util.Scanner;

// Thread-safe Singleton (simple version using synchronized)
class DatabaseConnection {
    private static DatabaseConnection instance;

    private DatabaseConnection() {
        System.out.println("Database Connection created!");
    }

    public static synchronized DatabaseConnection getConnection() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}

// Client with user input
class Singleton {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Get Database Connection");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                DatabaseConnection conn = DatabaseConnection.getConnection();
                System.out.println("Got connection instance: " + conn.hashCode());
            } else if (choice == 2) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }

        sc.close();
    }
}
