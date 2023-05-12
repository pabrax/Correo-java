package Objects;
import Objects.*;

public class mensaje {
    
    private String titulo;
    private Fecha fechaEnvio;
    private String nameUser;
    private String contenido;
    
    
    public mensaje() {
        this.titulo = null;
        this.fechaEnvio = null;
        this.nameUser = null;
        this.contenido = null;
    }
    
    public mensaje(String nameUser, String titulo, String contenido , Fecha fechaEnvio) {
        this.titulo = titulo;
        this.fechaEnvio = fechaEnvio;
        this.nameUser = nameUser;
        this.contenido = contenido;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Fecha getFechaEnvio() {
        return fechaEnvio;
    }
    public void setFechaEnvio(Fecha fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }
    public String getNameUser() {
        return nameUser;
    }
    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String toString() {
        return "mensaje [titulo=" + titulo + "\n" + fechaEnvio + ", nameUser=" + nameUser + ", contenido="
                + contenido + "]";
    }
    
    
}