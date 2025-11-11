import java.util.*;

// Observable
class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    private void measurementsChanged() {
        setChanged();  // mark as changed
        notifyObservers();  // notify all observers
    }

    public float getTemperature() {
         return temperature;
          }
    public float getHumidity() {
         return humidity;
          }
    public float getPressure() { 
        return pressure;
         }
}

// Observer
class Display implements Observer {
    private WeatherData weatherData;

    public Display(WeatherData wd) {
        this.weatherData = wd;
        wd.addObserver(this);  // register observer
    }

    public void update(Observable o, Object arg) {
        System.out.println("\nWeather Update:");
        System.out.println("Temperature: " + weatherData.getTemperature() + "°C");
        System.out.println("Humidity: " + weatherData.getHumidity() + "%");
        System.out.println("Pressure: " + weatherData.getPressure() + " hPa");
    }
}

// Client
class WeatherStation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WeatherData weatherData = new WeatherData();
        Display display = new Display(weatherData);

        System.out.print("Enter number of readings: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("\nReading " + i + ":");
            System.out.print("Enter temperature: ");
            float temp = sc.nextFloat();
            System.out.print("Enter humidity: ");
            float hum = sc.nextFloat();
            System.out.print("Enter pressure: ");
            float pres = sc.nextFloat();

            weatherData.setMeasurements(temp, hum, pres); // notify observers
        }

        sc.close();
    }
}
