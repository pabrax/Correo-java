package data_structures;


public class Node {

    private Object dato;
    private Node next;

    public Node() {
        
    }

    public Node(Object e){
        this.dato = e;
        this.next = null;
    }
    public void setDato(Object e) {
        dato = e;
    }

    public void setNext(Node n) {
        next = n ;
    }

    public Object getDato() {
        return dato;
    }

    public Node getNext() {
        return next;
    }

}
