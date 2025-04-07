package lld.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("hello this is parking lot application");

        Vehicle car = new Car();
        Level l1 = new Level1(List.of(new ParkingSpot(false, "Car"), new ParkingSpot(true, "Truck")));
        ParkingSpotStatus parkingSpotStatus = l1.isParkingSpotAvailable(car);
        System.out.println("parking spot availability = " + parkingSpotStatus.isAvailable());
        if (parkingSpotStatus.isAvailable()){
            l1.addVehicle(car, parkingSpotStatus.getSpotNo());
        }
        System.out.println("parking spot availability = " + l1.isParkingSpotAvailable(car).isAvailable());
        l1.removeVehicle(car);
        System.out.println("parking spot availability = " + l1.isParkingSpotAvailable(car).isAvailable());
    }
}


//Designing a Parking Lot System
//Requirements
//The parking lot should have multiple levels, each level with a certain number of parking spots.
//The parking lot should support different types of vehicles, such as cars, motorcycles, and trucks.
//Each parking spot should be able to accommodate a specific type of vehicle.
//The system should assign a parking spot to a vehicle upon entry and release it when the vehicle exits.
//The system should track the availability of parking spots and provide real-time information to customers.
//The system should handle multiple entry and exit points and support concurrent access.



interface Vehicle{
    public String getVehicleType();
    public String getVehicleId();
}

class Car implements Vehicle{
    private String name;
    private String id;
    @Override
    public String getVehicleType(){
        return "Car";
    }
    public String getVehicleId(){
        return this.id;
    }
    public void setVehicleId(String id){
        this.id = id;
    }
}

class Truck implements Vehicle{
    private String name;
    private String id;
    @Override
    public String getVehicleType(){
        return this.getClass().getName();
    }
    public String getVehicleId(){
        return this.id;
    }
    public void setVehicleId(String id){
        this.id = id;
    }
}

interface Level {
    public ParkingSpotStatus isParkingSpotAvailable(Vehicle vehicle);
    public void addVehicle(Vehicle vehicle, int spotNo);
    public void removeVehicle(Vehicle vehicle);
}

class Level1 implements Level{
    private List<ParkingSpot> listParkingSpot;
    public Level1(List<ParkingSpot> listParkingSpot){
        this.listParkingSpot = new ArrayList<>();
        for(ParkingSpot parkingSpot : listParkingSpot){
            this.listParkingSpot.add(parkingSpot);
        }
    }
    @Override
    public ParkingSpotStatus isParkingSpotAvailable(Vehicle vehicle){
        ParkingSpotStatus parkingSpotStatus = new ParkingSpotStatus();
        for(int i = 0 ; i < listParkingSpot.size() ; i++) {
            if (!listParkingSpot.get(i).isOccupied() && vehicle.getVehicleType()
                    .equals(listParkingSpot.get(i).getVehicleType())) {
                parkingSpotStatus.setAvailable(true);
                parkingSpotStatus.setSpotNo(i);
            }
        }
        return parkingSpotStatus;
    }

    @Override
    public void addVehicle(Vehicle vehicle, int spotNo) {
        this.listParkingSpot.get(spotNo).setVehicle(vehicle);
        this.listParkingSpot.get(spotNo).setOccupied(true);
    }

    @Override
    public void removeVehicle(Vehicle vehicle){
        for(ParkingSpot parkingSpot : listParkingSpot){
            if(parkingSpot.getVehicleType().equals(vehicle.getVehicleType())){
                parkingSpot.setOccupied(false);
            }
        }
    }
}

class ParkingSpotStatus{
    private boolean isAvailable;
    private int spotNo;

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getSpotNo() {
        return spotNo;
    }

    public void setSpotNo(int spotNo) {
        this.spotNo = spotNo;
    }
}

class ParkingSpot {
    private boolean isOccupied;
    private Vehicle vehicle;
    private String vehicleType;

    public ParkingSpot(boolean isOccupied, String vehicleType){
        this.vehicleType = vehicleType;
        this.isOccupied = isOccupied;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}

