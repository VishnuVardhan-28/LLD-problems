package Payment;

public class CreditCardPayment implements CardPayment{
    @Override
    public void processPayment(double amount) {
        System.out.println("payment done using credit card $ " + amount);
    }
}
