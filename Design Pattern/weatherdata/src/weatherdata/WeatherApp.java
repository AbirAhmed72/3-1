package weatherdata;

public class WeatherApp {
	public static void main(String[] args) {

        WeatherData weatherData = WeatherData.getWeather();

		// WeatherData weatherData = new WeatherData(); 
		// weatherData.setCity("New York");
		// weatherData.setTemperature("72°F");

		// Retrieve and display weather data
		System.out.println("City: " + weatherData.getCity());
		System.out.println("Temperature: " + weatherData.getTemperature());
	}
}
