package data_structures;

public class BST extends BinaryTree{
    public BST() {
        super();
    }
    public DoubleNode find(int k){
        return searchTree(k, root());
    }

    
    public void insert(Object e, int k){
        BSTEntry o = new BSTEntry(e, k);
        if (isEmpty()) {
            super.addRoot(o);
        } else {
            addEntry(root(), o);
        }

    }

    public Object remove(int k){
        DoubleNode v = find(k);
        if (hasLeft(v) && hasRight(v)) {
            DoubleNode w = predecesor(v);
            if (hasLeft(w)) {
                parent(w).setNext(left(v));
                
            }
            v.setData(w.getDato());
            size--;
        } else{
            super.remove(v);
        }
        return null;
    }

    private DoubleNode predecesor(DoubleNode v) {
        DoubleNode temp = v.getPrev();
        return maxNode(temp);

    }
    private DoubleNode maxNode(DoubleNode temp) {
        if (hasRight(temp)) {
            return maxNode(right(temp));
        } else {
            return temp;
        }
    }

    private DoubleNode searchTree(int k, DoubleNode v){
        BSTEntry u = ((BSTEntry)v.getDato());
        if(k==u.getKey()){
            return v;
        }   else if (k< u.getKey()) {
            return searchTree(k, v.getPrev());
        } else {
            return searchTree(k, v.getNext()); 
        }
    }

    private void addEntry(DoubleNode v, BSTEntry o){
        BSTEntry temp = ((BSTEntry) v.getDato());
        DoubleNode nD = new DoubleNode(o);
        if(o.getKey()< temp.getKey()){
            if (hasLeft(v)) {
                addEntry(left(v), o);
            } else {
                v.setPrev(nD);
            } 
        } else {
            if (hasRight(v)) {
                addEntry(right(v), o);
            } else {
                v.setNext(nD);
            }
        }
    }
}
