package Entities;

import Data.Stack;

public class Purchase {
    private int ID;
    public String date;
    public int userId;
    public Stack[] stacks;
    public Purchase () {}
    public Purchase(int ID, String date, User user, String[][] MP) {
        this.ID = ID;
        this.date = date;
        this.user = user;
        this.MP = MP;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String[][] getMP() {
        return MP;
    }

    public void setMP(String[][] MP) {
        this.MP = MP;
    }
}
