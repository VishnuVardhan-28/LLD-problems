package ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private List<ParkingSpot> spots;
    private int floorNumber;

    public ParkingFloor(int floorNumber, int noOfCarSpots, int noOfBikeSpots) {
        this.floorNumber = floorNumber;
        this.spots = new ArrayList<>();

        for(int i=0; i<noOfCarSpots; i++){
            this.spots.add(new CarParkingSpot(i+1));
        }
        for(int i=noOfCarSpots; i<noOfCarSpots+noOfBikeSpots; i++){
            this.spots.add(new BikeParkingSpot(i+1));
        }
    }

    public ParkingSpot findAvailableSpot(String vehicleType) {
        for (ParkingSpot spot : spots) {
            if(!spot.isOccupied() && spot.getSpotType().equalsIgnoreCase(vehicleType)){
                return spot;
            }
        }
        return null;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }
}
