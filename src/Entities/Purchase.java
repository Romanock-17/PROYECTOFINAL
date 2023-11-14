package Entities;

import Data.MatrixStack;

public class Purchase {
    private static int counterId = 0;
    private int ID;
    private MatrixStack MPile = new MatrixStack();
    public String date;
    public int userId;
    public Purchase () {
        this.ID = ++counterId;
    }
    public Purchase(String date, int userId) {
        this.date = date;
        this.userId = userId;
        this.MPile = new MatrixStack();
    }

    public MatrixStack getMPile() {
        return MPile;
    }

    public void setMPile(MatrixStack MPile) {
        this.MPile = MPile;
    }

    public int getID() {
        return ID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String showMP() {
        return MPile.ShowMatrixStack();
    }
    public void pushMP(int[] purchaseEl){
        if(!MPile.FullStack()){
            MPile.PileUp(purchaseEl);
        }
    }
    public int[] popMP(){
        if(!MPile.EmptyStack()){
            return MPile.PileDown();
        }
        return null;
    }
}
