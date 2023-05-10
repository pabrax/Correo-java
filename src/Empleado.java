import data_structures.List;
import userClass.Usuario;

public class Empleado {

    protected Usuario user;
    protected BandejaEntrada bandeja;

    public Empleado() {
        this.user = new Usuario();
        this.bandeja = new BandejaEntrada();
    }

    public void revisarBandeja(){
        int i = 0;
        List tempList = bandeja.getNo_leidos();
        if(!tempList.isEmpty()){
            while (tempList != null){
                mensaje msg = (mensaje) tempList.removeFirst();
                // System.out.println("[ "+ (i+1) +" ]. " + msg.getTitulo());
                System.out.println("[ "+ (i+1) +" ]. " + ((mensaje)tempList.removeFirst()).getTitulo());
                i++; 
            }
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
