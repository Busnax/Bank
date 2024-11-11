import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    // CONTO GENERALE
    // Fields
    final private String iban;
    private double balance;
    protected Client client;
    private final List<Accountable> accountable;
    // Constructor
    public Account(String iban, Client client) {
        this.iban = iban;
        this.balance = 0;
        this.client = client;
        this.accountable = new ArrayList<>();
    }
    // Getters and Setters
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getIban() {
        return iban;
    }
    // Methods
    // Operation Management
    public abstract boolean withdraw(double amount);
    public boolean deposit(double amount) {
        if(amount >= 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount + " to " + iban);
            return true;
        }else{
            System.out.println("Deposit Error: Amount must be non-negative.");
            return false;
        }
    }
    public void getAccountDetails() {
        System.out.println("Client: " + client.getCf());
        System.out.println("Iban: " + iban);
        System.out.println("Balance: " + balance);
    }
    // WebAccount Management
    public abstract void changePassword(Client client, String oldPassword, String newPassword);
    public abstract void login(Client client, String password);
    public abstract void logout();

    // Accountable Management
    public List<Accountable> getAccountable() {
        return accountable;
    }
    public void addAccountable(Accountable accountable){
        this.accountable.add(accountable);
        System.out.println("Successfully added accountable " + accountable);
    }
}
