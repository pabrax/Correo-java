
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
                    input = JOptionPane.showInputDialog(null,
                            "1. Redactar Mensaje\n" +
                            "2. Revisar Bandeja de Entrada\n" +
                            "3. Ver Mensajes Leídos\n" +
                            "4. Ver Borradores\n" +
                            "5. Administrar\n" +
                            "6. Cerrar Sesión\n" +
                            "7. Salir\n" +
                            "Seleccione Una Opción:","Menu Gestión Mensajes",1);
                }else{
                    input = JOptionPane.showInputDialog(null,
                            "1. Redactar Mensaje\n" +
                            "2. Revisar Bandeja de Entrada\n" +
                            "3. Ver Mensajes Leídos\n" +
                            "4. Ver Borradores\n" +
                            "5. Cerrar Sesion\n" +
                            "6. Salir\n" +
                            "Seleccione una Opción:","Menu Opc Mensajes",1);
                }           
            opcion = Integer.parseInt(input);
            
            switch (opcion) {
                case 1:
                    Long idDest = Long.parseLong(JOptionPane.showInputDialog(null, "Digite el ID del Destinatario","Mensaje Nuevo",1));
                    mensaje m = emp.bandeja.redactarMensaje();
                    m.setDest(idDest);
                    int  conf = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea Enviar el Mensaje?\n1. Enviar\n2. Guardar como Borrador","Mensaje Nuevo",1));
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
                    if(emp.getUser().getTipoUsuario().equals("administrador")){
                        emp.getBandeja().guardarMensajes();
                        menuAdmin();
                        break;
                    }
                case 6:
                    emp.getBandeja().guardarMensajes();
                    Login();
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Hasta Luego!");
                    emp.getBandeja().guardarMensajes();
                    break;

                    
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
            String input = JOptionPane.showInputDialog(null,
                            "1. Correo\n" +
                            "2. Registrar Usuario\n" +
                            "3. Cambiar Contraseña a Usuario\n" +
                            "4. Eliminar Usuario\n" +
                            "5. Buscar Usuario\n" +
                            "6. Actualizar Información Usuario\n" + 
                            "7. Cerrar Sesión\n" +
                            "8. Salir\n" +
                            "Seleccione una Opción: ","Menu Admin",1);

            opcion = Integer.parseInt(input);

            switch (opcion) {
                case 1:
                    menuEmpleado();
                    break;
                case 2: 
                    mab.registrarUsuarios();
                    break;
                case 3:
                    String userIDInput = JOptionPane.showInputDialog("Ingrese el ID del Usuario:");
                    Long userID = Long.parseLong(userIDInput);

                    String newPwd = JOptionPane.showInputDialog("Ingrese la Nueva Contraseña: ");
                    mab.CambiarContrasena(userID, newPwd);
                    break;
                case 4:
                    String idInput = JOptionPane.showInputDialog("Ingrese el ID del Usuario a Eliminar: ");
                    long id = Long.parseLong(idInput);
                    
                    Usuario u = mab.eliminarUsuario(id);
                    if (u == null) {
                        JOptionPane.showMessageDialog(null, "Usuario no Encontrado");
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario Eliminado con Éxito: " + u);
                    }
                    break;
                case 5:
                    opcList o = new opcList(listaEmpleados);
                    Long idsearch = Long.parseLong(JOptionPane.showInputDialog("Ingrese el ID del Usuario a Eliminar:"));
                    JOptionPane.showMessageDialog(null, ((Empleado) o.Buscar(idsearch).getDato()).getUser().toString());
                    break;
                case 6:
                    mab.actualizarInfo();
                    break;
                case 7:
                    opcList s = new opcList();
                    s.Import();
                    Login();
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "Hasta Luego!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción Inválida");
                    break;
                }
        } while (opcion != 8);
        System.exit(0);
    }
    
    public void Login() {
        Long idLogin = Long.parseLong(JOptionPane.showInputDialog(null, "Usuario", "Iniciar Sesión", 1));
        String LoginPassword = JOptionPane.showInputDialog(null, "Contraseña", "Iniciar Sesión", 1);
        DoubleNode actUser = listaEmpleados.getLista().first(); 
        while (actUser != null) {
            if((((Empleado) actUser.getDato()).getUser().getId().equals(idLogin)) && ((Empleado) actUser.getDato()).getUser().getContrasena().equals(LoginPassword)){
                if (((Empleado) actUser.getDato()).getUser().getTipoUsuario().equals("administrador")) {
                    loginSets(actUser);
                    menuAdmin();
                } else {
                    loginSets(actUser);
                    menuEmpleado();
                }
            }
            actUser = actUser.getNext();
        }
        JOptionPane.showMessageDialog(null, "El Usuario no Existe");
    }

    private void loginSets(DoubleNode actUser){
        this.user = ((Empleado)actUser.getDato()).getUser();
        this.BEUser = ((Empleado)actUser.getDato()).getBandeja();
        this.BEUser.setUser(user);
        this.BEUser.setLista(listaEmpleados);
    }
}
