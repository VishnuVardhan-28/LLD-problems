package Payment;

public class CashPayment implements PaymentStrategy{
    @Override
    public void processPayment(double amount) {
        System.out.println("payment done using cash $ " + amount);
    }
}
