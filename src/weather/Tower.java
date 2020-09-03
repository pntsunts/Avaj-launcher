package src.weather;

import java.util.ArrayList;
import java.util.List;

import src.vehicles.Flyable;

public abstract class Tower {
    private List<Flyable> observers = new ArrayList<>();

    private boolean check =  false;

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable){
        check = true;
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        int i = 0;
        while (i < observers.size()){
            if (check == true){  
                i--;
                check = false;
            }
            observers.get(i).updateConditions();
            i++;
        }
    }
}
