import java.util.Scanner;

// ---------- Interfaces ----------
interface IOrderProcessor {
    void processOrder(Order order);
}

// ---------- Order class ----------
class Order {
    String type;
    String customerName;
    double price;

    public Order(String type, String customerName, double price) {
        this.type = type;
        this.customerName = customerName;
        this.price = price;
    }
}

// ---------- SRP: Helper classes ----------
class OrderValidator {
    boolean validate(Order order) {
        if(order.price <= 0 || order.customerName.isEmpty()) {
            System.out.println("Invalid order!");
            return false;
        }
        return true;
    }
}

class PriceCalculator {
    double calculateTotal(Order order) {
        double tax = order.price * 0.1;
        double discount = order.price * 0.05;
        return order.price + tax - discount;
    }
}

class OrderRepository {
    void save(Order order) {
        System.out.println("Order saved for " + order.customerName);
    }
}

class EmailNotifier {
    void notifyCustomer(Order order) {
        System.out.println("Email sent to " + order.customerName);
    }
}

// ---------- OCP: Order processors ----------
class DigitalOrderProcessor implements IOrderProcessor {
    private OrderValidator validator = new OrderValidator();
    private PriceCalculator calculator = new PriceCalculator();
    private OrderRepository repository = new OrderRepository();
    private EmailNotifier notifier = new EmailNotifier();

    public void processOrder(Order order) {
        System.out.println("Processing digital order...");
        if(!validator.validate(order)) return;
        double total = calculator.calculateTotal(order);
        System.out.println("Total price: " + total);
        repository.save(order);
        notifier.notifyCustomer(order);
    }
}

class PhysicalOrderProcessor implements IOrderProcessor {
    private OrderValidator validator = new OrderValidator();
    private PriceCalculator calculator = new PriceCalculator();
    private OrderRepository repository = new OrderRepository();
    private EmailNotifier notifier = new EmailNotifier();

    public void processOrder(Order order) {
        System.out.println("Processing physical order...");
        if(!validator.validate(order)) return;
        double total = calculator.calculateTotal(order);
        System.out.println("Total price: " + total);
        repository.save(order);
        notifier.notifyCustomer(order);
    }
}

// ---------- Main Class ----------
class FSR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter order type (digital/physical): ");
        String type = scanner.nextLine().toLowerCase();

        System.out.print("Enter base price: ");
        double price = scanner.nextDouble();

        Order order = new Order(type, name, price);

        IOrderProcessor processor;
        if(type.equals("digital")) {
            processor = new DigitalOrderProcessor();
        } else {
            processor = new PhysicalOrderProcessor();
        }

        processor.processOrder(order);

        scanner.close();
    }
}
