package src.vehicles;

import src.output.Output;
import src.weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable{

    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        String apply = "JetPlane#" + this.name + "(" + this.id + ")";

        Output.writeToFile(apply);

        if (weather.equals("SUN")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
            Output.writeToFile(" The Sun is shining!!");
            Output.writeToFile("\n");
        }
        else if (weather.equals("RAIN")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 5, coordinates.getHeight() + 0);
            Output.writeToFile(" Careful the lightning!!");
            Output.writeToFile("\n");
        }
        else if (weather.equals("FOG")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 1, coordinates.getHeight() + 0);
            Output.writeToFile(" we cannot the cities the Fog ishhh!!");
            Output.writeToFile("\n");
        }
        else if (weather.equals("SNOW")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 0, coordinates.getHeight() - 7);
            Output.writeToFile(" The wind is cold!!");
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
        Output.writeToFile("Tower say: JetPlane# " + this.name +"( "+ this.id + ")"+ "registered to tower");
        Output.writeToFile("\n");
    }
}