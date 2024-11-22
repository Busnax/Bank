public class Client {
    //Fields
    private String name;
    private String cf;
    private String password;
    //Constructor
    public Client(String name, String cf) {
        this.name = name;
        this.cf = cf;
        this.password = "changeme";
    }
    //Getters
    public String getName() {
        return name;
    }
    public String getCf() {
        return cf;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}