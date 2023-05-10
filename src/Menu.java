/* 
* esta clase se encarga de loguear a un usuario despues de importar la informacion de cada usuario
* se encarga de comparar si un usuario es empleado o admin
* loguea al usuario y muestra un menu de opciones respectivo para cada tipo de usuario
*/

import javax.swing.JOptionPane;
import java.io.*;

import data_structures.*;
import userClass.*;

public class Menu {

    private List listaUsuarios;
    
    public Menu(){
        this.listaUsuarios = new List();
    }

    
    public static void main(String[] args) {
        Menu m = new Menu();
        m.Import();

        // System.out.println(m.getListaUsuarios().First().getDato().toString());
        m.Login();
        
    }

    // sets y gets
    
    public List getListaUsuarios() {
        return listaUsuarios;
    }
    
    public void setListaUsuarios(List listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    // metodos propios de la clase

    public void MenuEmpleado(){
        // crear el menu para el empleado
        // bandeja entrada

        System.out.println("menu Empleado");
    }
    
    public void MenuAdmin(){
        
        // crear el menu para el admin
        // bandeja de entrada
        // herramientas de administrador

        System.out.println("menu Admin");
    }

    // toFile para escribir los usuarios en los archivos de password y Empleados

    public void toFile() {
        try {
            File file = new File((System.getProperty("user.dir")+"/src/empleados/Empleados.txt"));
    
            PrintWriter writer = new PrintWriter(file);
            Node actual = listaUsuarios.First();
            while (actual != null) {
                Usuario u = (Usuario) actual.getDato();
                writer.println(u.toString());
                actual = actual.getNext();
            }
            writer.close();
            
        } catch (Exception e) {
            System.out.println("Error al escribir el archivo");
        }
    }

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

    public void Login(){

        Long idLogin = Long.parseLong(JOptionPane.showInputDialog(null, "Usuario", "iniciar sesion", 1));

        String LoginPassword = JOptionPane.showInputDialog(null, "Contraseña", "iniciar sesion", 1);

        File file = new File((System.getProperty("user.dir")+"/src/empleados/Password.txt"));
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");
                Long idUser = Long.parseLong(data[0]);
                String passwd = data[1];
                String tipoUsuario = data[2];
                
                // ? implementar la seleccion del menu, si es admin o empleado

                if (idLogin == idUser && LoginPassword.equals(passwd)){
                    if (tipoUsuario.equals("administrador")) {
                        MenuAdmin();
                    } else {
                        MenuEmpleado();
                    }
                } 
            }
        } catch (Exception e) {
            System.out.println("error al leer las credenciales");
        }

    }

    public void Import() {
        File file = new File((System.getProperty("user.dir")+"/src/empleados/Empleados.txt"));
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");
                String nombre = data[0];
                long id = Long.parseLong(data[1]);
                short dia = Short.parseShort(data[2]);
                short mes = Short.parseShort(data[3]);
                short anio = Short.parseShort(data[4]);
                Fecha fecha = new Fecha(dia, mes, anio);
                String ciudadNacimiento = data[5];
                long tel = Long.parseLong(data[6]);
                String email = data[7];
                String calle = data[8];
                String nomenclatura = data[9];
                String barrio = data[10];
                String ciudad = data[11];
                String edificio = data[12];
                String apto = data[13];
                Direccion dir = new Direccion(calle, nomenclatura, barrio, ciudad, edificio, apto);
                Usuario usuario = new Usuario(nombre, id, fecha, ciudadNacimiento, tel, email, dir);
                
                Empleado e = new Empleado();
                e.setUser(usuario);
                listaUsuarios.addLast(e);
            }
            br.close();
            System.out.println("Se han importado los usuarios desde el archivo");
        } catch (IOException e) {
            System.out.println("Error al tratar de importar la informacion");
            e.printStackTrace();
        }
    }

}
