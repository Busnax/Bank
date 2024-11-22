public class CreditAccount extends Account{
    // CONTO CORRENTE
    //Constructor
    public CreditAccount(String iban, Client owner) {
        super(iban, owner);
    }
    //Methods
    // DEPOSITARE
    @Override
    public boolean deposit(double amount) {
        return super.deposit(amount);
    }
    // PRELEVARE
    @Override
    public boolean withdraw(double amount) {
        if(amount > 0 && amount <= super.getBalance()) {
            double newBalance = super.getBalance() - amount;
            super.setBalance(newBalance);
            System.out.println("Successfully withdrawn $" + amount + " from " + super.getIban());
            return true;
        }else{
            System.out.println("Withdrawal Error: Insufficient balance in " + super.getIban());
            return false;
        }
    }
}
