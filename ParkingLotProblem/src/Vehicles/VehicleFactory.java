package Vehicles;

public class VehicleFactory {

    public static Vehicle createVehicle(String vehicleType, String licensePlate){
        if(vehicleType.equalsIgnoreCase("car")){
            return new CarVehicle(licensePlate);
        }
        else if(vehicleType.equalsIgnoreCase("bike")){
            return new BikeVehicle(licensePlate);
        }
        else return null;
    }
}
