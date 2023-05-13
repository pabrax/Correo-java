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

    List listaEmpleados;

    public Menu() {
        this.listaEmpleados = new List();
    }

    // sets y gets
    public List getlistaEmpleados() {
        return listaEmpleados;
    }

    public void setlistaEmpleados(List listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
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
        Node actual = listaEmpleados.First();
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
        } catch(Exception e) {
            System.out.println("error al leer las credenciales");
        }
    }
}


class MenuTools extends Menu {
    
    public void ValidateUser(Long idLogin, String LoginPassword, String[] data) {
        Long idUser = Long.parseLong(data[0]);
        String passwd = data[1];
        String tipoUsuario = data[2];
        if (idLogin == idUser && LoginPassword.equals(passwd)){
            if (tipoUsuario.equals("administrador")) {
                // si es verdadero es Admin
                MenuAdmin();
            } else {
                // si es falso es empleado
                MenuEmpleado();
            }
        }    
    }

    public void toFile() {
        try {
            File file = new File((System.getProperty("user.dir") + "/src/Files/Empleados.txt"));

            PrintWriter writer = new PrintWriter(file);
            Node actual = listaEmpleados.First();
            while (actual != null) {
                Usuario u = (Usuario) actual.getDato();
                writer.println(u.toString());
                actual = actual.getNext();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error al guardar los usuarios");
        }

        try {
            File file = new File((System.getProperty("user.dir") + "/src/Files/Password.txt"));

            PrintWriter writer = new PrintWriter(file);
            Node actual = listaEmpleados.First();
            while (actual != null) {
                Usuario u = (Usuario) actual.getDato();
                String credenciales = (u.getId() + u.getContrasena() + u.getTipoUsuario()); 
                writer.println(credenciales);
                actual = actual.getNext();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error al guardar las credenciales");
        }

    }

    public void Import() {
        
        File file = new File((System.getProperty("user.dir") + "/src/Files/Empleados.txt"));
        File filePwd = new File((System.getProperty("user.dir") + "/src/Files/Password.txt"));
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            String line2;
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


                try (BufferedReader br2 = new BufferedReader(new FileReader(filePwd))) {
                    line2 = br2.readLine();
                    String[] credentials = line2.split(" ");
                    br2.close();

                    System.out.println("Se han importado las credenciales desde el archivo");
                } catch (IOException e) {
                    System.out.println("Error al tratar de importar la informacion");
                    e.printStackTrace();
                }

                Empleado e = new Empleado();
                e.setUser(usuario);
                listaEmpleados.addLast(e);
            }
            br.close();
            System.out.println("Se han importado los usuarios desde el archivo");
        } catch (IOException e) {
            System.out.println("Error al tratar de importar la informacion");
            e.printStackTrace();
        }



    }

    public Usuario create() {
        Usuario user = new Usuario();
        Fecha fecha = new Fecha();
        Direccion dir = new Direccion();
        user.setnombre(JOptionPane.showInputDialog(null, "Nombre"));
        user.setId(Long.parseLong(JOptionPane.showInputDialog(null, "ID")));
        user.setCiudad_nacimiento(JOptionPane.showInputDialog(null, "ciudad de nacimiento"));
        user.setTel(Long.parseLong(JOptionPane.showInputDialog(null, "Telefono")));
        
        fecha.setDia(Short.parseShort(JOptionPane.showInputDialog(null, "Fecha:\nDia")));
        fecha.setMes(Short.parseShort(JOptionPane.showInputDialog(null, "Fecha:\nMes")));
        fecha.setA(Short.parseShort(JOptionPane.showInputDialog(null, "Fecha:\nAño")));
        user.setFecha(fecha);
        
        user.setEmail(JOptionPane.showInputDialog(null, "Email"));

        dir.setCalle(JOptionPane.showInputDialog(null, "Direccion:\nCalle"));
        dir.setNomenclatura(JOptionPane.showInputDialog(null, "Direccion:\nNomenclatura"));
        dir.setBarrio(JOptionPane.showInputDialog(null, "Direccion:\nBarrio"));
        dir.setCiudad(JOptionPane.showInputDialog(null, "Direccion:\nCiudad"));
        dir.setEdificio(JOptionPane.showInputDialog(null, "Direccion:\nEdificio"));
        dir.setApto(JOptionPane.showInputDialog(null, "Direccion:\nApartamento"));
        user.setDir(dir);

        return user;
    }
}

