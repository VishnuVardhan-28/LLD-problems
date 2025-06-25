package Gates;

import ParkingLot.*;
import Payment.PaymentService;
import Vehicles.Vehicle;

public class ExitGate {
    private ParkingLot parkingLot;
    private PaymentService paymentService;

    public ExitGate(ParkingLot parkingLot, PaymentService paymentService) {
        this.parkingLot = parkingLot;
        this.paymentService = paymentService;
    }

    public void processExit(int spotNo, int hoursStayed){
        ParkingSpot parkingSpot = parkingLot.getSpotByNumber(spotNo);
        if(parkingSpot == null){
            System.out.println("Invalid spot !");
            return;
        }
        else if(!parkingSpot.isOccupied()){
            System.out.println("Vacant spot !!");
            return;
        }

        Vehicle vehicle = parkingSpot.getVehicle();
        if(vehicle == null){
            System.out.println("No vehicle found in the spot");
            return;
        }

        double fee = vehicle.calculateFee(hoursStayed);

        paymentService.processPayment(fee);

        parkingLot.vacateSpot(parkingSpot,vehicle);

        System.out.println("Spot vacated successfully");
    }
}
