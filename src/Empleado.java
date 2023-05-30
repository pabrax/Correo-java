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
            JOptionPane.showMessageDialog(null, "no hay mensajes para mostrar");
            return;
        }
        int s = Integer.parseInt(JOptionPane.showInputDialog(null, "seleccione un mensaje:\n-1) salir\n" + bandeja.getNo_leidos().obtenermensajes()));
        if (s == -1) {
            return;
        }
        JOptionPane.showMessageDialog(null, ((mensaje) bandeja.getNo_leidos().get(s)).toString());
        bandeja.getLeidos().addLast(bandeja.getNo_leidos().remove(s));
        // bandeja.getLeidos().addLast(bandeja.getNo_leidos().get(s));
    }

    public void verMensajesLeidos(){
        bandeja.getLeidos().print();
    }

    public void verBorradores(){
        if (bandeja.getBorrador().isEmpty()) {
            JOptionPane.showMessageDialog(null, "no hay borradores por revisar");
            return;
        }
        // bandeja.getBorrador().display();
        int s = Integer.parseInt(JOptionPane.showInputDialog(null, "que desea hacer con el ultimo borrador? \n1) enviar \n2) Descartar\n-1) salir\n\n" + bandeja.getBorrador().display()));
        if (s == -1) {
            return;
        } else if (s == 1) {
            Long dest = Long.parseLong(JOptionPane.showInputDialog(null, "Destinatario:"));
            bandeja.enviarMensaje(bandeja.descartarMensaje(), dest);
        } else if (s == 2) {
            bandeja.descartarMensaje();
        } else {
            JOptionPane.showMessageDialog(null, "parametro no valido");
            verBorradores();

        }

    }
    @Override
    public String toString() {
        return getUser().toString();
    }
}
