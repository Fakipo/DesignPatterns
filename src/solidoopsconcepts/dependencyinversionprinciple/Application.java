package solidoopsconcepts.dependencyinversionprinciple;

public class Application {
    public static void main(String [] args){
        System.out.println("Hello billy");
        LightBulbBE be = new LightBulbBE();
        SwitchBE switchBE = new SwitchBE();
        switchBE.operate();
        // but if we had to change lets say from lightbulb to fan we have to change the code
        // that is why in the good example we use an interface and pass the interface so that
        // we can use any of the object that implements the switchable interface
        // this allows us to have flexibility, that is changing the type of object (implementing the
        // same interface) but still The switch will work without any changes.

        // good example
        Fan fan = new Fan();
        LightBulbGE lightBulbGE = new LightBulbGE();
        SwitchGE s1 = new SwitchGE(lightBulbGE);
        s1.operate();
        s1 = new SwitchGE(fan);
        s1.operate();

    // In the good example, we can pass either a fan or a light bulb, and both will work.
    // This shows that our high-level module (SwitchGE) doesn't care about the details.
    // It depends only on the Switchable interface — this is the essence of DIP!
    }
}

// Bad Example

class LightBulbBE {
    public void turnOn() {
        System.out.println("Hello light bulb you go on");
    }
}

class SwitchBE {
    private LightBulbBE bulb = new LightBulbBE();  // Direct dependency

    public void operate() {
        bulb.turnOn();
    }
}

// Good Example

interface Switchable {
    void turnOn();
}

class LightBulbGE implements Switchable {
    public void turnOn() {
        System.out.println("Light bulb always go bling bling");
    }
}

class Fan implements Switchable{
    public void turnOn() {
        System.out.println("Fan go zing zing");
    }
}

class SwitchGE {
    private Switchable device;

    public SwitchGE(Switchable device) {
        this.device = device;
    }

    public void operate() {
        device.turnOn();
    }
}