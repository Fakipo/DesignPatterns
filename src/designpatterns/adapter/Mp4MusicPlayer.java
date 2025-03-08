package designpatterns.adapter;

public class Mp4MusicPlayer implements Mp4Music {
    @Override
    public void playMP4() {
        System.out.println("Playing MP4 media");
    }
}