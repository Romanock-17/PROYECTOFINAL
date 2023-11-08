import Data.DoubleLinkedList;
import Data.Stack;
import Data.Queue;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = 0, data = 0;
        Stack Stack1 = new Stack(10);
        Stack Stack2 = new Stack(10);
        Stack Stack3 = new Stack(10);
        DoubleLinkedList newList1= new DoubleLinkedList();
        Queue Queue1 = null;
        Queue Queue2 = null;
        Queue Queue3 = null;

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
                     "10- Salir";

            String opcio = JOptionPane.showInputDialog(null, menu, "Menú de Opciones", JOptionPane.INFORMATION_MESSAGE);
            option = Integer.parseInt(opcio);

            switch (option){
                 case 1:
                     int id = Integer.parseInt(JOptionPane.showInputDialog("ID: "));
                     String name = JOptionPane.showInputDialog("Nombre: ");
                     String lastName = JOptionPane.showInputDialog("Apellido: ");
                     String email = JOptionPane.showInputDialog("Email: ");
                     String user = JOptionPane.showInputDialog("Usuario: ");
                     String password = JOptionPane.showInputDialog("Contraseña: ");

                     Stack1.PileUp(id, name, lastName, email, user, password);
                 break;
                 case 2:
                     int ID= Integer.parseInt(JOptionPane.showInputDialog("ID: "));
                     String product = String.valueOf(JOptionPane.showInputDialog("Articulo: "));
                     double price = Integer.parseInt(JOptionPane.showInputDialog("Precio unitario: "));
                     int amount = Integer.parseInt(JOptionPane.showInputDialog("Cantidad: "));
                    String description = String.valueOf(JOptionPane.showInputDialog("Descripcion: "));
                     newList1.FillList(ID, product, price, amount,description);
                 break;
                case 3:











                case 10:
                    JOptionPane.showMessageDialog(null, "Saliendo");
                    break;
             }

        }while(option!=10);
        
    }
}