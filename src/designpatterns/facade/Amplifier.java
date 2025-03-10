package designpatterns.facade;

public class Amplifier {
    public void on() {
        System.out.println("Amplifier on");
    }
    public void off() {
        System.out.println("Amplifier off");
    }
    public void setVolumne(int vol) {
        System.out.println("Amplifier setVolumne = " + vol);
    }
}
