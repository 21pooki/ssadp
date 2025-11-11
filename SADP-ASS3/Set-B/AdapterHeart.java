import java.util.Scanner;

// Target interface: BeatModel
interface BeatModel {
    void setRate(int rate);
    int getRate();
    void start();
    void stop();
}

// Adaptee: HeartModel
class HeartModel {
    private int heartRate;

    public void startHeart() {
        System.out.println("Heart started beating at rate: " + heartRate);
    }

    public void stopHeart() {
        System.out.println("Heart stopped.");
    }

    public void setHeartRate(int rate) {
        heartRate = rate;
    }

    public int getHeartRate() {
        return heartRate;
    }
}

// Adapter: Adapts HeartModel to BeatModel
class HeartAdapter implements BeatModel {
    private HeartModel heart;

    public HeartAdapter(HeartModel heart) {
        this.heart = heart;
    }

    public void setRate(int rate) {
        heart.setHeartRate(rate);
    }

    public int getRate() {
        return heart.getHeartRate();
    }

    public void start() {
        heart.startHeart();
    }

    public void stop() {
        heart.stopHeart();
    }
}

// Client
 class AdapterHeart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HeartModel heart = new HeartModel();
        BeatModel beat = new HeartAdapter(heart);

        System.out.print("Enter heart rate: ");
        int rate = sc.nextInt();

        beat.setRate(rate);
        beat.start();
        System.out.println("Current heart rate: " + beat.getRate());
        beat.stop();

        sc.close();
    }
}
