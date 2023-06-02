
import javax.swing.JOptionPane;
import Objects.*;
import data_structures.DoubleNode;

public class Menu {

    ListaEmpleados listaEmpleados;
    Usuario user;
    BandejaEntrada BEUser;
    
    public Menu(ListaEmpleados lista) {
        this.listaEmpleados = lista;
    }

    // error en el menu empleado case 1
    public void menuEmpleado() {
        Empleado emp = new Empleado(this.user, listaEmpleados);
        emp.setBandeja(BEUser);

        int opcion;
        do {
            String input;
                if(emp.getUser().getTipoUsuario().equals("administrador")){
                    input = JOptionPane.showInputDialog(
                            "1. Redactar Mensaje\n" +
                            "2. Revisar Bandeja de Entrada\n" +
                            "3. Ver Mensajes Leídos\n" +
                            "4. Ver Borradores\n" +
                            "5. Cerrar Sesión\n" +
                            "6. Salir\n" +
                            "7. Administrar\n" +
                            "Seleccione Una Opción:");
                }else{
                    input = JOptionPane.showInputDialog(
                            "1. Redactar Mensaje\n" +
                            "2. Revisar Bandeja de Entrada\n" +
                            "3. Ver Mensajes Leídos\n" +
                            "4. Ver Borradores\n" +
                            "5. Cerrar Sesion\n" +
                            "6. Salir\n" +
                            "Seleccione una Opción:");
                }           
            opcion = Integer.parseInt(input);
            
            switch (opcion) {
                case 1:
                    Long idDest = Long.parseLong(JOptionPane.showInputDialog(null, "Digite el id del    destinatario"));
                    mensaje m = emp.bandeja.redactarMensaje();
                    m.setDest(idDest);
                    int  conf = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea enviar el mensaje?\n1) enviar\n2) guardar como borrador"));
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
                    emp.getBandeja().guardarMensajes();
                    Login();
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Hasta Luego!");
                    emp.getBandeja().guardarMensajes();
                    break;
                case 7:
                    if(emp.getUser().getTipoUsuario().equals("administrador")){
                        menuAdmin();
                        break;
                    }
                    
                    default:
                    JOptionPane.showMessageDialog(null, "Opción Inválida");
                    break;
                }
                emp.setBandeja(BEUser);
            } while (opcion != 7);
            System.exit(0);
    }
    
    public void menuAdmin() {
        // Menú administrador bandeja
        Administrador mab = new Administrador(listaEmpleados, user);
        int opcion;
        do {
            String input = JOptionPane.showInputDialog(
                "1. Registrar usuario\n" +
                            "2. Cambiar Contraseña\n" +
                            "3. Eliminar Usuario\n" +
                            "4. Actualizar Información Usuarios\n" + 
                            "5. Correo\n" +
                            "6. Cerrar Sesión\n" +
                            "7. Salir\n" +
                            "Seleccione una opción:");

            opcion = Integer.parseInt(input);

            switch (opcion) {
                case 1: 
                    mab.registrarUsuarios();
                    break;
                    case 2:
                    String userIDInput = JOptionPane.showInputDialog("Ingrese el ID del Usuario:");
                    Long userID = Long.parseLong(userIDInput);

                    String newPwd = JOptionPane.showInputDialog("Ingrese la Nueva Contraseña:");
                    mab.CambiarContrasena(userID, newPwd);
                    break;
                case 3:
                    String idInput = JOptionPane.showInputDialog("Ingrese el ID del Usuario a Eliminar:");
                    long id = Long.parseLong(idInput);

                    Usuario u = mab.eliminarUsuario(id);
                    if (u == null) {
                        JOptionPane.showMessageDialog(null, "Usuario no Encontrado");
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario Eliminado con Éxito: " + u);
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
                    JOptionPane.showMessageDialog(null, "Hasta Luego!");
                    break;
                    default:
                    JOptionPane.showMessageDialog(null, "Opción Inválida");
                    break;
                }
        } while (opcion != 7);
        System.exit(0);
    }
    
    public void Login() {

        Long idLogin = Long.parseLong(JOptionPane.showInputDialog(null, "Usuario", "Iniciar Sesión", 1));
        String LoginPassword = JOptionPane.showInputDialog(null, "Contraseña", "Iniciar Sesión", 1);

        DoubleNode actUser = listaEmpleados.getLista().first(); 
        while (actUser != null) {
            if((((Empleado) actUser.getDato()).getUser().getId().equals(idLogin)) && ((Empleado) actUser.getDato()).getUser().getContrasena().equals(LoginPassword)){
                if (((Empleado) actUser.getDato()).getUser().getTipoUsuario().equals("administrador")) {
                    this.user = ((Empleado)actUser.getDato()).getUser();
                    this.BEUser = ((Empleado)actUser.getDato()).getBandeja();
                    this.BEUser.setUser(user);
                    this.BEUser.setLista(listaEmpleados);
                    menuAdmin();
                } else {
                    this.BEUser = ((Empleado)actUser.getDato()).getBandeja();
                    this.user = ((Empleado)actUser.getDato()).getUser();
                    this.BEUser = ((Empleado)actUser.getDato()).getBandeja();
                    this.BEUser.setUser(user);
                    this.BEUser.setLista(listaEmpleados);
                    menuEmpleado();
                }
            }
            actUser = actUser.getNext();
        }
        JOptionPane.showMessageDialog(null, "El Usuario no Existe");
    }
}
