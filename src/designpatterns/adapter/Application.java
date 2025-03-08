package designpatterns.adapter;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello world, how are you?");

        // MP3 Player (Direct Usage)
        MediaPlayer mp3Player = new MP3MediaPlayer();
        mp3Player.play();

        // MP4 Player (Using Adapter)
        Mp4Music mp4Player = new Mp4MusicPlayer();
        MediaPlayer adaptedMp4Player = new Adapter(mp4Player);
        adaptedMp4Player.play();
    }
}
