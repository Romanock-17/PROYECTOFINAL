package Data;

import Entities.NodePurchase;
import Entities.Purchase;

import javax.swing.*;

public class Queue {

    private NodePurchase Head;
    public int limit, top;

    public Queue(int tam){
        this.limit=tam-1;
        this.top=-1;
        this.Head=null;
    }
    public boolean queueEmpty() {
        return top <= -1;
    }

    public void queueUp(Purchase d){
        top++;
        Fill(d);
    }

    public Purchase queueDown(){
        NodePurchase P = Head;
        top--;
        Purchase r = Head.getPurchase();
        Head = Head.getLiga();
        P.setLiga(null);
        return r;
    }

    public void FillQueue(Queue CA){
        Purchase r;
        while (!CA.queueEmpty()){
            r=CA.queueDown();
            queueUp(r);
        }
    }
    public void Fill(Purchase data) {
        NodePurchase New = new NodePurchase();
        New.setPurchase(data);
        if (this.Head == null) {
            this.Head = New;
        } else {
            New.setLiga(this.Head);
            Head = New;
        }
    }
   /* public void Fill(Purchase data) {
        if (Head == null) {
            Head = new NodePurchase(data);
        } else {
            NodePurchase aux = Head;
            while (aux.getLiga() != null) {
                aux = aux.getLiga();
            }
            NodePurchase New2 = new NodePurchase(data);
            aux.setLiga(New2);
        }
    }*/

    public void ShowQueue(){
        NodePurchase aux = Head;
        StringBuilder show = new StringBuilder();
        while(aux != null){
            Purchase P = aux.getPurchase();
            show.append(P.getID()).append(" ").append(P.getUserId()).append(" ").append(P.getDate()).append(" ").append(P.showMP()).append("\n");
            aux=aux.getLiga();
        }
        JOptionPane.showMessageDialog(null, show.toString());
    }
}
