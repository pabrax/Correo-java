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
        temp = m.getListaUsuarios();
        Usuario u = m.create();

        if(m.Buscar(u.getId()) == null){
            temp.addLast(u);
            m.setListaUsuarios(temp);
        }
    }
   
    public void CambiarContrasena(){
        // Menu m = new Menu();
    }
    
    
    public void actualizarInfo(){
        MenuTools mt = new MenuTools();
        mt.toFile();
        
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
    
}
