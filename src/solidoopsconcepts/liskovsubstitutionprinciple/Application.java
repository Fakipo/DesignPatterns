package solidoopsconcepts.liskovsubstitutionprinciple;

public class Application {
    public static void main(String[] args){
        System.out.println("Hello world");
        OstrichBE ob = new OstrichBE();
//        ob.fly();    we comment this error calling code
        OstrichGE og = new OstrichGE();
        og.run();
        Bird be = new Sparrow();
        be.fly();
    }
}

class Bird {
    public void fly(){
        System.out.println("yes flying");
    }
}

class OstrichBE extends Bird{
    @Override
    public void fly(){
        throw new RuntimeException();
    }
}

// To correct we do something like


class Sparrow extends  Bird{
    @Override
    public void fly(){
        System.out.println("Sparrow fly fly away");
    }
}

// dont extend if it does not satisfy all of the parent functions
class OstrichGE {
    public void run() {
        System.out.println("run run run");
    }
}
