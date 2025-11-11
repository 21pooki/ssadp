import java.util.*;

// Handler
abstract class Approver {
    protected Approver next;
    public void setNext(Approver next)
     {
         this.next = next;
          }
    public abstract void approve(double amount);
}

// Concrete Handlers
class Manager extends Approver {
    public void approve(double amount) {
        if (amount <= 1000) System.out.println("Manager approved $" + amount);
        else if (next != null) next.approve(amount);
    }
}

class SeniorManager extends Approver
 {
    public void approve(double amount)
     {
        if (amount <= 10000) System.out.println("Senior Manager approved $" + amount);
        else if (next != null) next.approve(amount);
    }
}

class Director extends Approver {
    public void approve(double amount) {
        if (amount <= 100000) System.out.println("Director approved $" + amount);
        else System.out.println("Loan amount too high! Cannot approve $" + amount);
    }
}

// Client
 class LoanApproval {

    public static void main(String[] args)
     {
        Scanner sc = new Scanner(System.in);

        // Set up the chain
        Approver manager = new Manager();
        Approver senior = new SeniorManager();
        Approver director = new Director();

        manager.setNext(senior);
        senior.setNext(director);

        System.out.print("Enter loan amount to approve: ");
        double amount = sc.nextDouble();

        manager.approve(amount);  // start chain

        sc.close();
    }
}
