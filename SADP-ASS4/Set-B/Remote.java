import java.util.*;

// Command interface
interface Command { void execute(); }

// Receiver
class Light {
    public void on() { System.out.println("Light is ON"); }
    public void off() { System.out.println("Light is OFF"); }
}

// Concrete Commands
class LightOn implements Command {
    private Light light; LightOn(Light l){ light=l; }
    public void execute(){ light.on(); }
}
class LightOff implements Command {
    private Light light; LightOff(Light l){ light=l; }
    public void execute(){ light.off(); }
}

// Client
 class Remote {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Light light = new Light();
        Command on = new LightOn(light);
        Command off = new LightOff(light);

        while(true){
            System.out.print("Enter 1=ON, 2=OFF, 3=EXIT: ");
            int c = sc.nextInt();
            if(c==3) break;
            else if(c==1) on.execute();
            else if(c==2) off.execute();
            else System.out.println("Invalid choice!");
        }
        sc.close();
    }
}
