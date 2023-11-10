package Data;

import Collections.DoubleNode;

import javax.swing.*;

public class DoubleLinkedList {
    private DoubleNode Head;


    public void Insert(int ID, String name, double price, int amount, String description) {
        if ( Head == null) {
            DoubleNode New = new DoubleNode(ID, name, price, amount, description, null,null);
            Head = New;
        } else {
            DoubleNode aux = Head;
            while (aux.getLigaD() != null) {
                aux = aux.getLigaD();
            }
            DoubleNode nuevo = new DoubleNode(ID, name, price, amount,description, null, aux);
            aux.setLigaD(nuevo);
        }
    }
    public void DeleteNode(int ID){
        DoubleNode Q = Head.getLigaD();
        boolean found = false;
        DoubleNode aux = new DoubleNode();
        while(Q != null){
            if(Q.getID() == ID){
                aux = Q;
                Q = Q.getLigaD();
                aux.getLigaD().setLigaI(aux.getLigaI());
                aux.getLigaI().setLigaD(aux.getLigaD());
                found = true;
                JOptionPane.showMessageDialog(null, "El producto se eliminó exitosamente");

            }else{
                Q=Q.getLigaD();
            }
        }
        if(!found) JOptionPane.showMessageDialog(null, "El producto no se encontró en la lista");
    }

}
