package designpatterns.abstractfactory;

public class VehicleProduction implements VehicleProducer{

    @Override
    public Vehicle produceVehicle(int vehicleCategory, int vehicleType) {
        Vehicle vehicle;
        VehicleFactory vehicleFactory;
        if(vehicleCategory == 1){
            vehicleFactory = new RegularVehicleClass();
        }else if(vehicleCategory == 2){
            vehicleFactory = new ElectricVehicleClass();
        }else{
            return null;
        }

        if(vehicleType == 1){
            vehicle = vehicleFactory.createBike();
        }else if(vehicleType == 2){
            vehicle = vehicleFactory.createCar();
        }else {
            return null;
        }
        return vehicle;
    }
}
