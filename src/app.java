public class app {
    public static void main(String[] args) {
        opcList o = new opcList();
        o.Import();
        ListaEmpleados listaEmpleados = o.getListaEmpleados();
        Menu m = new Menu(listaEmpleados);
        m.Login(); 
    }
}
