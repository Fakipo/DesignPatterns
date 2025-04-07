package solidoopsconcepts.loosecoupling;

public class Application {
    public static void main(String[] args){
        System.out.println("hello sir how are you?");

        Engine electricEngine = new ElectricEngine();
        Engine petrolEngine = new PetrolEngine();

        CarTC c1 = new CarTC();
        c1.start();
        // we cannot run c1.start with petrol engine without changing the code of class CarTC


        // But we can do that below in loosely coupled code
        CarLC c2 = new CarLC(electricEngine);
        c2.start();

        CarLC c3 = new CarLC(petrolEngine);
        c3.start();
    }
}

// First we write the code for tightly coupled stuff naming it TC as suffix

class CarTC {
    ElectricEngine engine;
    public CarTC(){
        this.engine = new ElectricEngine();
    }
    public void start(){
        engine.turnOn();
        System.out.println("Car is running");
    }
}

interface Engine{
    public void turnOn();
}

class PetrolEngine implements Engine{
    @Override
    public void turnOn(){
        System.out.println("This is Petrol engine");
    }
}

class ElectricEngine implements Engine{
    @Override
    public void turnOn(){
        System.out.println("This is the Electric Engine");
    }
}


// loosely coupled code

class CarLC {
    Engine engine;

    public CarLC(Engine engine){
        this.engine  = engine;
    }

    public void start(){
        this.engine.turnOn();
        System.out.println("Car LC Started");
    }
}