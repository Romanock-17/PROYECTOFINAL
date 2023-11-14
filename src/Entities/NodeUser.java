package Entities;
import Collections.SimpleNode;

public class NodeUser extends SimpleNode {
    User user;
    public NodeUser(){}
    public NodeUser(User user, SimpleNode Liga){
        this.user=user;
        super.setLiga(Liga);
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public NodeUser getLiga() {
        return (NodeUser) super.getLiga();
    }
}
