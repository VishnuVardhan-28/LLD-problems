package Vehicles;

public class CarVehicle extends Vehicle{

    private static final double RATE = 10.0;

    public CarVehicle(String licensePlate) {
        super("Car", licensePlate);
    }

    @Override
    public double calculateFee(int hoursStayed) {
        return hoursStayed * RATE;
    }
}
