package data_structures;

public class BSTEntry {
    protected Object data;
    protected int k;

    public BSTEntry(Object d, int k) {
        data = d;
        this.k = k;
    }

    public Object getData() {
        return data;
    }

    public int getKey() {
        return k;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public void setKey(int k) {
        this.k = k;
    }
}
