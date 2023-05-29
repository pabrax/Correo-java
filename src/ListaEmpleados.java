import data_structures.*;

public class ListaEmpleados {
    private DoubleList Lista;

    public ListaEmpleados() {
        this.Lista = new DoubleList();
    }
    
    public ListaEmpleados(DoubleList lista) {
        this.Lista = lista;
    }

    public DoubleList getLista() {
        return Lista;
    }
    
    public void setLista(DoubleList lista) {
        Lista = lista;
    }

    

}
