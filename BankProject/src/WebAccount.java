public class WebAccount extends CreditAccount{
    // CONTO WEB
    //Fields
    private boolean changed;
    private boolean locked;
    //Constructor
    public WebAccount(String iban, Client owner) {
        super(iban, owner);
        this.changed = false;
        this.locked = true;
    }
    //Methods
    public boolean isChanged() {
        return changed;
    }
    public boolean isLocked() {
        return locked;
    }
    public void setChanged(boolean changed) {
        this.changed = changed;
    }
    public void setLocked(boolean locked) {
        this.locked = locked;
    }
    public void changePasswordWEB(Client client, String newPassword) {
        if(owner.getPassword().equals(client.getPassword())) {
            owner.setPassword(newPassword);
            System.out.println("Password changed successfully.");
            changed = true;
        }else{
            System.out.println("Change Password Error: Old password incorrect");
            changed = false;
        }
    }
    public void loginWEB(Client client) {
        if (owner.getPassword().equals(client.getPassword()) && !client.getPassword().equals("changeme")) {
            System.out.println("Login Successful");
            locked = false;
        } else {
            System.out.println("Login Error: Incorrect password/Default password not yet changed");
            locked = true;
        }
    }
    public void logoutWEB(){
        System.out.println("Logout Successful");
        locked = true;
    }
    @Override
    public boolean deposit(double amount) {
        if(!locked){
            return super.deposit(amount);
        }else{
            System.out.println("Account LOCKED. Login required.");
            return false;
        }
    }
    @Override
    public boolean withdraw(double amount) {
        if(!locked){
            return super.withdraw(amount);
        }else{
            System.out.println("Account locked. Login required.");
            return false;
        }
    }
    @Override
    public void executeMonthlyTaskACCOUNT() {
        this.locked = false;
        super.executeMonthlyTaskACCOUNT();
        this.locked = true;
    }
}