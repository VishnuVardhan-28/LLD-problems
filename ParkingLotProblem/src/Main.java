import Gates.EntranceGate;
import Gates.ExitGate;
import ParkingLot.ParkingFloor;
import ParkingLot.ParkingLot;
import Payment.PaymentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Parking world!");
        Scanner scanner = new Scanner(System.in);

        ParkingFloor parkingFloor = new ParkingFloor(1,2,3);
        List<ParkingFloor> parkingFloorList = new ArrayList<>();
        parkingFloorList.add(parkingFloor);

        ParkingLot parkingLot = new ParkingLot(parkingFloorList);
        PaymentService paymentService = new PaymentService(scanner);
        EntranceGate entranceGate = new EntranceGate(parkingLot);
        ExitGate exitGate = new ExitGate(parkingLot,paymentService);
        System.out.println("\n********************************************");
        System.out.println("     Welcome to PARKING LOT SYSTEM!!!!!!!   ");
        System.out.println("********************************************");

        boolean exit = false;
        while(!exit){
            showMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    // Park a vehicle via the entrance gate
                    parkVehicle(entranceGate);
                    break;

                case 2:
                    // Vacate a parking spot via the exit gate
                    vacateSpot(exitGate, scanner);
                    break;

                case 3:
                    // Exit the session
                    exit = true;
                    System.out.println("Thank you for using the Parking Lot System!");
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
                    break;
            }
        }
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n******************************************************");
        System.out.println("Please choose an option from below:");
        System.out.println("1. Park a vehicle");
        System.out.println("2. Vacate a vehicle spot");
        System.out.println("3. Exit the system");
        System.out.println("******************************************************");
    }

    private static int getUserChoice(Scanner scanner) {
        return scanner.nextInt();
    }

    private static void parkVehicle(EntranceGate entranceGate) {
        entranceGate.processEntrance();
    }

    private static void vacateSpot(ExitGate exitGate, Scanner scanner) {
        System.out.println("Enter the spot number to vacate: ");
        int spotNumber = scanner.nextInt();
        System.out.println("Enter the number of hours the vehicle stayed: ");
        int hoursStayed = scanner.nextInt();
        exitGate.processExit(spotNumber, hoursStayed);
    }
}