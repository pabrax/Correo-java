package data_structures;

public class DoubleNode {
    private Object data;
    private Node next;
    private Node prev;
    
    public DoubleNode(Object d) {
        this.data = d;
        this.next = null;
        this.prev = null;
    }

    public DoubleNode() {
        this.data = null;
        this.next = null;
        this.prev = null;
    }

    public Object getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    
}
