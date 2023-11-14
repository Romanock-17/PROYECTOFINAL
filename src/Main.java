import Data.DoubleLinkedList;
import Data.Stack;
import Data.Queue;
import Entities.*;

import javax.swing.*;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = 0, data = 0;
        Stack Stack1 = new Stack(10);
        //Stack Stack2 = new Stack(10);
        //Stack Stack3 = new Stack(10);
        DoubleLinkedList newList1= new DoubleLinkedList();
        Queue Queue1 = new Queue(10);
        //Queue Queue2 = null;
        //Queue Queue3 = null;

        do{
            String menu = "MENÚ\n" +
                    "1- Agregar usuario\n" +
                    "2- Agregar productos\n" +
                    "3- Lista de compra\n" +
                    "4- Mostrar usuarios\n" +
                    "5- Mostrar productos\n" +
                    "6- Reporte de compra\n" +
                    "7- Eliminar usuario\n" +
                    "8- Eliminar Producto\n" +
                    "9- Eliminar Compra\n" +
                    "10- Modificar compra\n" +
                    "11- Salir";

            String opcio = JOptionPane.showInputDialog(null, menu, "Menú de Opciones", JOptionPane.INFORMATION_MESSAGE);
            option = Integer.parseInt(opcio);

            switch (option){
                case 1:
                    User user = new User();
                    user.setID(Integer.parseInt(JOptionPane.showInputDialog("ID: ")));
                    user.setName(JOptionPane.showInputDialog("Nombre: "));
                    user.setLastName(JOptionPane.showInputDialog("Apellido: "));
                    user.setEmail(JOptionPane.showInputDialog("Email: "));
                    user.setUserName(JOptionPane.showInputDialog("Usuario: "));
                    user.setPassword(JOptionPane.showInputDialog("Contraseña: "));
                    Stack1.PileUp(user);
                 break;
                case 2:
                    Product product = new Product();
                    product.setID(Integer.parseInt(JOptionPane.showInputDialog("ID: ")));
                    product.setName(String.valueOf(JOptionPane.showInputDialog("Articulo: ")));
                    product.setPrice(Integer.parseInt(JOptionPane.showInputDialog("Precio unitario: ")));
                    product.setAmount(Integer.parseInt(JOptionPane.showInputDialog("Cantidad: ")));
                    product.setDescription(String.valueOf(JOptionPane.showInputDialog("Descripcion: ")));
                    newList1.FillList(product);
                    break;

                case 3:
                    Purchase purchase = new Purchase();
                    purchase.setUserId(Stack1.SearchByUsername(String.valueOf(JOptionPane.showInputDialog("Ingrese usuario: "))).getID());
                    purchase.setDate(String.valueOf(JOptionPane.showInputDialog("Fecha: ")));
                    String moreProducts = "si";
                    while (Objects.equals(moreProducts, "si")){
                        int[] productToEnter = new int[3];
                        Product product1 = newList1.Search(String.valueOf(JOptionPane.showInputDialog("Producto: ")));
                        productToEnter[0] = product1.getID();
                        productToEnter[1] = (Integer.parseInt(JOptionPane.showInputDialog("Cantidad del producto")));
                        productToEnter[2] = (int) product1.getPrice();
                        purchase.pushMP(productToEnter);
                        moreProducts = String.valueOf(JOptionPane.showInputDialog("¿Desea ingresar más datos?"));
                    }
                    Queue1.queueUp(purchase);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Usuarios\n");
                    Stack1.ShowUsers();

                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Productos\n");
                    newList1.ShowProducts();
                    break;
                case 6:
                    Queue1.ShowQueue();
                    break;

                case 7:
                    String eliminarUser = JOptionPane.showInputDialog("Ingrese el ID del usuario a eliminar");
                    data = Integer.parseInt(eliminarUser);
                    Stack1.DeletePile(data);
                    break;
                case 8:
                    String eliminarProducto = JOptionPane.showInputDialog("Ingrese el ID del producto a eliminar");
                    data = Integer.parseInt(eliminarProducto);

                    Product deletedProduct = newList1.DeleteProduct(data);
                    if(deletedProduct != null) {
                        JOptionPane.showMessageDialog(null, "Producto eliminado");
                    }else{
                        JOptionPane.showMessageDialog(null, "Producto no eliminado");
                    }
                    break;

                case 9:
                    String eliminarCompra = JOptionPane.showInputDialog("Ingrese el ID de la compra a eliminar");
                    data = Integer.parseInt(eliminarCompra);
                    Purchase result = Queue1.DeletePurchaseByID(data);
                    if(result != null) {
                        JOptionPane.showMessageDialog(null, "Compra eliminada");
                    }else{
                        JOptionPane.showMessageDialog(null, "Compra no eliminada");
                    }
                    break;

                case 10:
                    String modificarCompra = JOptionPane.showInputDialog("Ingrese el ID de la compra que desea modificar");
                    data = Integer.parseInt(modificarCompra);

                    Purchase oldPurchase = Queue1.SearchById(data);
                    oldPurchase.setDate(String.valueOf(JOptionPane.showInputDialog("Fecha anterior: " + oldPurchase.getDate() + "\n Nueva fecha: "  )));
                    oldPurchase.setUserId(Integer.parseInt(JOptionPane.showInputDialog("Usuario anterior: " + oldPurchase.getDate() + "\n Nuevo usuario: "  )));

                    String moreProductsToModify = (String.valueOf(JOptionPane.showInputDialog("Lista de productos: " + oldPurchase.showMP() + "\n ¿Desea modificar productos?: "  )));

                    while (Objects.equals(moreProductsToModify, "si")){

                        int ModifiedProduct = (Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del producto a modificar: ")));

                        int[] productToEnter = new int[3];
                        Product product1 = newList1.Search(String.valueOf(JOptionPane.showInputDialog("Producto: ")));
                        productToEnter[0] = product1.getID();
                        productToEnter[1] = (Integer.parseInt(JOptionPane.showInputDialog("Cantidad del producto")));
                        productToEnter[2] = (int) product1.getPrice();
                        oldPurchase.getMPile().ModifyByID(ModifiedProduct, productToEnter);
                        moreProductsToModify = String.valueOf(JOptionPane.showInputDialog("¿Desea modificar otro producto en la lista de compra?"));
                    }

                    moreProductsToModify = (String.valueOf(JOptionPane.showInputDialog("¿Desea añadir otro producto?")));

                    while (Objects.equals(moreProductsToModify, "si")){
                        int[] productToEnter = new int[3];
                        Product product1 = newList1.Search(String.valueOf(JOptionPane.showInputDialog("Producto: ")));
                        productToEnter[0] = product1.getID();
                        productToEnter[1] = (Integer.parseInt(JOptionPane.showInputDialog("Cantidad del producto")));
                        productToEnter[2] = (int) product1.getPrice();
                        oldPurchase.pushMP(productToEnter);
                        moreProductsToModify = String.valueOf(JOptionPane.showInputDialog("¿Desea ingresar más datos?"));
                    }

                    Purchase beforePurchase = Queue1.ModifyPurchaseByID(data, oldPurchase);
                    StringBuilder show = new StringBuilder();
                    show.append(beforePurchase.getID()).append(" ").append(beforePurchase.getUserId()).append(" ").append(beforePurchase.getDate()).append(" ").append(beforePurchase.showMP()).append("\n");
                    JOptionPane.showMessageDialog(null, "Compra anterior: \n" + show);
                    show.append(oldPurchase.getID()).append(" ").append(oldPurchase.getUserId()).append(" ").append(oldPurchase.getDate()).append(" ").append(oldPurchase.showMP()).append("\n");
                    JOptionPane.showMessageDialog(null, "Compra modificada: \n" + show);

                case 11:
                    JOptionPane.showMessageDialog(null, "Saliendo");
                    break;
            }

        }while(option!=11);

    }
}
