package data_structures;


public class Queue {
    List data;
    
    public Queue(){
        data = new List();
    }

    public int size(){
        return data.size();
    }

    public Boolean isEmpty() {
        return data.isEmpty();
    }

    public void enqueue(Object e){
        data.addLast(e);
    }
    public Object dequeue(){
        return data.removeFirst();
    }

    public Object first() {
        return data.First().getDato();
    }
}
