package designpatterns.observer;

import java.util.Observable;

public class WeatherMonitorObserver implements Observer {
    private int temperature;
    private int humidity;
    private int pressure;
    public WeatherMonitorObserver(Weather weather) {
        this.temperature = weather.getTemperature();
        this.humidity = weather.getHumidity();
        this.pressure = weather.getPressure();
    }

    @Override
    public void update(int temperature, int humidity, int pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public void displayWeather(){
        System.out.println("Temperature: " + temperature);
        System.out.println("Humidity: " + humidity);
        System.out.println("Pressure: " + pressure);
    }
}
