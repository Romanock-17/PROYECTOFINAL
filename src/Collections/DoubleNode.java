package Collections;

public class DoubleNode {
    //Atributos
    private int ID, Amount;
    double Price;
    private String Name, Description;
    private DoubleNode LigaD, LigaI;

    //Metodos


    public DoubleNode(int ID, String name, double price, int amount, String description, DoubleNode ligaD, DoubleNode ligaI) {
        this.ID = ID;
        Amount = amount;
        Price = price;
        Name = name;
        Description = description;
        LigaD = ligaD;
        LigaI = ligaI;
    }

    public DoubleNode() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public DoubleNode getLigaD() {
        return LigaD;
    }

    public void setLigaD(DoubleNode ligaD) {
        LigaD = ligaD;
    }

    public DoubleNode getLigaI() {
        return LigaI;
    }

    public void setLigaI(DoubleNode ligaI) {
        LigaI = ligaI;
    }
}
