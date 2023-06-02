
import Objects.Usuario;
import data_structures.*;

public class Administrador extends Empleado{
    opcList o;
    ListaEmpleados lista;

    public Administrador(ListaEmpleados lista) {
        this.lista = lista;
        this.user = new Usuario();
        this.o = new opcList(lista); // por revisar
    }

    public Administrador(ListaEmpleados lista, Usuario user) {
        this.lista = lista;
        this.user = user;
        this.o = new opcList(lista); // por revisar
    }
    
    public Administrador() {
        this.lista = new ListaEmpleados(null);
        this.user = new Usuario();
        this.o = new opcList(); // por revisar
    }
    
    public void actualizarInfo(){
        o.toFile();
    }

    public void registrarUsuarios(){
        Usuario u = o.create();
        
        if(o.Buscar(u.getId()) == null){
            Empleado emp = new Empleado(u);
            lista.getLista().addLast(emp);
        }
    }
    
    // ? falta testear
    public void CambiarContrasena(Long userID, String newPwd){
        DoubleNode actual = o.BuscarC(userID);
        if(actual != null){
            Empleado emp = ((Empleado) actual.getDato());
            Usuario u = emp.getUser();
            u.setContrasena(newPwd);
        } else {
            System.out.println("no se encontro al usuario " + userID);
        }
    }
    
    public Usuario eliminarUsuario(long id){

        DoubleNode actual = lista.getLista().first();
        DoubleNode anterior = null;
        while (actual != null) {
            Usuario u = ((Empleado) actual.getDato()).getUser();
            if (u.getId() == id) {
                if (anterior == null) {
                    lista.getLista().removeFirst();
                } else if (actual.getNext() == null) {
                    lista.getLista().removeLast();
                } else {
                    anterior.setNext(actual.getNext());
                    lista.getLista().setSize(lista.getLista().size() - 1);
                }
                return u;
            }
            anterior = actual;
            actual = actual.getNext();
        }
        return null;
    } 
}
