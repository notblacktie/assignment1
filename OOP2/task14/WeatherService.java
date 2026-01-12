package assignment2.OOP2.task14;

public class WeatherService {
    public static void showWeather(City city) {
        System.out.println("In the city of " + city.getName()
                + " today, the temperature is " + city.getTemperature());
    }
}
