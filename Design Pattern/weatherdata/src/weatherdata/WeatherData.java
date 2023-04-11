package weatherdata;

public class WeatherData {

	private static WeatherData weatherData;

	  private String city;
	  private String temperature;

	  public String getCity() {
	    return city;
	  }

	  public void setCity(String city) {
	    this.city = city;
	  }

	  public String getTemperature() {
	    return temperature;
	  }

	  public void setTemperature(String temperature) {
	    this.temperature = temperature;
	  }

    
    private WeatherData() {

    }

    public static WeatherData getWeather() {
        if (weatherData == null) {
            weatherData = new WeatherData();
        }
        return weatherData;
    }
}

