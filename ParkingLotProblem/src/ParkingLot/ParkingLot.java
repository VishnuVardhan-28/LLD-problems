package ParkingLot;


import Vehicles.Vehicle;

import java.util.List;

public class ParkingLot {
    private List<ParkingFloor> parkingFloors;

    public ParkingLot(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public ParkingSpot findAvailableSpot(String vehicleType){
        for(ParkingFloor parkingFloor : parkingFloors){
            ParkingSpot spot = parkingFloor.findAvailableSpot(vehicleType);
            if(spot != null) return spot;
        }
        return null;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle){
        ParkingSpot spot = findAvailableSpot(vehicle.getVehicleType());
        if(spot!=null){
            spot.parkVehicle(vehicle);
            System.out.println("Vehicle parked successfully in spot : " + spot.getSpotNumber());
            return spot;
        }
        System.out.println("No parking spots available for " + vehicle.getVehicleType() + "!");
        return null;
    }

    public void vacateSpot(ParkingSpot parkingSpot, Vehicle vehicle){
        if(parkingSpot != null && parkingSpot.isOccupied() && parkingSpot.getVehicle().equals(vehicle)){
            parkingSpot.vacate();
            System.out.println(vehicle.getVehicleType() + " vacated the spot : " + parkingSpot.getSpotNumber());
        }
        else{
            System.out.println("invalid operation! either the spot is already vacant or the vehicle doesnot match.");
        }
    }

    public ParkingSpot getSpotByNumber(int spotNumber){
        for(ParkingFloor parkingFloor : parkingFloors){
            for(ParkingSpot parkingSpot : parkingFloor.getSpots()){
                if(parkingSpot.getSpotNumber() == spotNumber){
                    return parkingSpot;
                }
            }
        }
        return null;
    }
}
