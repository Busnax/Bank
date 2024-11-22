public class Subscrictions implements Accountable{
    private final double amount;
    public Subscrictions(double amount) {
        this.amount = amount;
    }
    @Override
    public boolean isCredit() {
        return false;
    }
    @Override
    public double getAmount() {
        return amount;
    }
}