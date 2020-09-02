package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.vehicles.AircraftFactory;
import src.weather.WeatherTower;
import src.output.*;



public class Run {
    public static int counter;
    public static void main(String[] args) {
        
        if (args.length == 1)
        {
            validate(args);
            
        }
        else
        {
            System.out.println("NO ARGUMENTS");
        }
    }
    public static void validate(String[] args) {
        WeatherTower weatherTower = new WeatherTower();
    
        try {
            File myfile = new File(args[0]);
            Scanner some = new Scanner(myfile);
            List<String> ls = new ArrayList<>();
            Output.createFile();
            try{
                int i = 0;

                while (some.hasNextLine()) {
                    ls.add(some.nextLine());
                }
                some.close();
            
                if (ls.get(0) != null) {
                    counter = Integer.parseInt(ls.get(0));

                    if (counter <= 0)
                    {
                        System.out.println("Counter must be not be less or equal to 0");
                        System.exit(1);
                    }
                }
                i = 1;
                
                while(i < ls.size()){      
                    
                    String lines[] = ls.get(i).split("\\s+");
                    if (lines.length == 5){
                        try {
                            AircraftFactory
                                    .newAircraft(lines[0], lines[1], Integer.parseInt(lines[2]),
                                            Integer.parseInt(lines[3]), Integer.parseInt(lines[4]))
                                    .registerTower(weatherTower);
                        } catch (Exception e) {
                            System.out.println("Invalid File");
                            System.exit(0);
                        }
                    }
                    else {
                        System.out.println("Error!! Format is TYPE NAME LONGITUDE LATITUDE HEIGHT ");
                        System.exit(1);
                    }
                    i++;
                }
            }
            catch (Exception e){
            System.out.println("Error occured");
            }
        }
        catch (FileNotFoundException e){
            System.out.println("ERROR FILE NOT FOUND");
            e.printStackTrace();
        }
        while (counter > 0)
        {
            weatherTower.changeWeather();
            counter--;
        }
        Output.closeWriter();
    }
}