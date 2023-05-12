package data_structures;

import javax.swing.JOptionPane;

public class List {
    private Node head;
    private Node tail;
    private int size;

    public List() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        Node actual = head;
        while (actual != null) {
            size++;
            actual = actual.getNext();
        }
        return size;
    }
    public void print() {
        Node actual = head;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (actual != null) {
            // sb.append(actual.getDato()).append("\n");
            sb.append(index++).append(") ").append(actual.getDato()).append("\n");
            actual = actual.getNext();
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public int getIndex(Node nodo) {
        Node actual = head;
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

    public Boolean isEmpty() {
        return head == null;
    }

    public void setSize(int s) {
        this.size = s;
    }

    public Node First() {
        return head;
    }

    public Node Last() {
        return tail;
    }

    public void addFirst(Object e) {
        Node nuevo = new Node(e);
        nuevo.setNext(head);
        head = nuevo;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void addLast(Object e) {
        Node nuevo = new Node(e);
        if (head == null) {
            head = nuevo;
            tail = head;
        } else {
            tail.setNext(nuevo);
            tail = nuevo;
        }
        size++;
    }

    public Object removeFirst() {
        if (head == null) {
            System.out.println("No encontro el primero");
            return null;
        }
        Object dato = head.getDato();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        size--;
        return dato;
    }

    public Object removeLast() {
        if (head == null) {
            System.out.println("No hay nada en la ultima pos");
            return null;
        }
        if (head.getNext() == null) {
            Object dato = head.getDato();
            head = null;
            tail = null;
            size--;
            return dato;
        }
        Node last = head;
        while (last.getNext().getNext() != null) {
            last = last.getNext();
        }
        Object dato = last.getNext().getDato();
        last.setNext(null);
        tail = last;
        size--;
        return dato;
    }
}
