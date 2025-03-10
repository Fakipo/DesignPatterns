package designpatterns.facade;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello world beautiful place!");
        DVDPlayer dvdPlayer = new DVDPlayer();
        Amplifier amplifier = new Amplifier();
        Projector projector = new Projector();
        Lights lights = new Lights();
        HomeTheatreFacade homeTheatreFacade = new HomeTheatreFacade(amplifier, lights, projector, dvdPlayer);
        homeTheatreFacade.playMovie("Narnia");
        System.out.println();
        homeTheatreFacade.stopMovie();

    }
}
