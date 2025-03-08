package designpatterns.adapter;

// Adapter class correctly implements MediaPlayer
public class Adapter implements MediaPlayer {
    private Mp4Music mp4MusicPlayer;

    public Adapter(Mp4Music mp4MusicPlayer) {
        this.mp4MusicPlayer = mp4MusicPlayer;
    }

    @Override
    public void play() {
        // Converts MediaPlayer interface to Mp4Music interface
        mp4MusicPlayer.playMP4();
    }
}