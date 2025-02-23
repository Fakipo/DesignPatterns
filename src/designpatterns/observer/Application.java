package designpatterns.observer;

public class Application {
    public static void main(String[] args){
        System.out.println("hello this is the observer behavioral pattern");

        Weather weather = new Weather();
        weather.setHumidity(10);
        weather.setTemperature(27);
        weather.setPressure(15);
        // Creating objects of the behaviors
        WeatherMonitorObserver weatherMonitorObserver = new WeatherMonitorObserver(weather);
        WeatherPatternObserver weatherPatternObserver = new WeatherPatternObserver(weather);
        HumidityObserver humidityObserver = new HumidityObserver(weather);
        // Adding the observers to observerlist
        weather.addObserver(weatherMonitorObserver);
        weather.addObserver(weatherPatternObserver);
        weather.addObserver(humidityObserver);
        // executing the behaviors of the objects
        weatherPatternObserver.getWeatherChangeStatus();
        weatherMonitorObserver.displayWeather();
        humidityObserver.getHumidityStatus();
        // Changing the metrics of the publisher (subject)
        weather.setPressure(110);
        weather.setTemperature(200);
        weather.setHumidity(150);
        // Notifying the behavioral objects
        weather.notifyObservers();
        // executing the behaviors of the objects
        weatherPatternObserver.getWeatherChangeStatus();
        weatherMonitorObserver.displayWeather();
        humidityObserver.getHumidityStatus();
    }
}
