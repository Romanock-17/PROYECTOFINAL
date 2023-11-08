package Data;

import Collections.DoubleNode;

public class DoubleLinkedList {
    private DoubleNode Head;


    public void FillList(int ID, String name, double price, int amount, String description) {
        if ( Head== null) {
            DoubleNode New = new DoubleNode();
            Head = New;
        } else {
            DoubleNode aux = Head;
            while (aux.getLigaD() != null) {
                aux = aux.getLigaD();
            }
            DoubleNode nuevo = new DoubleNode();
            aux.setLigaD(nuevo);
            nuevo.setLigaI(aux);
        }
    }


}
