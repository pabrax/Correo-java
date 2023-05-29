import data_structures.*;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.io.*;

import Objects.*;

public class BandejaEntrada {

    private ListaEmpleados lista; 
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
    }

    public BandejaEntrada(ListaEmpleados lista) {
        this.no_leidos = new List();
        this.leidos = new List();
        this.borrador = new stack();
        this.lista = lista;
    }

    public BandejaEntrada(Usuario usuario) {
        this.no_leidos = new List();
        this.leidos = new List();
        this.borrador = new stack();
        this.user = usuario;
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
    
    public void enviarMensaje(Long destinatario) {
        
        DoubleNode actual = lista.getLista().first();
        msg = redactarMensaje();
        while(actual != null){
            if(((Empleado) actual.getDato()).getUser().getId() == destinatario) {
                if(IsSend()){
                    ((Empleado) actual.getDato()).bandeja.no_leidos.addLast(msg);
                } else {
                    borrador.push(msg);
                }
                return;
            }
            actual = actual.getNext();
        }
        System.out.println("usuario no encontrado");
    }

    public void guardarMensajes() {    
        // guarda los mensajes no leidos
        try {
            String pathfile = (System.getProperty("user.dir") + "/src/Usuarios/" + user.getId() + "BA.txt");
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
            String pathfile = (System.getProperty("user.dir") + "/src/Usuarios/" + user.getId() + "ML.txt");
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
            String pathfile = (System.getProperty("user.dir") + "/src/Usuarios/" + user.getId() + "B.txt");
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



    private Fecha fechaActual() {
        LocalDate fechaActual = LocalDate.now();
        String temp = fechaActual.toString();
        String[] newFecha =temp.split("-");
        Fecha f = new Fecha(Short.parseShort(newFecha[0]),Short.parseShort(newFecha[1]),Short.parseShort(newFecha[2]));
        return f;
    }

    private Boolean IsSend(){
        Boolean enviar = false;
        int comprobacion = Integer.parseInt(JOptionPane.showInputDialog(null, "que desea hacer con el mensaje\n1) enviar mensaje\n2) salir"));
        if (comprobacion == 1) {
            enviar = true;
        }
        return enviar;
    }

}
