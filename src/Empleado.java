import javax.swing.JOptionPane;

import Objects.Usuario;
import Objects.mensaje;

public class Empleado {

    protected Usuario user;
    protected BandejaEntrada bandeja;

    public Empleado() {
        this.user = new Usuario();
        this.bandeja = new BandejaEntrada();
    }

    public Empleado(Usuario usuario, ListaEmpleados listaEmpleados) {
        this.user = usuario;
        this.bandeja = new BandejaEntrada(usuario, listaEmpleados);
    }

    public Empleado(Usuario usuario) {
        this.user = usuario;
        this.bandeja = new BandejaEntrada();
    }

    
    // gets y sets
    public Usuario getUser() {
        return user;
    }
    public void setUser(Usuario user) {
        this.user = user;
    }
    public BandejaEntrada getBandeja() {
        return bandeja;
    }  
    public void setBandeja(BandejaEntrada bandeja) {
        this.bandeja = bandeja;
    }
    
    public void revisarBandeja(){
        if (bandeja.getNo_leidos().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay Mensajes para Mostrar");
            return;
        }
        int s = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione un Mensaje:\n" + bandeja.getNo_leidos().obtenermensajes() + "\n-1) Salir"));
        if (s == -1) {
            return;
        }
        JOptionPane.showMessageDialog(null, ((mensaje) bandeja.getNo_leidos().get(s)).toString());
        bandeja.getLeidos().addLast(bandeja.getNo_leidos().remove(s));
    }
    
    public void verMensajesLeidos(){
        if (bandeja.getLeidos().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay Mensajes Leidos"); 
            return;
        }
        bandeja.getLeidos().print();
    }

    public void verBorradores(){
        if (bandeja.getBorrador().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No Hay Borradores por Revisar");
            return;
        }
        int s = Integer.parseInt(JOptionPane.showInputDialog(null, "Borradores\n" + bandeja.getBorrador().top() + "\n\nQuiere enviar el ultimo borrador?\n1) Enviar \t\t2) Descartar\n0) Salir\n"));
        if (s == 0) {
            return;
        } else if (s == 1) {
            mensaje msg = bandeja.descartarMensaje();
            Long dest = msg.getDest();
            bandeja.enviarMensaje(msg, dest);
        } else if (s == 2) {
            bandeja.descartarMensaje();
        } else {
            JOptionPane.showMessageDialog(null, "Parámetro no Valido");
            verBorradores();
        }
    }
    
    @Override
    public String toString() {
        return getUser().toString();
    }
}
