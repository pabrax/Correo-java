
import Objects.Usuario;
import data_structures.*;

public class Administrador extends Empleado{
    opcList o;
    public Administrador() {
        this.user = new Usuario();
        this.o = new opcList();
    }
    
    public void registrarUsuarios(){
        Menu m = new Menu();
        DoubleList temp = m.getlistaEmpleados();
        Usuario u = o.create();
        
        if(o.Buscar(u.getId()) == null){
            m.listaEmpleados.addLast(u);

            m.setlistaEmpleados(temp);
        }
    }
    // ? falta testear
    public void CambiarContrasena(Long userID, String newPwd){
        DoubleNode actual = o.Buscar(userID);
        if(actual != null){
            Usuario u = ((Empleado) actual.getDato()).user;
            u.setContrasena(newPwd);
        } else {
            System.out.println("no se encontro al usuario " + userID);
        }
    }
    
    public void actualizarInfo(){
        o.toFile();
    }

    public Usuario eliminarUsuario(long id){
        Menu m = new Menu();
        DoubleNode actual = m.getlistaEmpleados().First();
        DoubleNode anterior = null;
        while (actual != null) {
            Usuario u = (Usuario) actual.getDato();
            if (u.getId() == id) {
                if (anterior == null) {
                    m.getlistaEmpleados().removeFirst();
                } else if (actual.getNext() == null) {
                    m.getlistaEmpleados().removeLast();
                } else {
                    anterior.setNext(actual.getNext());
                    m.getlistaEmpleados().setSize(m.getlistaEmpleados().size() - 1);
                }
                return u;
            }
            anterior = actual;
            actual = actual.getNext();
        }
        return null;
    }
    
}
