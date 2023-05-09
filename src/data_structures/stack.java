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

}
