package src.vehicles;

import src.output.Output;
import src.weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    
    private WeatherTower weatherTower;

    
    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        String apply = "Baloon#" + this.name + "(" + this.id +   ")";

        //System.out.printf("%s", apply);
        Output.writeToFile(apply);

        if (weather.equals("SUN")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 2, coordinates.getLatitude() + 0, coordinates.getHeight() + 4);
            Output.writeToFile(" Let's enjoy the Sun");
            Output.writeToFile("\n");
        }
        else if (weather.equals("RAIN")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 0, coordinates.getHeight() - 5);
            Output.writeToFile(" Showers from heaven!!");
            Output.writeToFile("\n");
        }
        else if (weather.equals("FOG")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 0, coordinates.getHeight() - 3);
            Output.writeToFile(" Cant see my Baloon in the Fog!!");
            Output.writeToFile("\n");
        }
        else if (weather.equals("SNOW")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 0, coordinates.getHeight() - 15);
            Output.writeToFile(" The baloon is too Cold!!");
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
        Output.writeToFile("Tower say: Baloon# " + this.name +"( "+ this.id + ")"+ "registered to tower");
        Output.writeToFile("\n");
    }
}