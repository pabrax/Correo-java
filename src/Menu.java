/* 
* esta clase se encarga de loguear a un usuario despues de importar la informacion de cada usuario
* se encarga de comparar si un usuario es empleado o admin
* loguea al usuario y muestra un menu de opciones respectivo para cada tipo de usuario
*/

import javax.swing.JOptionPane;
import java.io.*;
import user.*;
import data_structures.*;

public class Menu {

    private List listaUsuarios;
    
    public Menu(){
        
    }

    public void MenuEmpleado(){
        // crear el menu para el empleado
    }

    public void MenuAdmin(){
        // crear el menu para el admin
    }

    public void toFile() {
        // toFIle para escribir los usuarios en los archivos de password y Empleados
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
        JOptionPane jop = new JOptionPane();
        Long id = Long.parseLong(jop.showInputDialog(null, "contraseña", "iniciar sesion", 0));

        String LoginPassword = jop.showInputDialog(null, "Usuario", "iniciar sesion", 0);

        File file = new File((System.getProperty("user.dir")+"/src/empleados/Password.txt"));
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");
                Long idUser = Long.parseLong(data[0]);
                String passwd = data[1];
                String tipoUsuario = data[2];
                
                if (id == idUser && LoginPassword.equals(passwd)){
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
                listaUsuarios.addLast(usuario);
            }
            br.close();
            System.out.println("Se han importado los usuarios desde el archivo");
        } catch (IOException e) {
            System.out.println("Error al tratar de importar la informacion");
            e.printStackTrace();
        }
        

    }

    public List getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
}
