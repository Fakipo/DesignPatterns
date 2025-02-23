package designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherPatternObserver implements Observer {
    private List<Integer> pressure;
    String pressureStatus;
    public WeatherPatternObserver(Weather weather) {
        pressure = new ArrayList<>();
        this.pressure.add(weather.getPressure());
        pressureStatus = "only 1 day record seems good";
    }

    @Override
    public void update(int temperature, int humidity, int pressure) {
        if(this.pressure.getLast() < pressure){
            pressureStatus = "Weather Improving";
        }else if(this.pressure.get(this.pressure.size() - 1) > pressure){
            pressureStatus = "Weather Getting worse";
        }else{
            pressureStatus = "weather is same";
        }
        this.pressure.add(pressure);
    }

    public void getWeatherChangeStatus(){
        System.out.println(pressureStatus);
    }
}
