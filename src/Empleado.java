import Objects.Usuario;

public class Empleado {

    protected Usuario user;
    protected BandejaEntrada bandeja;

    public Empleado() {
        this.user = new Usuario();
        this.bandeja = new BandejaEntrada();
    }

    public Empleado(Usuario usuario) {
        this.user = usuario;
        this.bandeja = new BandejaEntrada(usuario);
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
        bandeja.getNo_leidos().print();
    }

    public void verMensajesLeidos(){
        bandeja.getLeidos().print();
    }

    public void verBorradores(){
        bandeja.getBorrador().display();
    }
    
}
