import java.util.Scanner;

// Thread-safe Singleton using synchronized
class Singleton {
    private static Singleton instance;

    private Singleton() {
        System.out.println("Singleton instance created!");
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}

class SingletonMulti {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of users requesting singleton: ");
        int n = sc.nextInt();

        Runnable task = () -> {
            Singleton s = Singleton.getInstance();
            System.out.println("Got instance: " + s.hashCode());
        };

        Thread[] threads = new Thread[n];
        for (int i = 0; i < n; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        // Wait for all threads to finish
        for (int i = 0; i < n; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        sc.close();
    }
}
