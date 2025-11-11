import java.util.Scanner;

// Component
interface Pizza {
    String getDescription();
    double getCost();
}

// Concrete Component
class PlainPizza implements Pizza {
    public String getDescription() { 
        return "Plain Pizza"; 
        }
    public double getCost() {
         return 5.0; 
         }
}

// Decorator
abstract class Topping implements Pizza {
    protected Pizza pizza;
    public Topping(Pizza pizza) { 
        this.pizza = pizza;
         }
}

// Concrete Decorators
class Cheese extends Topping {
    public Cheese(Pizza pizza) {
         super(pizza); 
         }
    public String getDescription() {
         return pizza.getDescription() + ", Cheese";
          }
    public double getCost() {
         return pizza.getCost() + 2.0;
          }
}

class Olives extends Topping {
    public Olives(Pizza pizza) {
         super(pizza);
     }
    public String getDescription() {
         return pizza.getDescription() + ", Olives";
          }
    public double getCost() { 
        return pizza.getCost() + 1.5;
         }
}

class Mushrooms extends Topping {
    public Mushrooms(Pizza pizza) {
         super(pizza);
          }
    public String getDescription() {
         return pizza.getDescription() + ", Mushrooms";
          }
    public double getCost() {
         return pizza.getCost() + 2.5;
          }
}

// Client
class PizzaDecorators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pizza pizza = new PlainPizza();

        System.out.println("Base pizza: " + pizza.getDescription());
        System.out.println("Add toppings (type 'done' to finish): cheese, olives, mushrooms");

        while (true) {
            System.out.print("Add topping: ");
            String input = sc.nextLine().toLowerCase();
            if (input.equals("done")) break;

            switch (input) {
                case "cheese": pizza = new Cheese(pizza); break;
                case "olives": pizza = new Olives(pizza); break;
                case "mushrooms": pizza = new Mushrooms(pizza); break;
                default: System.out.println("Invalid topping!");
            }
        }

        System.out.println("\nFinal Pizza: " + pizza.getDescription());
        System.out.println("Total Cost: $" + pizza.getCost());
        sc.close();
    }
}
