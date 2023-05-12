/* 
* esta clase se encarga de loguear a un usuario despues de importar la informacion de cada usuario
* se encarga de comparar si un usuario es empleado o admin
* loguea al usuario y muestra un menu de opciones respectivo para cada tipo de usuario
*/

import javax.swing.JOptionPane;

import Objects.*;

import java.io.*;
import data_structures.*;

public class Menu {

    protected List listaUsuarios;

    public Menu() {
        this.listaUsuarios = new List();
    }

    // sets y gets

    public List getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    // metodos propios de la clase

    public void MenuEmpleado() {
        // crear el menu para el empleado
        // bandeja entrada
        System.out.println("menu Empleado");
    }

    public void MenuAdmin() {
        // crear el menu para el admin
        // bandeja de entrada
        // herramientas de administrador
        System.out.println("menu Admin");
    }

    // toFile para escribir los usuarios en los archivos de password y Empleados

    public Node Buscar(Long id) {
        Node actual = listaUsuarios.First();
        while (actual != null) {
            Usuario u = (Usuario) actual.getDato();
            if (u.getId() == id) {
                return actual;
            }
            actual = actual.getNext();
        }
        return null;
    }

    public void Login() {

        // lee un usuario y una contraseña
        Long idLogin = Long.parseLong(JOptionPane.showInputDialog(null, "Usuario", "iniciar sesion", 1));
        String LoginPassword = JOptionPane.showInputDialog(null, "Contraseña", "iniciar sesion", 1);

        // lee el archivo de contraseñas y valida su identidad
        File file = new File((System.getProperty("user.dir") + "/src/Files/Password.txt"));
        MenuTools mt = new MenuTools();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] data = line.split(" ");
                mt.ValidateUser(idLogin, LoginPassword, data);
                
            }

            System.out.println("el Usuario digitado no es valido");
            Login();
        } catch(Exception e) {
            System.out.println("error al leer las credenciales");
        }
    }
}

