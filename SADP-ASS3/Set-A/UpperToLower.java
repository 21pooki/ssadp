import java.util.Scanner;

public class UpperToLower{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String input = sc.nextLine();

        // Convert to lowercase
        String lower = input.toLowerCase();

        System.out.println("Converted text: " + lower);

        sc.close();
    }
}
