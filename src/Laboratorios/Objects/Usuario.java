package Objects;

// import java.io.*;

public class Usuario {

    private String nombre;
    private Long id;
    private Fecha fecha;
    private String ciudad_nacimiento;
    private long tel;
    private String email;
    private Direccion dir;

    private String contrasena;
    private String TipoUsuario;

    // constructores

    public Usuario() {
    }

    public Usuario(String n,long id, Fecha fecha,String ciudad_nacimiento,long tel,String email,Direccion dir){
        this.nombre =  n;
        this.id = id;
        this.fecha = fecha;
        this.ciudad_nacimiento = ciudad_nacimiento;
        this.tel = tel;
        this.email = email;
        this.dir = dir;
    }

    public Usuario(String n, long id) {
        this.nombre = n;
        this.id = id;
    }

    // sets
    public void setTipoUsuario(String tipo) {
        this.TipoUsuario = tipo;
    }

    public void setContrasena(String pwd) {
        this.contrasena = pwd;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public void setCiudad_nacimiento(String ciudad_nacimiento) {
        this.ciudad_nacimiento = ciudad_nacimiento;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDir(Direccion dir) {
        this.dir = dir;
    }

    // gets

    public String getTipoUsuario() {
        return TipoUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getnombre() {
        return nombre;
    }

    public Long getId() {
        return id;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public String getCiudad_nacimiento() {
        return ciudad_nacimiento;
    }

    public long getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public Direccion getDir() {
        return dir;
    }

    @Override
    public String toString() {
        return nombre + " " + id + " " + fecha + " " + ciudad_nacimiento + " " + tel + " " + email + " " + dir;
    }
}
