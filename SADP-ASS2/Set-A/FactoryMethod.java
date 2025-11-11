import java.util.Scanner;

// Product
abstract class Pizza {
    String name;
    void prepare() {
     System.out.println("Preparing " + name); 
     }
    void bake()    {
         System.out.println("Baking " + name); 
         }
    void cut() { 
        System.out.println("Cutting " + name); 
        }
    void box() {
         System.out.println("Boxing " + name); 
         }
}

// Concrete Products
class NYCheesePizza extends Pizza { NYCheesePizza(){ name="NY Cheese Pizza"; } }
class ChicagoCheesePizza extends Pizza { 
    ChicagoCheesePizza(){ name="Chicago Cheese Pizza"; }
    void cut(){ System.out.println("Cutting " + name + " into squares"); }
}

// Creator
abstract class PizzaStore {
    Pizza orderPizza(String type) {
        Pizza p = createPizza(type);
        if(p!=null){ p.prepare(); p.bake(); p.cut(); p.box(); }
        return p;
    }
    abstract Pizza createPizza(String type);
}

// Concrete Creators
class NYStore extends PizzaStore {
    Pizza createPizza(String type){ return type.equalsIgnoreCase("cheese")? new NYCheesePizza():null; }
}
class ChicagoStore extends PizzaStore {
    Pizza createPizza(String type){ return type.equalsIgnoreCase("cheese")? new ChicagoCheesePizza():null; }
}

// Client
class FactoryMethod {
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        System.out.print("Store (NyStyleCheesePizza/Chicago): "); String store=sc.next();
        System.out.print("Pizza type: "); String type=sc.next();

        PizzaStore ps = store.equalsIgnoreCase("NY")? new NYStore(): new ChicagoStore();
        Pizza p = ps.orderPizza(type);
        if(p!=null) System.out.println("You ordered a " + p.name);
        else System.out.println("Pizza not available!");
    }
}
