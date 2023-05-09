import user.Usuario;

public class Empleado {

    protected Usuario user;
    protected BandejaEntrada bandeja;

    public Empleado() {
        this.user = new Usuario();
        this.bandeja = new BandejaEntrada();
    }

    public void revisarBandeja(){
        while (bandeja.getNo_leidos() != null){
            
        }
    }

    public void verMensajesLeidos(){
        
    }

    public void VerBorradores(){
    }


    //*  gets y sets

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    
}
