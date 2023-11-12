package Data;
import Entities.*;
import Collections.SimpleNode;

import javax.swing.*;
import java.util.Objects;

public class Stack {

    private NodeUser Head;
    public int Limit, Top;

    public Stack(int length) {
        this.Limit = length - 1;
        this.Top = -1;
        this.Head = null;
    }

    public void PileUp(User user) {
        NodeUser X = new NodeUser(user, null);
        Top++;
        if (this.Head != null) {
            X.setLiga(this.Head);
        }
        this.Head = X;
    }

    public void PileUp(NodeUser A) {
        Top++;
        if (this.Head != null) {
            A.setLiga(this.Head);
        }
        this.Head = A;
    }

    //Pila matriz 10x3
    public boolean EmptyStack() {
        return Top <= -1;
    }

    public boolean FullStack() {
        return Top == Limit;
    }

    public NodeUser PileDown() {
        NodeUser P = Head;
        Top--;
        Head = Head.getLiga();
        P.setLiga(null);
        return (P);
    }

    public void FillStack(Stack PA) {
        while (!EmptyStack()) {
            PA.PileUp(this.PileDown());
        }
    }
    public User SearchByUsername(String username) {
        Stack A = new Stack(this.Limit);
        boolean found = false;

        while (!Objects.equals(Head.getUser().getUserName(), username) && !EmptyStack()) {
            A.PileUp(PileDown());
        }
        if (Objects.equals(Head.getUser().getUserName(), username) && !EmptyStack()){
            found = true;
        }
        User M = Head.getUser();
        FillStack(A);
        if(found) return M;
        else return null;
    }
    public void DeletePile(int ID){
        Stack A = new Stack(this.Limit);
        while (Head.getUser().getID() != ID && !EmptyStack()) {
            A.PileUp(PileDown());
        }
        if (Head.getUser().getID() == ID && !EmptyStack()){
            PileDown();
            JOptionPane.showMessageDialog(null, "El usuario se eliminó exitosamente");
        }else{
            JOptionPane.showMessageDialog(null, "El usuario no se encontró en la lista");
        }
        A.FillStack(this);
    }

    public void ShowUsers() {
        Stack A = new Stack(this.Limit);
        NodeUser P = new NodeUser();
        String r = null;
        String show = "";
        while (!EmptyStack()) {
            P = PileDown();
            r = P.getUser().getID() + " " + P.getUser().getUserName();
            A.PileUp(P);
            show += r + "\n";
        }
        JOptionPane.showMessageDialog(null, show);
        A.FillStack(this);
    }
}
