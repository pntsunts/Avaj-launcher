package src.vehicles;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) {

        if (latitude < 0)
            this.latitude = 0;
        else
            this.latitude = latitude;
        if (longitude < 0)
            this.longitude = 0;
        else
            this.longitude =longitude;
        if (height < 1)
            this.height = 0;
        else if (height > 100)
            this.height = 100;
        else
        {
            this.height = height;
        }
    }
    public int getLongitude() {
        return this.longitude;
    }
    public int getLatitude(){
        return this.latitude;
    }
    public  int getHeight(){
        return this.height;
    }
}