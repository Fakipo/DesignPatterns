package designpatterns.facade;

public class Projector {

    public void on(){
        System.out.println("Projector is on");
    }
    public void off(){
        System.out.println("Projector is off");
    }
    public void setInput(DVDPlayer dvdPlayer){
        System.out.println("Setting input to Dvd player");
    }
}
