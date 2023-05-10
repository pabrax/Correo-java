package userClass;

public class Direccion extends Usuario{
    
    // vars
    private String calle;
    private String nomenclatura;
    private String barrio;
    private String ciudad;
    private String edificio;
    private String apto;

    // constructor
    public Direccion(){}
    

    public Direccion(String calle, String nomenclatura, String barrio, String ciudad, String edificio, String apto) {
        this.calle = calle;
        this.nomenclatura = nomenclatura;
        this.barrio = barrio;
        this.ciudad = ciudad;
        this.edificio = edificio;
        this.apto = apto;
    }


    // sets
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public void setNomenclatura(String nomenclatura) {
        this.nomenclatura = nomenclatura;
    }
    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }
    public void setApto(String apto) {
        this.apto = apto;
    }

    // gets
    public String getCalle() {
        return calle;
    }
    public String getNomenclatura() {
        return nomenclatura;
    }
    public String getBarrio() {
        return barrio;
    }
    public String getCiudad() {
        return ciudad;
    }
    public String getEdificio() {
        return edificio;
    }
    public String getApto() {
        return apto;
    }
    @Override
    public String toString() {
        return calle + " " + nomenclatura + " " + barrio + " " + ciudad + " " + edificio + " " + apto;
    }
} 
