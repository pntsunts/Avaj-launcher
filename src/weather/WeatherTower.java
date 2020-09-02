package src.weather;

import src.vehicles.*;

public class WeatherTower extends Tower {
    WeatherProvider weatherProvider = new WeatherProvider(); 

    public String getWeather(Coordinates coordinates)
    {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public void changeWeather(){
        this.conditionsChanged();
    }   
}