package Data;

import Collections.SimpleNode;

import javax.swing.*;

public class Stack {

    private SimpleNode Head;
    public int Limit, Top;

    public Stack(int length) {
        this.Limit = length - 1;
        this.Top = -1;
        this.Head = null;
    }

    public void PileUp(int ID, String Name, String LastName, String email, String user, String password) {
        SimpleNode X = new SimpleNode(ID, Name, LastName, email, user, password);
        Top++;
        if (this.Head != null) {
            X.setLiga(this.Head);
        }
        this.Head = X;
    }

    public void PileUp(SimpleNode A) {
        SimpleNode X = new SimpleNode();
        Top++;
        if (this.Head != null) {
            X.setLiga(this.Head);
        }
        this.Head = X;

    }

    //Pila matriz 10x3
    public boolean EmptyStack() {
        return Top <= -1;
    }

    public boolean FullStack() {
        return Top == Limit;
    }

    public SimpleNode PileDown() {
        SimpleNode P = Head;
        Top--;
        Head = Head.getLiga();
        P.setLiga(null);
        return (P);
    }

    public void FillStack(Stack PA) {
        while (!EmptyStack()) {
            PA.PileUp(PileDown());
        }
    }

    public void ShowStack() {
        SimpleNode aux = Head;
        String Show = "";
        while (aux != null) {
            Show += aux.getID() + aux.getName() + aux.getLastName() + aux.getEmail() + aux.getUser() + "\n";
            aux = aux.getLiga();

        }
        JOptionPane.showMessageDialog(null, Show);
        Show = "";
    }

    public boolean SearchID(int ID) {
        Stack A = new Stack(this.Limit);
        boolean found = false;

        while (Head.getID() != ID && !EmptyStack()) {
            A.PileUp(PileDown());
        }
        if (Head.getID() == ID && !EmptyStack()){
            found = true;
        }else{
            JOptionPane.showMessageDialog(null, "El usuario no se encontró en la lista");
        }
        FillStack(A);

        return found;
    }
    public void DeletePile(int ID){
        Stack A = new Stack(this.Limit);
        while (Head.getID() != ID && !EmptyStack()) {
            A.PileUp(PileDown());
        }
        if (Head.getID() == ID && !EmptyStack()){
            PileDown();
            JOptionPane.showMessageDialog(null, "El usuario se eliminó exitosamente");
        }else{
            JOptionPane.showMessageDialog(null, "El usuario no se encontró en la lista");
        }
        FillStack(A);
    }

    public void ShowUsers() {
        Stack A = new Stack(this.Limit);
        SimpleNode P = new SimpleNode();
        String r = null;
        String show = "";
        while (!EmptyStack()) {
            P = PileDown();
            r = (P.getUser());
            A.PileUp(P);
            show += r + "\n";
        }
            JOptionPane.showMessageDialog(null, show);
    }
}
