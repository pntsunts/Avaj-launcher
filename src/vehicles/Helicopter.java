package src.vehicles;

import src.output.Output;
import src.weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        String apply = "Helicopter#" + this.name + "(" + this.id + ")";

        Output.writeToFile(apply);

        if (weather.equals("SUN")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 10, coordinates.getLatitude() + 0, coordinates.getHeight() + 2);
            Output.writeToFile(" Yoooo yoooo it's so hot!!");
            Output.writeToFile("\n");
            
        }
        else if (weather.equals("RAIN")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 5, coordinates.getLatitude() + 0, coordinates.getHeight() + 0);
            Output.writeToFile(" The rain is too much!!");
            Output.writeToFile("\n");
        }
        else if (weather.equals("FOG")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 1, coordinates.getLatitude() + 0, coordinates.getHeight() + 0);
            Output.writeToFile(" I cannot see i am gonna hit the clouds!!");
            Output.writeToFile("\n");
        }
        else if (weather.equals("SNOW")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 0, coordinates.getHeight() + 12);
            Output.writeToFile(" its cold up here!!");
            Output.writeToFile("\n");
        }
        if (this.coordinates.getHeight() < 1)
        {
            Output.writeToFile(apply + " Landing now !!!!");
            Output.writeToFile("\n");
            this.weatherTower.unregister(this);
            Output.writeToFile("Tower Says: " + apply + "Unregistered from the Tower");
            Output.writeToFile("\n");
        }

    }
    
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        Output.writeToFile("Tower say: Helicopter# " + this.name +"( "+ this.id + ")"+ "registered to tower");
        Output.writeToFile("\n");
    }
}