package service.stockobserver;

import java.util.ArrayList;
import java.util.List;

// Subject
public class AdminUI {
    private List<Observer> stockAlerts = new ArrayList<>();

    public void addAlert(Observer o){
        stockAlerts.add(o);
    }

    public void removeAlert(Observer o){
        stockAlerts.remove(o);
    }


    // iterate through all alerts
    public void notify(String msg){
        for(Observer o : stockAlerts){
            o.update();
        }
    }

}
