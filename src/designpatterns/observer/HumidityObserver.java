package designpatterns.observer;

public class HumidityObserver implements Observer{
    public int humidity;
    public HumidityObserver(Weather weather){
        this.humidity = weather.getHumidity();
    }

    public void update(int temperature, int humidity, int pressure){
        this.humidity = humidity;
    }

    public void getHumidityStatus(){
        if(this.humidity > 100){
            System.out.println("Humidity is high");
        }else if(this.humidity < 75){
            System.out.println("Humidity is low");
        }else{
            System.out.println("Humidity is normal");
        }
    }
}
