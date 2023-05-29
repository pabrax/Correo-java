
import javax.swing.JOptionPane;
import Objects.*;
import data_structures.DoubleNode;

public class Menu {

    ListaEmpleados listaEmpleados;
    Usuario user;
    
    public Menu(ListaEmpleados lista) {
        this.listaEmpleados = lista;
    }

    // error en el menu empleado case 1
    public void menuEmpleado() {
        Empleado meb = new Empleado(user);
        int opcion;
        do {
            String input = JOptionPane.showInputDialog(
                    "1. Redactar mensaje\n" +
                            "2. Revisar bandeja de entrada\n" +
                            "3. Ver mensajes leídos\n" +
                            "4. Ver borradores\n" +
                            "5. Salir\n" +
                            "Seleccione una opción:");
                            
            opcion = Integer.parseInt(input);

            switch (opcion) {
                case 1:
                meb.bandeja.redactarMensaje();
                    break;
                case 2:
                    meb.revisarBandeja();
                    break;
                    case 3:
                    meb.verMensajesLeidos();
                    break;
                case 4:
                    meb.verBorradores();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Hasta luego!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
                    break;
            }
        } while (opcion != 5);
        System.exit(0);
    }
    
    public void menuAdmin() {
        // Menú administrador bandeja
        Administrador mab = new Administrador(listaEmpleados, user);
        int opcion;
        do {
            String input = JOptionPane.showInputDialog(
                "1. Registrar usuario\n" +
                            "2. Cambiar contraseña\n" +
                            "3. Eliminar usuario\n" +
                            "4. Actualizar información\n" +
                            "5. Salir\n" +
                            "Seleccione una opción:");

            opcion = Integer.parseInt(input);

            switch (opcion) {
                case 1:
                    mab.registrarUsuarios();
                    break;
                    case 2:
                    String userIDInput = JOptionPane.showInputDialog("Ingrese el ID del usuario:");
                    Long userID = Long.parseLong(userIDInput);

                    String newPwd = JOptionPane.showInputDialog("Ingrese la nueva contraseña:");
                    mab.CambiarContrasena(userID, newPwd);
                    break;
                case 3:
                    String idInput = JOptionPane.showInputDialog("Ingrese el ID del usuario a eliminar:");
                    long id = Long.parseLong(idInput);

                    Usuario u = mab.eliminarUsuario(id);
                    if (u == null) {
                        JOptionPane.showMessageDialog(null, "Usuario no encontrado");
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario eliminado: " + u);
                    }
                    break;
                case 4:
                    mab.actualizarInfo();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Hasta luego!");
                    break;
                    default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
                    break;
                }
        } while (opcion != 5);
        System.exit(0);
    }
    
    public void Login() {

        Long idLogin = Long.parseLong(JOptionPane.showInputDialog(null, "Usuario", "iniciar sesion", 1));
        String LoginPassword = JOptionPane.showInputDialog(null, "Contraseña", "iniciar sesion", 1);

        DoubleNode actUser = listaEmpleados.getLista().first(); 
        while (actUser != null) {
            if((((Empleado) actUser.getDato()).getUser().getId().equals(idLogin)) && ((Empleado) actUser.getDato()).getUser().getContrasena().equals(LoginPassword)){
                if (((Empleado) actUser.getDato()).getUser().getTipoUsuario().equals("administrador")) {
                    menuAdmin();
                    this.user = ((Empleado)actUser.getDato()).getUser();
                } else {
                    menuEmpleado();
                    this.user = ((Empleado)actUser.getDato()).getUser();
                }
            }
            actUser.getNext();
        }
    }
}
