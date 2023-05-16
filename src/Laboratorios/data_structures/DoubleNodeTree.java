package data_structures;

public class DoubleNodeTree {
    private Object data;
    private DoubleNodeTree right;
    private DoubleNodeTree left;
    
    public DoubleNodeTree(Object d) {
        this.data = d;
        this.right = null;
        this.left = null;
    }

    public DoubleNodeTree() {
        this.data = null;
        this.right = null;
        this.left = null;
    }

    public Object getData() {
        return data;
    }

    public DoubleNodeTree getright() {
        return right;
    }

    public DoubleNodeTree getleft() {
        return left;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setright(DoubleNodeTree right) {
        this.right = right;
    }

    public void setleft(DoubleNodeTree left) {
        this.left = left;
    }

    
}
