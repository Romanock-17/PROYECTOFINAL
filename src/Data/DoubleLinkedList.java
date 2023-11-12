package Data;

import Collections.DoubleNode;
import Entities.*;
import org.w3c.dom.Node;

import javax.swing.*;
import java.util.Objects;

public class DoubleLinkedList {
    private NodeProduct Head;

    public void FillList(Product product) {
        NodeProduct New = new NodeProduct(product, null, null);
        if ( Head== null) {
            Head = New;
        } else {
            DoubleNode aux = Head;
            while (aux.getLigaD() != null) {
                aux = aux.getLigaD();
            }
            NodeProduct nuevo = new NodeProduct(product, null, aux);
            aux.setLigaD(nuevo);
        }
    }
    public void DeleteNode(int ID){
        NodeProduct Q = (NodeProduct) Head;
        boolean found = false;
        NodeProduct aux = new NodeProduct();
        while(Q != null && !found){
            if(Q.getProduct().getID() == ID){
                aux = Q;
                Q = (NodeProduct) Q.getLigaD();
                Q.setLigaI(aux.getLigaI());
                aux.getLigaI().setLigaD(Q);
                found = true;
                JOptionPane.showMessageDialog(null, "El producto se eliminó exitosamente");
            }else{
                Q = (NodeProduct) Q.getLigaD();
            }
        }
        if(!found) JOptionPane.showMessageDialog(null, "El producto no se encontró en la lista");
    }


    public void ShowProducts(){
        NodeProduct P = Head;
        String show="";
        while(P != null){
            String product = P.getProduct().getName();
            if(product != null) {
                show += product + " ";
                P = (NodeProduct) P.getLigaD();
            }

        }
        JOptionPane.showMessageDialog(null, show);
    }

/*
    public void DeleteNode(int id) {
        NodeProduct Q = (NodeProduct) Head.getLigaD();
        boolean found = false;

        while (Q != null) {
            if (Q.getProduct().getID() == id) {
                // Encontramos el nodo que queremos eliminar
                if (Q.getLigaD() != null) {
                    Q.getLigaD().setLigaI(Q.getLigaI());
                }
                if (Q.getLigaI() != null) {
                    Q.getLigaI().setLigaD(Q.getLigaD());
                }
                found = true;
                JOptionPane.showMessageDialog(null, "El producto se eliminó exitosamente");
                return;  // Salimos del bucle después de encontrar y eliminar el nodo
            } else {
                Q = (NodeProduct) Q.getLigaD();
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "El producto no se encontró en la lista");
        }
    }
*/
    public Product Search(String productName) {
        NodeProduct aux = Head;
        boolean found = false;
        while (aux != null && !found) {
            if (Objects.equals(aux.getProduct().getName(), productName)) {
                found = true;
            }else if(!found){
                aux = (NodeProduct) aux.getLigaD();
            }
        }
        if(found) return aux.getProduct();
        else return null;
    }
    public void Eliminar(int id){
        NodeProduct P =  Head;
        NodeProduct Q = (NodeProduct) P.getLigaD();
        boolean found = false;
        NodeProduct aux=new NodeProduct();
        while(P!=null && Q!=null){
            if(Q.getProduct().getID()==id){
                aux=Q;
                Q=(NodeProduct) Q.getLigaD();
                aux.getLigaD().setLigaI(aux.getLigaI());
                aux.getLigaI().setLigaD(aux.getLigaD());
                found = true;
                JOptionPane.showMessageDialog(null, "El dato se eliminó exitosamente");

            }else{
                Q = (NodeProduct) Q.getLigaD();

            }
        }
        if(!found) JOptionPane.showMessageDialog(null, "El dato no se encontró en la lista");
    }
}
