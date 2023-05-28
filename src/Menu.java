
import javax.swing.JOptionPane;
import Objects.*;
import java.io.*;
import data_structures.*;

public class Menu {

    public DoubleList listaEmpleados;

    public Menu() {
        this.listaEmpleados = new DoubleList();
    }

    // sets y gets
    public DoubleList getlistaEmpleados() {
        return listaEmpleados;
    }

    public void setlistaEmpleados(DoubleList listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    // metodos propios de la clase

    public void menuEmpleado() {
        // Menú empleado bandeja
        Empleado meb = new Empleado();
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
    }

    public void menuAdmin() {
        // Menú administrador bandeja
        Administrador mab = new Administrador();
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
    }

    
    public void Login() {

        // lee un usuario y una contraseña
        Long idLogin = Long.parseLong(JOptionPane.showInputDialog(null, "Usuario", "iniciar sesion", 1));
        String LoginPassword = JOptionPane.showInputDialog(null, "Contraseña", "iniciar sesion", 1);

        // lee el archivo de contraseñas y valida su identidad
        File file = new File((System.getProperty("user.dir") + "/src/Files/Password.txt"));
;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] data = line.split(" ");
                ValidateUser(idLogin, LoginPassword, data);

            }
        } catch (Exception e) {
            System.out.println("error al leer las credenciales");
        }
    }
    private void ValidateUser(Long idLogin, String LoginPassword, String[] data) {
        Long idUser = Long.parseLong(data[0]);
        String passwd = data[1];
        String tipoUsuario = data[2];
        if (idLogin == idUser && LoginPassword.equals(passwd)) {
            if (tipoUsuario.equals("administrador")) {
                // si es verdadero es Admin
                menuAdmin();
            } else {
                // si es falso es empleado
                menuEmpleado();
            }
        }
    }
}

