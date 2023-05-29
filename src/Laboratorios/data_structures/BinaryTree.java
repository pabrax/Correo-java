package data_structures;

public class BinaryTree{
    protected DoubleNode root;
    protected int size;

    public BinaryTree() {
        this.root = new DoubleNode();
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public Boolean isEmpty() {
        return size==0;
    }

    public Boolean isRoot(DoubleNode v) {
        return v == root;
    }

    public Boolean isInternal(DoubleNode v) {
        return v.getPrev() != null || v.getNext() != null;
    }

    public Boolean hasLeft(DoubleNode v) {
        return v.getPrev() != null;
    }
    public Boolean hasRight(DoubleNode v) {
        return v.getNext() != null;
    }
    public DoubleNode left(DoubleNode v) {
        return v.getPrev();
    }
    public DoubleNode right(DoubleNode v) {
        return v.getNext();
    }

    public DoubleNode parent(DoubleNode v) {
        if (isRoot(v)){
            return null;
        } else {
            Queue q = new Queue();
            q.enqueue(root);
            DoubleNode temp = root;
            while (!q.isEmpty() && left((DoubleNode) q.first()) != v && right(((DoubleNode)q.first())) != v) {
                temp = (DoubleNode) q.dequeue();
                if(hasLeft(temp)){
                    q.enqueue(left(temp));
                }
                if(hasRight(temp)){
                    q.enqueue(right(temp));
                }
                return (DoubleNode) temp;
            }
        }
        return null;
    }

    public DoubleNode root(){
        return root;
    }

    public int depth(DoubleNode v) {
        if(isRoot(v)){
            return 0;
        } else {
            return 1 + depth(parent(v));
        }
    }
    public int height(DoubleNode v) {
        if (isInternal(v)) {
            return 0;
        } else {
            int h = 0;
            h = Math.max(height(left(v)), height(right(v)));
            return 1+h;
        }
    }

    public void addRoot(Object e){
        root = new DoubleNode(e);
        size = 1;
    }

    public void insertLeft(DoubleNode v, Object e){
        DoubleNode nuevo = new DoubleNode(e);
        v.setPrev(nuevo);
        size++;
    }
    public void insertRight(DoubleNode v, Object e){
        DoubleNode nuevo = new DoubleNode(e);
        v.setNext(nuevo);
        size++;
    }

    
    public void remove(DoubleNode v){
        DoubleNode p = parent(v);
        DoubleNode child = null;
        if (hasLeft(v) || hasRight(v)) {
            if (hasLeft(v)) {
                child = left(v);
            } else {
                child = right(v);
            }
            if (left(p) == v){
                p.setPrev(child);
            } else {
                p.setNext(child);
            }
            v.setPrev(null);
            v.setNext(null);
        } else {
            if (left(p) == v) {
                p.setPrev(null);
            } else p.setNext(null);
        }
        size--;
    }
    // public Object remove(DoubleNode v){
    //     DoubleNode m = null;
    //     DoubleNode p = parent(v);
    //     if (hasLeft(v) && hasRight(v)) {
    //         return v;
    //     } 
    //     if (!hasLeft(v) && hasRight(v)) {
    //         p = parent(v);
    //         if (v == left(v)) {
    //             p.setPrev(null);
    //         } else {
    //             p.setNext(null);
    //         }
    //     } else {
    //         if (hasLeft(v)) {
    //             m = left(v);
                
    //         } else {
    //             m = right(v);
    //         }
    //         if (hasLeft(p)) {
    //             p.setPrev(m);
    //         } else {
    //             p.setNext(m);
    //         }
    //     }
    //     size--;
    //     return v.getData();
    // }
}