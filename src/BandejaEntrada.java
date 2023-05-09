import data_structures.*;
import user.*;

import java.io.*;


public class BandejaEntrada {
    
    //  colecciones de datos

    private Administrador amdin = new Administrador(); 
    private List no_leidos;
    private List leidos;
    private stack borrador;
    
    // otras clases
    private Usuario user;
    private Fecha fechaMensaje;

    public BandejaEntrada() {
        this.no_leidos = new List();
        this.leidos = new List();
        this.borrador = new stack();
        this.user = new Usuario();
        this.fechaMensaje = new Fecha();
    }

    public void redactarMensaje(){
    }

    public void descartarMensaje(){
        
    }
    
    public void enviarMensaje(){
    }

    public void guardarMensajes() {

        String pathfile = (System.getProperty("user.dir") + "" + "" + "");



        try {
            FileWriter escritor = new FileWriter(
                    new File(System.getProperty("user.dir") + "/src/DB/usuariosatendidos.txt"));
            BufferedWriter buffer = new BufferedWriter(escritor);

            while (!usuarioAtendido.isEmpty()) {
                String elemento = usuarioAtendido.pop().toString();
                buffer.write(elemento);
                buffer.write("\n");
            }
            buffer.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }

        try {
            FileWriter escritor = new FileWriter(
                    new File(System.getProperty("user.dir") + "/src/DB/usuariosatendidos.txt"));
            BufferedWriter buffer = new BufferedWriter(escritor);

            while (!usuarioAtendido.isEmpty()) {
                String elemento = usuarioAtendido.pop().toString();
                buffer.write(elemento);
                buffer.write("\n");
            }
            buffer.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }

        try {
            FileWriter escritor = new FileWriter(
                    new File(System.getProperty("user.dir") + "/src/DB/usuariosatendidos.txt"));
            BufferedWriter buffer = new BufferedWriter(escritor);

            while (!usuarioAtendido.isEmpty()) {
                String elemento = usuarioAtendido.pop().toString();
                buffer.write(elemento);
                buffer.write("\n");
            }
            buffer.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
        
    }


}
