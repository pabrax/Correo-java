package data_structures;

public class DoubleNode {
    private Object data;
    private DoubleNode next;
    private DoubleNode prev;
    
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

    public Object getDato() {
        return data;
    }

    public DoubleNode getNext() {
        return next;
    }

    public DoubleNode getPrev() {
        return prev;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    public void setPrev(DoubleNode prev) {
        this.prev = prev;
    }

    
}
