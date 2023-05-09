import data_structures.*;
import user.*;

import java.io.*;

public class BandejaEntrada {

    // colecciones de datos

    private List no_leidos;
    private List leidos;
    private stack borrador;
    private mensaje msg;

    // otras clases
    private Usuario user;


    public BandejaEntrada() {
        this.no_leidos = new List();
        this.leidos = new List();
        this.borrador = new stack();
        this.user = new Usuario();
    }

    public void redactarMensaje() {

    }

    public mensaje descartarMensaje() {
        return (mensaje) borrador.pop();
    }

    public mensaje enviarMensaje(String nameUser) {
        msg.setNameUser(nameUser);
        
        return msg;

    }

    // gets y sets

    public List getNo_leidos() {
        return no_leidos;
    }

    public void setNo_leidos(List no_leidos) {
        this.no_leidos = no_leidos;
    }

    public List getLeidos() {
        return leidos;
    }

    public void setLeidos(List leidos) {
        this.leidos = leidos;
    }

    public stack getBorrador() {
        return borrador;
    }

    public void setBorrador(stack borrador) {
        this.borrador = borrador;
    }

    public void guardarMensajes() {
        
        // guarda los mensajes no leidos
        
        try {
            String pathfile = (System.getProperty("user.dir") + "/src/Mensajes/" + user.getId() + "BA.txt");
            File archivo = new File(pathfile);

            if(!archivo.getParentFile().exists()){
                if(archivo.getParentFile().mkdirs()){
                    System.out.println("carpeta " + user.getId() +" creada");
                } else {
                    System.out.println("no se ha podido crear la carpeta");
                }
            }
            
            FileWriter escritor = new FileWriter(archivo);
            BufferedWriter buffer = new BufferedWriter(escritor);
            
            while (!no_leidos.isEmpty()) {
                String elemento = no_leidos.removeLast().toString();
                buffer.write(elemento);
                buffer.write("\n");
            }
            buffer.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
        
        // guarda los mensajes leidos
        
        try {
            String pathfile = (System.getProperty("user.dir") + "/src/Mensajes/" + user.getId() + "ML.txt");
            File archivo = new File(pathfile);

            if(!archivo.getParentFile().exists()){
                if(archivo.getParentFile().mkdirs()){
                    System.out.println("carpeta " + user.getId() +" creada");
                } else {
                    System.out.println("no se ha podido crear la carpeta");
                }
            }

            FileWriter escritor = new FileWriter(archivo);
            BufferedWriter buffer = new BufferedWriter(escritor);
            
            while (!leidos.isEmpty()) {
                String elemento = leidos.removeLast().toString();
                buffer.write(elemento);
                buffer.write("\n");
            }
            buffer.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
        
        // guarda los borradores
        
        try {
            String pathfile = (System.getProperty("user.dir") + "/src/Mensajes/" + user.getId() + "B.txt");
            File archivo = new File(pathfile);
            
            if(!archivo.getParentFile().exists()){
                if(archivo.getParentFile().mkdirs()){
                    System.out.println("carpeta " + user.getId() +" creada");
                } else {
                    System.out.println("no se ha podido crear la carpeta");
                }
            }
            
            FileWriter escritor = new FileWriter(archivo);
            BufferedWriter buffer = new BufferedWriter(escritor);
            
            while (!borrador.isEmpty()) {
                String elemento = borrador.pop().toString();
                buffer.write(elemento);
                buffer.write("\n");
            }
            buffer.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
        
    }


}
