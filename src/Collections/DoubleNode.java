package Collections;

public class DoubleNode {
    public DoubleNode LigaD, LigaI;
    //Metodos
    public DoubleNode(DoubleNode ligaD, DoubleNode ligaI) {
        LigaD = ligaD;
        LigaI = ligaI;
    }
    public DoubleNode() {
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
