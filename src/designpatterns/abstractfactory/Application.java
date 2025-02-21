package designpatterns.abstractfactory;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Creating new vehicle");
        System.out.println("Select what vehicle category to create press 1 for Regular and 2 for Electric");

        Scanner ob = new Scanner(System.in);
        int selectedCategory = ob.nextInt();

        System.out.println("Select type of vehicle to create press 1 for Bike and 2 for Car");
        VehicleProduction vehicleProduction = new VehicleProduction();
        int selectedType = ob.nextInt();

        Vehicle vehicle = vehicleProduction.produceVehicle(selectedCategory,selectedType);
        if(vehicle == null){
            System.out.println("Invalid input");
            return;
        }
        System.out.println(vehicle.getName());


    }
}
