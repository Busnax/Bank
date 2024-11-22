public class Main {
    public static void main(String[] args) {
        Client client1 = new Client("Mario Rossi", "MARROS001");
        Client client2 = new Client("Giorgio Vanni", "GIOVAN002");
        Client client3 = new Client("Mario Bianchi", "MARBIA003");

        Bank bank1 = new Bank("UBI", 10);
        Bank bank2 = new Bank("POPSO", 5);

        System.out.println("----ACCOUNT #1----");
        Account account1 = bank1.addAccount(client1, AccountType.DEPOSIT);
        account1.getAccountDetails();
        bank1.operation(account1, 100.30);
        account1.getAccountDetails();
        bank1.operation(account1, -50);
        account1.getAccountDetails();

        System.out.println("----ACCOUNT #2----");
        Account account2 = bank2.addAccount(client2, AccountType.CREDIT);
        account2.getAccountDetails();
        bank2.operation(account2, 7000.70);
        account2.getAccountDetails();
        bank2.operation(account2, -12);
        account2.getAccountDetails();

        System.out.println("----ACCOUNT #3----");
        Account account3 = bank2.addAccount(client3, AccountType.WEB);
        account3.getAccountDetails();
        bank2.operation(account3, 510);
        account3.getAccountDetails();
        bank2.operation(account3, -10);
        account3.getAccountDetails();

        bank2.login((WebAccount) account3, client3);
        bank2.changePassword((WebAccount) account3, client3,"password");
        bank2.operation(account3, 510);
        bank2.login((WebAccount) account3, client3);
        bank2.operation(account3, 510);
        bank2.logout((WebAccount) account3);

        System.out.println("----BANKS TOTAL BALANCES----");
        System.out.println("Total Balance of " + bank1.getName() + " is: $ " + bank1.totalBalance());
        System.out.println("Total Balance of " + bank2.getName() + " is: $ " + bank2.totalBalance());

        System.out.println("----ACCOUNTABLES----");
        Salary salary1 = new Salary (1500);
        Salary salary2 = new Salary (2000);
        Salary salary3 = new Salary (3000);
        Subscrictions sub1 = new Subscrictions(50);
        Subscrictions sub2 = new Subscrictions(100);
        Subscrictions sub3 = new Subscrictions(150);

        bank1.addAccountableToAccount(account1.getIban(), salary1);
        bank1.addAccountableToAccount(account1.getIban(), sub1);

        bank2.addAccountableToAccount(account2.getIban(), salary2);
        bank2.addAccountableToAccount(account2.getIban(), sub1);
        bank2.addAccountableToAccount(account2.getIban(), sub2);

        bank2.addAccountableToAccount(account3.getIban(), salary3);
        bank2.addAccountableToAccount(account3.getIban(), sub1);
        bank2.addAccountableToAccount(account3.getIban(), sub3);

        bank1.executeMonthlyTasks();
        bank2.executeMonthlyTasks();

        account1.getAccountDetails();
        account2.getAccountDetails();
        account3.getAccountDetails();
    }
}