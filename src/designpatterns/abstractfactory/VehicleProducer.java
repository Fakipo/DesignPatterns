package designpatterns.abstractfactory;

public interface VehicleProducer {
    public Vehicle produceVehicle(int vehicleCategory, int vehicleType);
}
