package designpatterns.abstractfactory;

public class RegularVehicleClass implements VehicleFactory{

    @Override
    public Car createCar() {
        return new RegularCar();
    }

    @Override
    public Bike createBike() {
        return new RegularBike();
    }
}
