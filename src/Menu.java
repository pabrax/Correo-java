
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
        Empleado emp = new Empleado(user, listaEmpleados);
        int opcion;
        do {
            String input = JOptionPane.showInputDialog(
                    "1. Redactar mensaje\n" +
                            "2. Revisar bandeja de entrada\n" +
                            "3. Ver mensajes leídos\n" +
                            "4. Ver borradores\n" +
                            "5. administrar\n" +
                            "6. cerrar sesion\n" +
                            "7. Salir\n" +
                            "Seleccione una opción:");
                            
            opcion = Integer.parseInt(input);

            switch (opcion) {
                case 1:
                    Long idDest = Long.parseLong(JOptionPane.showInputDialog(null, "Digite el id del    destinatario"));
                    mensaje m = emp.bandeja.redactarMensaje();
                    int  conf = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea enviar el mensaje?\n1) si\n2) no"));
                    if (conf == 1) {
                        emp.getBandeja().enviarMensaje(m, idDest);
                    } else {
                        emp.getBandeja().getBorrador().push(m);
                    }
                
                    break;
                case 2:
                    emp.revisarBandeja();
                    break;
                    case 3:
                    emp.verMensajesLeidos();
                    break;
                case 4:
                    emp.verBorradores();
                    break;
                case 5:
                    menuAdmin();
                    break;
                case 6:
                    Login();
                    break;
                case 7:
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
                            "4. Actualizar información usuarios\n" +
                            "5. Mail\n" +
                            "6. cerrar sesion\n" +
                            "7. Salir\n" +
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
                    menuEmpleado();
                    break;
                case 6:
                    Login();
                    break;
                case 7:
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
                    this.user = ((Empleado)actUser.getDato()).getUser();
                    menuAdmin();
                } else {
                    this.user = ((Empleado)actUser.getDato()).getUser();
                    menuEmpleado();
                }
            }
            actUser = actUser.getNext();
        }
        JOptionPane.showMessageDialog(null, "el usuario no existe");
    }
}
