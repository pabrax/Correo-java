import data_structures.List;

public class test {
    public static void main(String[] args) {
        MenuTools m = new MenuTools();
        m.Import();

        List listaEmpleados = m.getListaUsuarios();
        
        // System.out.println(((Empleado) listaEmpleados.First().getDato()).getUser().toString(););
        ((Empleado) listaEmpleados.First().getDato()).revisarBandeja();
    }
}