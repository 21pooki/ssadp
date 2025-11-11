import java.util.*;

// Iterator interface
interface MenuIterator {
    boolean hasNext();
    String next();
}

// Menu class
class Menu {
    private List<String> items = new ArrayList<>();

    public void addItem(String item) {
         items.add(item); 
         }
    public MenuIterator createIterator() {
         return new MenuItemsIterator(items);
          }

    // Concrete Iterator
    private static class MenuItemsIterator implements MenuIterator {
        private List<String> items;
        private int position = 0;

        MenuItemsIterator(List<String> items){ 
            this.items = items; 
            }

        public boolean hasNext(){ 
            return position < items.size(); 
            }
        public String next(){ 
            return items.get(position++);
             }
    }
}

// Client
class DesigningMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu breakfast = new Menu();
        Menu lunch = new Menu();
        Menu dinner = new Menu();

        System.out.println("Enter items for Breakfast (comma separated): ");
        String[] bItems = sc.nextLine().split(",");
        for(String item : bItems) breakfast.addItem(item.trim());

        System.out.println("Enter items for Lunch (comma separated): ");
        String[] lItems = sc.nextLine().split(",");
        for(String item : lItems) lunch.addItem(item.trim());

        System.out.println("Enter items for Dinner (comma separated): ");
        String[] dItems = sc.nextLine().split(",");
        for(String item : dItems) dinner.addItem(item.trim());

        System.out.println("\nBreakfast Menu:");
        MenuIterator it = breakfast.createIterator();
        while(it.hasNext()) System.out.println("- " + it.next());

        System.out.println("\nLunch Menu:");
        it = lunch.createIterator();
        while(it.hasNext()) System.out.println("- " + it.next());

        System.out.println("\nDinner Menu:");
        it = dinner.createIterator();
        while(it.hasNext()) System.out.println("- " + it.next());

        sc.close();
    }
}
