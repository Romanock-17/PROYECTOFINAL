package Collections;

public class SimpleNode {
    private int ID;
    private String name, lastName,email, user, password;
    private SimpleNode Liga;

    //METODOS
    //Constructor


    public SimpleNode(int ID, String name, String lastName, String email, String user, String password) {
        this.ID = ID;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.user = user;
        this.password = password;
        this.Liga = null;
    }

    public SimpleNode() {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SimpleNode getLiga() {
        return Liga;
    }

    public void setLiga(SimpleNode liga) {
        Liga = liga;
    }
}
