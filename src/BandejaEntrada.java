import data_structures.*;
import user.*;


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




}
