import java.util.*;

// Memento
class GumballMemento {
    private final int gumballs;
    private final boolean hasQuarter;

    public GumballMemento(int gumballs, boolean hasQuarter) {
        this.gumballs = gumballs;
        this.hasQuarter = hasQuarter;
    }

    public int getGumballs() { 
        return gumballs; 
        }
    public boolean hasQuarter() {
         return hasQuarter;
          }
}

// Originator
class GumballMachine {
    private int gumballs;
    private boolean hasQuarter = false;

    public GumballMachine(int gumballs) {
         this.gumballs = gumballs; 
         }

    public void insertQuarter() {
        if (hasQuarter) System.out.println("Quarter already inserted!");
        else {
             hasQuarter = true; System.out.println("Quarter inserted.");
              }
    }

    public void ejectQuarter() {
        if (hasQuarter) {
             hasQuarter = false; System.out.println("Quarter returned.");
              }
        else System.out.println("No quarter to eject!");
    }

    public void turnCrank() {
        if (!hasQuarter) System.out.println("Insert quarter first!");
        else if (gumballs <= 0) System.out.println("No gumballs left!");
        else {
            gumballs--;
            hasQuarter = false;
            System.out.println("Gumball dispensed!");
        }
    }

    public void displayState() {
        System.out.println("Gumballs: " + gumballs + ", Quarter inserted: " + hasQuarter);
    }

    public GumballMemento saveState() {
        return new GumballMemento(gumballs, hasQuarter);
    }

    public void restoreState(GumballMemento memento) {
        this.gumballs = memento.getGumballs();
        this.hasQuarter = memento.hasQuarter();
        System.out.println("State restored!");
    }
}

// Client
 class MementoGumballMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter initial number of gumballs: ");
        int num = sc.nextInt();

        GumballMachine machine = new GumballMachine(num);
        GumballMemento savedState = machine.saveState();

        while (true) {
            System.out.println("\nActions: 1=Insert Quarter, 2=Eject Quarter, 3=Turn Crank, 4=Display, 5=Save State, 6=Restore State, 7=Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> machine.insertQuarter();
                case 2 -> machine.ejectQuarter();
                case 3 -> machine.turnCrank();
                case 4 -> machine.displayState();
                case 5 -> { savedState = machine.saveState(); System.out.println("State saved."); }
                case 6 -> machine.restoreState(savedState);
                case 7 -> { System.out.println("Exiting..."); sc.close(); return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
