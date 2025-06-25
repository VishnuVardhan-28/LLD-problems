package Payment;

import java.util.Scanner;

public class PaymentService {
    private Scanner scanner;

    // Constructor to initialize with a Scanner
    public PaymentService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void processPayment(double fee) {
        // Choose payment method and process payment
        choosePaymentMethod(fee);
    }

    public void choosePaymentMethod(double fee) {
        System.out.println("Total fee: " + fee);
        System.out.println("Choose payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. Debit Card");
        System.out.println("3. Cash");
        System.out.println("4. UPI");

        int choice = scanner.nextInt();  // Use the passed scanner

        Payment payment;
        switch (choice) {
            case 1:
                payment = new Payment(fee, new CreditCardPayment());
                break;
            case 2:
                payment = new Payment(fee, new DebitCardPayment());
                break;
            case 3:
                payment = new Payment(fee, new CashPayment());
                break;
            case 4:
                payment = new Payment(fee, new UpiPayment());
                break;
            default:
                System.out.println("Invalid choice! Defaulting to Cash payment.");
                payment = new Payment(fee, new CashPayment());
                break;
        }
        payment.processPayment();
    }
}
