package designpatterns.facade;

public class DVDPlayer {
    public void on(){
        System.out.println("DVD Player is on");
    }
    public void off(){
        System.out.println("DVD Player is off");
    }
    public void play(String movieName){
        System.out.println("DVD Player is playing + " + movieName);
    }
}
