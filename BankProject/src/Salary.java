public class Salary implements Accountable{
    private final double amount;
    public Salary(double amount) {
        this.amount = amount;
    }
    @Override
    public boolean isCredit() {
        return true;
    }
    @Override
    public double getAmount() {
        return amount;
    }
}