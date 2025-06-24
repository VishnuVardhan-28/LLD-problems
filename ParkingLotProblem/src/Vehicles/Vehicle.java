package Vehicles;

public abstract class Vehicle {
    private String licensePlate;
    private String vehicleType;

    public Vehicle(String vehicleType, String licensePlate) {
        this.vehicleType = vehicleType;
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getVehicleType() {
        return vehicleType;
    }
    public abstract double calculateFee(int hoursStayed);
}
