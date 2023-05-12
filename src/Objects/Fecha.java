package Objects;

public class Fecha extends Usuario{

    // vars
    private short dd;
    private short mm;
    private short aa;

    // constructor
    public Fecha(){}

    public Fecha(Short dd, Short mm, Short aa){
        this.dd = dd;
        this.mm = mm;
        this.aa = aa;
    }

    // sets
    public void setDia(short dd) {
        this.dd = dd;
    }
    public void setMes(short mm) {
        this.mm = mm;
    }
    public void setA(short aa) {
        this.aa = aa;
    }

    // gets
    public short getDia() {
        return dd;
    }
    public short getMes() {
        return mm;
    }
    public short getA() {
        return aa;
    }
    @Override
    public String toString() {
        return dd + " " + mm + " " + aa;
    }
}