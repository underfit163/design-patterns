package observer;

import java.util.ArrayList;
import java.util.List;

public class CObservable implements Observable{
    private List<Observer> observers;

    @Override
    public void addObserver(Observer o) {
        if(observers == null) {
            observers = new ArrayList<>();
        }
        observers.add(o);
    }

    @Override
    public void notifyObserver() {
        for (var o:
             observers) {
            o.update();
        }
    }

    @Override
    public void removeObserver() {

    }
}
