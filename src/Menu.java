/* 
* esta clase se encarga de loguear a un usuario despues de importar la informacion de cada usuario
* se encarga de comparar si un usuario es empleado o admin
* loguea al usuario y muestra un menu de opciones respectivo para cada tipo de usuario
*/

import javax.swing.JOptionPane;
import java.io.*;
import user.*;
import data_structures.List;

public class Menu {

    private List listaUsuarios;
    
    public Menu(){
        
    }

    public void Login(){
        Empleado e = new Empleado();
        if (e.user.getId()== Buscar()) {// ? corregir linea; agregarel retorno de un metodo que lea el archivo de passwords.txt
            e = new Administrador();
            
        }

    }

    public void MenuEmpleado(){

    }

    public void MenuAdmin(){
        
    }

    public void toFile() {
        // toFIle para escribir los usuarios en los archivos de password y Empleados
    }

    public Long Buscar() {
        // se encarga de buscar un usuario y devolver
        // try para buscar en el archivo
        try {
            
        } catch (Exception e) {
            
        }
        return 0l;
        
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
