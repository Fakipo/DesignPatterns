package designpatterns.adapter;

public class MP3MediaPlayer implements MediaPlayer {
    @Override
    public void play() {
        System.out.println("Playing MP3 media");
    }
}