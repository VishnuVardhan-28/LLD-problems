package Payment;

public class UpiPayment implements PaymentStrategy{
    @Override
    public void processPayment(double amount) {
        System.out.println("Payment done using upi $ " + amount);
    }
}
