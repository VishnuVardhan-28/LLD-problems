package Gates;

import ParkingLot.*;
import Vehicles.Vehicle;
import Vehicles.VehicleFactory;

import java.util.Scanner;

public class EntranceGate {
    private ParkingLot parkingLot;

    public EntranceGate(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void processEntrance(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the vehicle number: ");
        String licensePlate = scanner.next();
        System.out.println("Enter the vehicle type (Car or Bike) : ");
        String vehicleType = scanner.next();

        Vehicle vehicle = VehicleFactory.createVehicle(vehicleType,licensePlate);
        if(vehicle == null){
            System.out.println("Invalid Vehicle Type!!");
            return;
        }

        ParkingSpot parkingSpot = parkingLot.parkVehicle(vehicle);

        if(parkingSpot != null){
            System.out.println("Vehicle parked in the spot : " + parkingSpot.getSpotNumber() + " Successfully");
        }else{
            System.out.println("No available parking spots for the vehicle type");
        }

    }
}
