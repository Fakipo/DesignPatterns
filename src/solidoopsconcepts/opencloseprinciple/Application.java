package solidoopsconcepts.opencloseprinciple;

public class Application {
    public static void main(String [] args){
        System.out.println("We are here learning solid oops OCP");

        //Bad Example Call
        FruitBE appleBE = new AppleBE();
        FruitSelectorBE fruitSelectorBE = new FruitSelectorBE();
        fruitSelectorBE.selectFruit(appleBE);

        // If let's say I make a new anonymous class, our method will not give us results

        FruitBE peachBE = new FruitBE() {
            private String name = "Peach";
            @Override
            public String getName() {
                return this.name;
            }
        };
        fruitSelectorBE.selectFruit(peachBE);

        // There will be no printing here

        // Good Example
        // Now lets try same case in GE
        FruitGE appleGE = new AppleGE();
        FruitSelectorGE fruitSelectorGE = new FruitSelectorGE();
        fruitSelectorGE.selectFruit(appleGE);

        FruitGE peachGE = new FruitGE() {
            private String name = "Peach";
            @Override
            public String getNameModified() {
                return "The " + getName() + " smells good";
            }
            public String getName() {
                return this.name;
            }
        };

        fruitSelectorGE.selectFruit(peachGE);

//        This will get printed while the other will not this means our code
//        can be extended as we can make more
//        classes of the Fruit type without having to change the code of fruit selector


    }
}

// This design principle says that once written code should never be changed but
// it should have extension to be changed
// meaning that It should be open to extension but close to changes in existing code


// First we will see the bad example


interface FruitBE {
    public String getName();
}
class AppleBE implements FruitBE{
    private String name = "apple";

    public String getName(){
        return this.name;
    }
}

class OrangeBE implements  FruitBE{
    private String name = "Orange";
    public String getName(){
        return this.name;
    }
}

class FruitSelectorBE{
    public void selectFruit(FruitBE fruitBE){
        if(fruitBE instanceof AppleBE){
            System.out.println("fruit is " + fruitBE.getName() + " each day keeps doctor away");
        }else if(fruitBE instanceof  OrangeBE){
            System.out.println("fruit is " + fruitBE.getName() + " squish to clear eyes");
        }
        // Now if we want to add another fruit here later, we will need to write another function in existing code
    }
}


// Good Example

interface FruitGE{
    public String getNameModified();
}

class AppleGE implements FruitGE{
    private String name = "apple";
    public String getNameModified(){
        return ("fruit is " + getName() + " each day keeps doctor away");
    }
    public String getName(){
        return this.name;
    }
}

class OrangeGE implements  FruitGE{
    private String name = "Orange";
    public String getNameModified(){
        return ("fruit is " + getName() + " squish to clear eyes");
    }
    public String getName(){
        return this.name;
    }
}


class FruitSelectorGE{
    public void selectFruit(FruitGE fruitGE){
        System.out.println(fruitGE.getNameModified());
    }
}

