import java.util.Scanner;

// Abstract Products
interface Car { 
    void model();
     }
interface Specification {
     void details(); 
     }

// Concrete Products for North America
class NorthAmericaCar implements Car {
     public void model() { 
        System.out.println("North America Car: SUV");
         } }
class NorthAmericaSpec implements Specification { 
    public void details() { 
        System.out.println("Specifications: Left-hand drive, Emission Std EPA"); 
        } }

// Concrete Products for Europe
class EuropeCar implements Car {
     public void model() {
         System.out.println("Europe Car: Hatchback");
          } }
class EuropeSpec implements Specification { 
    public void details() {
         System.out.println("Specifications: Right-hand drive, Emission Std Euro 6"); 
         } }

// Abstract Factory
interface CarFactory {
     Car createCar(); Specification createSpec();
      }

// Concrete Factories
class NorthAmericaFactory implements CarFactory {
    public Car createCar() {
         return new NorthAmericaCar();
         }
    public Specification createSpec() { 
        return new NorthAmericaSpec(); 
        }
}

class EuropeFactory implements CarFactory {
    public Car createCar() {
         return new EuropeCar(); 
         }
    public Specification createSpec() {
         return new EuropeSpec();
         }
}

// Client
 class AbstractFactoryCars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Choose region (NorthAmerica/Europe): ");
        String region = sc.next();

        CarFactory factory;
        if(region.equalsIgnoreCase("NorthAmerica")) {
            factory = new NorthAmericaFactory();
        } else if(region.equalsIgnoreCase("Europe")) {
            factory = new EuropeFactory();
        } else {
            System.out.println("Invalid region!");
            sc.close();
            return;
        }

        factory.createCar().model();
        factory.createSpec().details();

        sc.close();
    }
}
