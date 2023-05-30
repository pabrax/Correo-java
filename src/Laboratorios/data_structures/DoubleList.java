package data_structures;
import Objects.mensaje;

import javax.swing.JOptionPane;

public class DoubleList {
    private DoubleNode head;
    private DoubleNode tail;
    private int size;
    
    public DoubleList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    // Getters y setters
    public int size() {
        return size;
    }
    public DoubleNode getHead() {
        return head;
    }

    public void setHead(DoubleNode head) {
        this.head = head;
    }

    public DoubleNode getTail() {
        return tail;
    }

    public void setTail(DoubleNode tail) {
        this.tail = tail;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public DoubleNode first() {
        return head;
    }

    public DoubleNode last() {
        return tail;
    }
    
    public void addFirst(Object e) {
        DoubleNode newNode = new DoubleNode(e);
        newNode.setNext(head);
        
        if (head != null) {
            head.setPrev(newNode);
        } else {
            tail = newNode;
        }
        
        head = newNode;
        size++;
    }

    public void addLast(Object e) {
        DoubleNode newNode = new DoubleNode(e);
        newNode.setPrev(tail);
        
        if (tail != null) {
            tail.setNext(newNode);
        } else {
            head = newNode;
        }
        
        tail = newNode;
        size++;
    }

    public Object removeFirst() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return null;
        }
        
        Object data = head.getDato();
        head = head.getNext();
        
        if (head != null) {
            head.setPrev(null);
        } else {
            tail = null;
        }
        
        size--;
        return data;
    }

    public Object removeLast() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return null;
        }
        
        Object data = tail.getDato();
        tail = tail.getPrev();
        
        if (tail != null) {
            tail.setNext(null);
        } else {
            head = null;
        }
        
        size--;
        return data;
    }
    
    public void remove(DoubleNode node) {
        if (node == null) {
            return;
        }
        
        DoubleNode prevNode = node.getPrev();
        DoubleNode nextNode = node.getNext();
        
        if (prevNode != null) {
            prevNode.setNext(nextNode);
        } else {
            head = nextNode;
        }
        
        if (nextNode != null) {
            nextNode.setPrev(prevNode);
        } else {
            tail = prevNode;
        }
        
        size--;
    }

    public void addAfter(DoubleNode node, Object e) {
        if (node == null) {
            return;
        }
        
        DoubleNode newNode = new DoubleNode(e);
        DoubleNode nextNode = node.getNext();
        
        node.setNext(newNode);
        newNode.setPrev(node);
        
        if (nextNode != null) {
            nextNode.setPrev(newNode);
            newNode.setNext(nextNode);
        } else {
            tail = newNode;
        }
        
        size++;
    }

    public void addBefore(DoubleNode node, Object e) {
        if (node == null) {
            return;
        }
        
        DoubleNode newNode = new DoubleNode(e);
        DoubleNode prevNode = node.getPrev();
        
        node.setPrev(newNode);
        newNode.setNext(node);
        
        if (prevNode != null) {
            prevNode.setNext(newNode);
            newNode.setPrev(prevNode);
        } else {
            head = newNode;
        }
        
        size++;
    }
    public int getIndex(DoubleNode nodo) {
        DoubleNode actual = head;
        int index = 0;
        while (actual != null) {
            if (actual.getDato().equals(nodo.getDato())) {
                return index;
            }
            actual = actual.getNext();
            index++;
        }
        return -1; // dato no encontrado
    }

    public void print() {
        DoubleNode actual = head;
        StringBuilder sb = new StringBuilder();
        while (actual != null) {
            sb.append(actual.getDato().toString()).append("\n");
            actual = actual.getNext();
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public void setSize(int s) {
        this.size = s;
    }

    
    public String obtenermensajes() {
        DoubleNode actual = head;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (actual != null) {
            // sb.append(actual.getDato()).append("\n");
            sb.append(index++).append(") ").append(((mensaje) actual.getDato()).toStringShort()).append("\n");
            actual = actual.getNext();
        }
        return sb.toString();
    }

    public Object get(int indice) {
        if (indice < 0 || indice >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        DoubleNode actual = head;
        for (int i = 0; i < indice; i++) {
            actual = actual.getNext();
        }
        return actual.getDato();
    }

    public Object remove(int indice) {
        if (indice < 0 || indice >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía");
        }
        DoubleNode actual = head;
        if (indice == 0) {
            head = actual.getNext();
            if (head != null) {
                head.setPrev(null);
            }
            size--;
            return actual.getDato();
        }
        for (int i = 0; i < indice; i++) {
            actual = actual.getNext();
        }
        DoubleNode anterior = actual.getPrev();
        DoubleNode siguiente = actual.getNext();
        
        if (anterior != null) {
            anterior.setNext(siguiente);
        }
        if (siguiente != null) {
            siguiente.setPrev(anterior);
        }
        
        size--;
        return actual.getDato();
    }
}
