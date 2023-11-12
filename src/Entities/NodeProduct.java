package Entities;
import Collections.DoubleNode;

public class NodeProduct extends DoubleNode {
    Product product;
    public NodeProduct () {}
    public NodeProduct (Product product, DoubleNode ligaDerecha, DoubleNode ligaIzquierda)
    {
        this.product = product;
        super.setLigaD(ligaDerecha);
        super.setLigaI(ligaIzquierda);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    public NodeProduct getLigaI() {
        return (NodeProduct) super.getLigaD();
    }

}