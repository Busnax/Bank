public class DepositAccount extends Account {
    // CONTO DEPOSITO
    public DepositAccount(String iban, Client owner) {
        super(iban, owner);
    }
    // DEPOSITARE
    @Override
    public boolean deposit(double amount) {
        return super.deposit(amount);
    }
    // PRELEVARE
    @Override
    public boolean withdraw(double amount) {
        System.out.println("Withdraw Error: Withdrawal not allowed on Deposit Account.");
        return false;
    }
    @Override
    public void logout() {
    }
    @Override
    public void login(Client client, String password) {
    }
    @Override
    public void changePassword(Client client, String oldPassword, String newPassword) {
    }
}