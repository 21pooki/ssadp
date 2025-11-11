import java.util.*;

// Receiver
class CeilingFan {
    private String[] speeds = {"OFF", "LOW", "MEDIUM", "HIGH"};
    private int speed = 0;

    public void setSpeed(int s) {
        speed = s;
        System.out.println("Ceiling Fan is " + speeds[speed]);
    }

    public int getSpeed() { return speed; }
}

// Client with simple undo
 class CeilingFanUndo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CeilingFan fan = new CeilingFan();
        Stack<Integer> history = new Stack<>();

        while (true) {
            System.out.println("\nEnter command: 0=OFF, 1=LOW, 2=MEDIUM, 3=HIGH, 4=UNDO, 5=EXIT");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            if (choice == 5) break;
            if (choice == 4) 
            {
                if (!history.isEmpty()) 
                {
                    int prev = history.pop();
                    fan.setSpeed(prev);
                }
                 else System.out.println("Nothing to undo!");
            } 
            else if (choice >= 0 && choice <= 3)
             {
                history.push(fan.getSpeed());
                fan.setSpeed(choice);
            } else System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
