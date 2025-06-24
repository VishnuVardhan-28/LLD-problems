package Payment;

public class DebitCardPayment implements CardPayment{
    @Override
    public void processPayment(double amount) {
        System.out.println("payment done using debit card $ "+ amount);
    }
}
