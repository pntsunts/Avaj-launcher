package src.weather;

import src.vehicles.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();

    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    WeatherProvider(){

    }
    public WeatherProvider getProvider(){
        return WeatherProvider.weatherProvider;
    }
    public String getCurrentWeather(Coordinates coordinates){
        int times = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
        return weather[times % 4];
    }
}