import java.util.Scanner;

// Subject interface
interface Image {
    void display();
}

// RealSubject: Loads the actual image
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading " + filename + " from disk...");
    }

    public void display() {
        System.out.println("Displaying " + filename);
    }
}

// Proxy: Controls access to RealImage
class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) {  // Load only when needed
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// Client
 class ProxyPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of images to display: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        Image[] images = new Image[n];

        // Take image filenames from user
        for (int i = 0; i < n; i++) {
            System.out.print("Enter filename for image " + (i+1) + ": ");
            String filename = sc.nextLine();
            images[i] = new ProxyImage(filename);
        }

        System.out.println("\nDisplaying images:");
        for (int i = 0; i < n; i++) {
            images[i].display();
        }

        sc.close();
    }
}
