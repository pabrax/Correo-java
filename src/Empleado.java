import Objects.Usuario;

public class Empleado {

    protected Usuario user;
    protected BandejaEntrada bandeja;

    public Empleado() {
        this.user = new Usuario();
        this.bandeja = new BandejaEntrada();
    }

    public void revisarBandeja(){
        bandeja.getNo_leidos().print();
    }

    public void verMensajesLeidos(){
        bandeja.getLeidos().print();
    }
    
    public void verBorradores(){
        bandeja.getBorrador().display();
    }


    //*  gets y sets

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    
}
