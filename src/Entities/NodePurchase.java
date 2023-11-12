package Entities;
import Collections.SimpleNode;

public class NodePurchase extends SimpleNode {
    Purchase purchase;
    public NodePurchase(){}
    public NodePurchase(Purchase purchase){
        this.purchase=purchase;
    }
    public NodePurchase(Purchase purchase, SimpleNode Liga){
        this.purchase=purchase;
        super.setLiga(Liga);
    }
    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public NodePurchase getLiga() {
        return (NodePurchase) super.getLiga();
    }

}