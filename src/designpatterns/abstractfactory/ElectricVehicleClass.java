package designpatterns.abstractfactory;

public class ElectricVehicleClass implements VehicleFactory{

    @Override
    public Car createCar() {
        return new ElectricCar();
    }

    @Override
    public Bike createBike() {
        return new ElectricBike();
    }
}
