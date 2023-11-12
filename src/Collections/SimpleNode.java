package Collections;

public class SimpleNode {
    private SimpleNode Liga;
    public SimpleNode(SimpleNode liga) {
        this.Liga = null;
    }
    public SimpleNode() {
    }
    public SimpleNode getLiga() {
        return Liga;
    }

    public void setLiga(SimpleNode liga) {
        Liga = liga;
    }
}
