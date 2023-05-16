package data_structures;

public class BinaryTree {
    DoubleNodeTree root;
    int size;

    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }

    public int size(){
        return size;
    }
    public Boolean isEmpty(){
        return size==0;
    }
    public boolean isRoot(DoubleNodeTree n){
        return n==root;
    }

    public Boolean isInternal(DoubleNodeTree n){
        if (n.getleft() == null && n.getright() == null){
            return false;
        } else{
            return true;
        }
    }

    public boolean hasRight(DoubleNodeTree n){
        return n.getright()!= null;
    }
    public boolean hasLeft(DoubleNodeTree n){
        return n.getleft()!= null;
    }

    public DoubleNodeTree root(){
        return root;
    }

    public DoubleNodeTree left(DoubleNodeTree n){
        return n.getleft();
    }
    public DoubleNodeTree right(DoubleNodeTree n){
        return n.getright();
    }

    public DoubleNodeTree parent(DoubleNodeTree n) {
        if (isRoot(n)) {
            return null;
        } else {
            Queue q = new Queue();
            q.enqueue(root);
            while (!q.isEmpty() && right((DoubleNodeTree)q.first()) != n && left((DoubleNodeTree) q.first()) != n) {
                DoubleNodeTree temp = ((DoubleNodeTree) q.dequeue());
                if (hasLeft(temp)) {
                    q.enqueue(left(temp));
                }
                if (hasRight(temp)) {
                    q.enqueue(right(temp));
                }
                return temp;
            }
            return null;
        }
    }


}
