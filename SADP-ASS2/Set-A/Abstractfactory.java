import java.util.Scanner;

// Abstract Products
interface Photo { void click(); }
interface Video { void record(); }

// Concrete Products
class IPhonePhoto implements Photo {
     public void click() {
         System.out.println("iPhone: Clicking photo"); 
         } }
class IPhoneVideo implements Video { 
    public void record() { 
        System.out.println("iPhone: Recording video");
         } }

class SamsungPhoto implements Photo { 
    public void click() { 
        System.out.println("Samsung: Clicking photo"); 
        } }
class SamsungVideo implements Video {
     public void record() { 
        System.out.println("Samsung: Recording video");
         } }

// Abstract Factory
interface MobileFactory { 
    Photo createPhoto(); 
    Video createVideo(); 
    }

// Concrete Factories
class IPhoneFactory implements MobileFactory {
    public Photo createPhoto() {
         return new IPhonePhoto(); 
         }
    public Video createVideo() { 
        return new IPhoneVideo();
         }
}

class SamsungFactory implements MobileFactory {
    public Photo createPhoto() {
         return new SamsungPhoto(); 
         }
    public Video createVideo() { 
        return new SamsungVideo(); 
        }
}

// Client
class AbstractFactory{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Choose phone (iPhone/Samsung): ");
        String phone = sc.next();

        MobileFactory factory = phone.equalsIgnoreCase("iPhone") ? new IPhoneFactory() : new SamsungFactory();

        System.out.print("Choose action (photo/video): ");
        String action = sc.next();

        if (action.equalsIgnoreCase("photo")) {
            factory.createPhoto().click();
        } else if (action.equalsIgnoreCase("video")) {
            factory.createVideo().record();
        } else {
            System.out.println("Invalid action!");
        }

        sc.close();
    }
}
