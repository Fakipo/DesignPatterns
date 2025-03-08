//package designpatterns.adapter;
//// Existing MediaPlayer interface
//interface MediaPlayer {
//    void play(String audioType, String fileName);
//}
//
//// Existing AudioPlayer class (Supports only MP3)
//class AudioPlayer implements MediaPlayer {
//    public void play(String audioType, String fileName) {
//        if (audioType.equalsIgnoreCase("mp3")) {
//            System.out.println("Playing MP3 file: " + fileName);
//        } else {
//            System.out.println("Invalid format: " + audioType + " not supported.");
//        }
//    }
//}
//
//// Test before adding adapter
//public class MediaPlayerExample {
//    public static void main(String[] args) {
//        MediaPlayer player = new AudioPlayer();
//        player.play("mp3", "song.mp3");   // Works
//        player.play("mp4", "movie.mp4");  // Fails
//    }
//}