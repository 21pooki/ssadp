import java.util.Scanner;

class LoggerService {
    private static LoggerService instance;

    private LoggerService() {
        System.out.println("LoggerService instance created!");
    }

    public static synchronized LoggerService getInstance() {
        if (instance == null) {
            instance = new LoggerService();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

 class Logger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of users requesting LoggerService: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume leftover newline here

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter message for user " + i + ": ");
            String msg = sc.nextLine();

            LoggerService logger = LoggerService.getInstance();
            logger.log(msg);
            System.out.println("Logger instance hash code: " + logger.hashCode());
            System.out.println();
        }

        sc.close();
    }
}
