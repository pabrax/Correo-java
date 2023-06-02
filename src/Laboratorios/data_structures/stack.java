package data_structures;


public class stack {
    private List data;
        
    public stack(){
        data = new List();
    }

    public void push(Object e){
        data.addFirst(e);
    }
    
    public int size(){
        return data.size();
    }
    
    public Boolean isEmpty(){
        return data.isEmpty();
    }
    
    public Object pop(){
        return data.removeFirst();
    }
    public Object top(){
        return data.First().getDato();
    }

    public String display() {
        Node actual = data.First();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (actual != null) {
            sb.append(index++).append(") ").append(actual.getDato()).append("\n");
            actual = actual.getNext();
        }
        return sb.toString();
    }

}
