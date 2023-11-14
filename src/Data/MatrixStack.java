package Data;
import javax.swing.*;

public class MatrixStack {

    private int[][] MP;
    private int[] Head = new int[3];
    public int Limit, Top;

    public MatrixStack() {
        this.Limit = 9;
        this.Top = -1;
        this.MP = new int[10][3];
    }

    public void PileUp(int[] newMatrix) {
        Top++;
        this.MP[this.Top][0] = newMatrix[0];
        this.MP[this.Top][1] = newMatrix[1];
        this.MP[this.Top][2] = newMatrix[2];
        Head = newMatrix;
    }

    public boolean EmptyStack() {
        return Top <= -1;
    }

    public boolean FullStack() {
        return Top == Limit;
    }

    public int[] PileDown() {
        int[] P = Head;
        Top--;
        if(Top > -1){
            Head[0] = this.MP[Top][0];
            Head[1] = this.MP[Top][1];
            Head[2] = this.MP[Top][2];
        }else{
            Head = null;
        }
        return (P);
    }

    public int[] ModifyByID(int ID, int[] newData) {
        MatrixStack A = new MatrixStack();

        while (Head[0] != ID && !EmptyStack()) {
            A.PileUp(PileDown());
        }
        if (Head[0] == ID && !EmptyStack()){
            int[] oldData = Head;
            Head = newData;
            return oldData;
        }
        FillStack(A);

        return null;
    }

    public int[] SearchID(int ID) {
        MatrixStack A = new MatrixStack();


        while (Head[0] != ID && !EmptyStack()) {
            A.PileUp(PileDown());
        }
        if (Head[0] == ID && !EmptyStack()){
            return Head;
        }
        FillStack(A);

        return null;
    }

    public void FillStack(MatrixStack PA) {
        while (!EmptyStack()) {
            PA.PileUp(this.PileDown());
        }
    }
    public String ShowMatrixStack() {
        MatrixStack A = new MatrixStack();
        int[] P = new int[3];
        String r = null;
        String show = "";
        while (!EmptyStack()) {
            P = PileDown();
            r = P[0] + " " + P[1] + " " + P[2];
            A.PileUp(P);
            show += r + "\n";
        }
        A.FillStack(this);
        return show;
    }
}