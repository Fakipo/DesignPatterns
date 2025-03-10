package designpatterns.facade;

public class HomeTheatreFacade {
    Amplifier amplifier;
    DVDPlayer dvdPlayer;
    Lights lights;
    Projector projector;

    public HomeTheatreFacade(Amplifier amplifier, Lights lights, Projector projector, DVDPlayer dvdPlayer) {
        this.amplifier = amplifier;
        this.lights = lights;
        this.projector = projector;
        this.dvdPlayer = dvdPlayer;
    }

    public void playMovie(String movieName){
        System.out.println("Watching Movie " + movieName);
        lights.dim();
        projector.on();
        dvdPlayer.on();
        projector.setInput(dvdPlayer);
        amplifier.on();
        amplifier.setVolumne(80);
        dvdPlayer.play(movieName);
    }

    public void stopMovie(){
        System.out.println("Stopping Movie");
        lights.on();
        dvdPlayer.off();
        projector.off();
        amplifier.off();
    }
}
