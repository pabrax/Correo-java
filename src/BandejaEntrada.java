import data_structures.*;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.io.*;

import Objects.*;

public class BandejaEntrada {

    private ListaEmpleados lista; 
    // colecciones de datos
    private DoubleList no_leidos;
    private DoubleList leidos;
    private stack borrador;
    private mensaje msg;

    // otras clases
    private Usuario user;

    public BandejaEntrada() {
        this.no_leidos = new DoubleList();
        this.leidos = new DoubleList();
        this.borrador = new stack();
    }

    public BandejaEntrada(Usuario usuario, ListaEmpleados lista) {
        this.no_leidos = new DoubleList();
        this.leidos = new DoubleList();
        this.borrador = new stack();
        this.user = usuario;
        this.lista = lista;
    }

    // gets y sets
    public DoubleList getNo_leidos() {
        return no_leidos;
    }
    public void setNo_leidos(DoubleList no_leidos) {
        this.no_leidos = no_leidos;
    }

    public DoubleList getLeidos() {
        return leidos;
    }
    public void setLeidos(DoubleList leidos) {
        this.leidos = leidos;
    }

    public stack getBorrador() {
        return borrador;
    }
    public void setBorrador(stack borrador) {
        this.borrador = borrador;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    public Usuario getUser() {
        return user;
    }

    public void setLista(ListaEmpleados lista) {
        this.lista = lista;
    }

    // metodos de la clase
    public mensaje descartarMensaje() {
        return (mensaje) borrador.pop();
    }
    
    public mensaje redactarMensaje() {
        String titulo = JOptionPane.showInputDialog(null, "Titulo", "Nuevo Mensaje", 1);
        String contenido = JOptionPane.showInputDialog(null, "Mensaje", "Nuevo Mensaje", 1);
        String nameUser = user.getnombre(); 
        Fecha f = fechaActual();
        msg = new mensaje(nameUser, titulo, contenido, f);
        return msg;
    }
    

    public void enviarMensaje(mensaje m, Long destinatario) {
        DoubleNode actual = lista.getLista().first();
        while(actual != null){
            if(((Empleado) actual.getDato()).getUser().getId().equals(destinatario)) {
                ((Empleado) actual.getDato()).getBandeja().getNo_leidos().addLast(m);
                return;
            }
            actual = actual.getNext();
        }
        System.out.println("Usuario no Encontrado");
    }
    
    
    private Fecha fechaActual() {
        LocalDate fechaActual = LocalDate.now();
        String temp = fechaActual.toString();
        String[] newFecha =temp.split("-");
        Fecha f = new Fecha(Short.parseShort(newFecha[0]),Short.parseShort(newFecha[1]),Short.parseShort(newFecha[2]));
        return f;
    }
    
    public void guardarMensajes() {    

        try {
            String pathfile = (System.getProperty("user.dir") + "/src/Usuarios/" + user.getId() + "/BA.txt");
            File archivo = new File(pathfile);

            if(!archivo.getParentFile().exists()){
                if(archivo.getParentFile().mkdirs()){
                    System.out.println("Carpeta " + user.getId() +" Creada");
                } else {
                    System.out.println("No Se ha Podido Crear la Carpeta");
                }
            }
            
            FileWriter escritor = new FileWriter(archivo);
            BufferedWriter buffer = new BufferedWriter(escritor);
            while (!no_leidos.isEmpty()) {
                String elemento = ((mensaje) no_leidos.removeLast()).toStringFile();
                buffer.write(elemento);
                buffer.write("\n");
            }
            buffer.close();
        } catch (IOException e) {
            System.out.println("Error al Escribir en el Archivo: " + e.getMessage());
        }
        
        try {
            String pathfile = (System.getProperty("user.dir") + "/src/Usuarios/" + user.getId() + "/ML.txt");
            File archivo = new File(pathfile);

            if(!archivo.getParentFile().exists()){
                if(archivo.getParentFile().mkdirs()){
                    System.out.println("Carpeta " + user.getId() +" Creada");
                } else {
                    System.out.println("No se ha podido Crear la Carpeta");
                }
            }

            FileWriter escritor = new FileWriter(archivo);
            BufferedWriter buffer = new BufferedWriter(escritor);
            while (!leidos.isEmpty()) {
                String elemento = ((mensaje) leidos.removeLast()).toStringFile();
                buffer.write(elemento);
                buffer.write("\n");
            }
            buffer.close();
        } catch (IOException e) {
            System.out.println("Error al Escribir en el Archivo: " + e.getMessage());
        }
        
        try {
            String pathfile = (System.getProperty("user.dir") + "/src/Usuarios/" + user.getId() + "/B.txt");
            File archivo = new File(pathfile);
            
            if(!archivo.getParentFile().exists()){
                if(archivo.getParentFile().mkdirs()){
                    System.out.println("Carpeta " + user.getId() +" Creada");
                } else {
                    System.out.println("No Se ha Podido Crear la Carpeta");
                }
            }
            
            FileWriter escritor = new FileWriter(archivo);
            BufferedWriter buffer = new BufferedWriter(escritor);
            while (!borrador.isEmpty()) {
                String elemento = ((mensaje) borrador.pop()).toStringFile();
                buffer.write(elemento);
                buffer.write("\n");
            }
            buffer.close();
        } catch (IOException e) {
            System.out.println("Error al Escribir en el Archivo: " + e.getMessage());
        }
    }

    
}
