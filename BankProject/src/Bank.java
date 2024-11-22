public class Bank {
    // Fields
    private final String name;
    private final Account[] accounts;
    private int activeAccounts;
    private final String ibanRoot;

    // Constructor
    public Bank(String name, int maxAccounts) {
        this.name = name;
        this.activeAccounts = 0;
        this.accounts = new Account[maxAccounts];
        ibanRoot = "IT00000" + name + "000";
    }

    // Methods
    public String getName() {
        return name;
    }

    // Gives an Account based on its unique iban
    public Account getAccount(String iban) {
        for (int i = 0; i < activeAccounts; i++) {
            if (accounts[i].getIban().equals(iban)) {
                return accounts[i];
            }
        }
        return null;
    }

    // Adds a new account to the bank using switch case
    public Account addAccount(Client client, AccountType type) {
        if (activeAccounts < accounts.length) {
            String iban = ibanRoot + (activeAccounts + 1);
            Account account;
            switch (type) {
                case DEPOSIT:
                    account = new DepositAccount(iban, client);
                    break;
                case CREDIT:
                    account = new CreditAccount(iban, client);
                    break;
                case WEB:
                    account = new WebAccount(iban, client);
                    break;
                default:
                    System.out.println("Invalid account type");
                    return null;
            }
            accounts[activeAccounts] = account;
            activeAccounts++; // Increment activeAccounts after adding the account
            return account;
        } else {
            System.out.println("Add Account Error: Bank is FULL.");
            return null;
        }
    }

    // Calculates the total balance stored in a bank
    public double totalBalance() {
        double total = 0;
        for (int i = 0; i < activeAccounts; i++) {
            total += accounts[i].getBalance();
        }
        return total;
    }

    public void operation(Account account, double amount) {
        if (account != null) {
            if (amount > 0) {
                account.deposit(amount);
            } else if (amount < 0) {
                account.withdraw(-amount);
            } else {
                System.out.println("Operation Error: Withdrawal not allowed on Deposit Account.");
            }
        } else {
            System.out.println("Operation Error: Account not found.");
        }
    }
    // WEB ACCOUNT MANAGEMENT
    public void login(WebAccount webAccount, Client client){
        webAccount.loginWEB(client);
    }

    public void changePassword(WebAccount webAccount, Client client, String newPassword) {
        webAccount.changePasswordWEB(client, newPassword);
    }

    public void logout(WebAccount webAccount){
        webAccount.logoutWEB();
    }

    // ACCOUNTABLE MANAGEMENT
    public void addAccountableToAccount(String iban, Accountable accountable) {
        Account account = getAccount(iban);
        if (account == null) {
            System.out.println("Accountable Error: Account with Iban" + iban + "not found.");
        } else {
            account.addAccountable(accountable);
        }
    }

    public void executeMonthlyTasks() {
        for (int i = 0; i < activeAccounts; i++) {
            Account account = accounts[i];
            account.executeMonthlyTaskACCOUNT();
        }
    }
}