package solidoopsconcepts.interfacesegregationprinciple;

public class Application {
    public static void main(String [] args){
        System.out.println("We are in interface segregation principle");

        WorkerBE be = new RobotBE();
        be.work();
//        be.eat();  commented exception throwing code

        // we dont need eat in robot, so this interface is not really useful to us
        // or not applicable


        // there fore we create a new interface and dont keep eat method in it
        WorkerGE ge = new RobotGE();
        ge.work();
    }

    // So basically this principle means if there is an interface which has a lot of implementations
    // that the client does not require, then the client should not be using that interface,
    // it should then have a separate interface with less number of inputs.


}

// Bad Example

interface WorkerBE {
    public void work();
    public void eat();
}

class RobotBE implements WorkerBE{
    @Override
    public void work(){
        System.out.println("good boy work");
    }
    public void eat() {
        // leaving empty or throwing exceptions like below
        throw new UnsupportedOperationException();
    }
}

// Rather than doing this, do below

interface WorkerGE{
    public void work();
}

class RobotGE implements WorkerGE{
    public void work(){
        System.out.println("Good robot always works not eat");
    }
}