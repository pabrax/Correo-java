import data_structures.List;
import Objects.Usuario;
import data_structures.*;

public class Administrador extends Empleado{
    
    public Administrador() {
        this.user = new Usuario();
    }
    
    public void registrarUsuarios(){
        MenuTools m = new MenuTools();
        List temp = new List();
        temp = m.getlistaEmpleados();
        Usuario u = m.create();

        if(m.Buscar(u.getId()) == null){
            temp.addLast(u);
            m.setlistaEmpleados(temp);
        }
    }
    // ? falta testear
    public void CambiarContrasena(Long userID, String newPwd){
        Menu m = new Menu();
        Node actual = m.Buscar(userID);
        if(actual != null){
            Usuario u = ((Empleado) actual.getDato()).user;
            u.setContrasena(newPwd);
        } else {
            System.out.println("no se encontro al usuario " + userID);
        }
    }
    
    
    public void actualizarInfo(){
        MenuTools mt = new MenuTools();
        mt.toFile();
    }

    public Usuario eliminarUsuario(long id){
        Menu m = new Menu();
        Node actual = m.getlistaEmpleados().First();
        Node anterior = null;
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
