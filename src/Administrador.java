import data_structures.List;
import user.Usuario;

public class Administrador extends Empleado{
    
    public Administrador() {
        this.user = new Usuario();
    }
    

    public void registrarUsuarios(){
        Menu m = new Menu();
        List temp = new List();
        temp = m.getListaUsuarios();
        temp.addLast(temp);
    }

    
    public void CambiarContrasena(){
    }

    public void eliminarUsuario(){
    }
    
    public void actualizarInfo(){
        try {
            
        } catch (Exception e) {
        }
    }
    
}
