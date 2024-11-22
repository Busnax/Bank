public class DepositAccount extends Account {
    // CONTO DEPOSITO
    public DepositAccount(String iban, Client owner) {
        super(iban, owner);
    }
    // PRELEVARE
    @Override
    public boolean withdraw(double amount) {
        System.out.println("Withdraw Error: Withdrawal not allowed on Deposit Account.");
        return false;
    }
}