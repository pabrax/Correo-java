import data_structures.List;
import userClass.Usuario;
import data_structures.*;

public class Administrador extends Empleado{
    
    public Administrador() {
        this.user = new Usuario();
    }
    
    public void registrarUsuarios(Usuario u){
        Menu m = new Menu();
        List temp = new List();
        temp = m.getListaUsuarios();
        temp.addLast(u);
        m.setListaUsuarios(temp);
    }
   
    public void CambiarContrasena(){
        // Menu m = new Menu();
    }
    
    public Usuario eliminarUsuario(long id){
        Menu m = new Menu();
        Node actual = m.getListaUsuarios().First();
        Node anterior = null;
        while (actual != null) {
            Usuario u = (Usuario) actual.getDato();
            if (u.getId() == id) {
                if (anterior == null) {
                    m.getListaUsuarios().removeFirst();
                } else if (actual.getNext() == null) {
                    m.getListaUsuarios().removeLast();
                } else {
                    anterior.setNext(actual.getNext());
                    m.getListaUsuarios().setSize(m.getListaUsuarios().size() - 1);
                }
                return u;
            }
            anterior = actual;
            actual = actual.getNext();
        }
        return null;
    }
    
    public void actualizarInfo(){
        
        try {
            
            
        } catch (Exception e) {
        
        }

        try {

            
        } catch (Exception e) {
        
        }
    }
    
}
