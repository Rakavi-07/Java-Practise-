// Base class
class Weather {
    String condition;

    Weather(String condition) {
        this.condition = condition;
        System.out.println("Weather constructor called: " + condition);
    }

    void showWeather() {
        System.out.println("General weather condition: " + condition);
    }
}

// Multilevel inheritance
class Storm extends Weather {
    int windSpeed;

    Storm(String condition, int windSpeed) {
        super(condition); // call Weather constructor
        this.windSpeed = windSpeed;
        System.out.println("Storm constructor called with wind speed: " + windSpeed);
    }

    @Override
    void showWeather() {
        System.out.println("Stormy weather with wind speed " + windSpeed + " km/h");
    }
}

class Thunderstorm extends Storm {
    boolean lightning;

    Thunderstorm(String condition, int windSpeed, boolean lightning) {
        super(condition, windSpeed); // call Storm constructor
        this.lightning = lightning;
        System.out.println("Thunderstorm constructor called with lightning: " + lightning);
    }

    @Override
    void showWeather() {
        System.out.println("Thunderstorm! Wind speed: " + windSpeed +
                " km/h, Lightning: " + (lightning ? "Yes" : "No"));
    }
}

// Hierarchical inheritance
class Sunshine extends Weather {
    int temperature;

    Sunshine(String condition, int temperature) {
        super(condition); // call Weather constructor
        this.temperature = temperature;
        System.out.println("Sunshine constructor called with temperature: " + temperature);
    }

    @Override
    void showWeather() {
        System.out.println("Sunny day with temperature " + temperature + "°C");
    }
}

// Main class
public class WeatherDemo {
    public static void main(String[] args) {
        System.out.println("=== Creating Objects with Constructor Chaining ===");
        Weather w = new Weather("Generic");
        Storm s = new Storm("Windy", 80);
        Thunderstorm t = new Thunderstorm("Severe Storm", 120, true);
        Sunshine sun = new Sunshine("Clear", 30);

        System.out.println("\n=== Polymorphism with Weather Array ===");
        Weather[] forecasts = {w, s, t, sun};

        for (Weather forecast : forecasts) {
            forecast.showWeather(); // polymorphic call
        }
    }
}
