
// import Objects.mensaje;

public class test {
    public static void main(String[] args) {
        opcList o = new opcList();
        o.Import();
        ListaEmpleados listaEmpleados = o.getListaEmpleados();
        // Menu m = new Menu(listaEmpleados);
        // m.Login();

        Empleado empleado = ((Empleado) listaEmpleados.getLista().first().getDato());
        BandejaEntrada b = empleado.getBandeja();
           
        b.enviarMensaje(b.redactarMensaje(), empleado.getUser().getId());
        empleado.revisarBandeja();
        // a.registrarUsuarios(); // si se registra un user, cuando guarda el archivo borra su contenido
        // listaEmpleados.getLista().print(); // ? muestra mas no en texto plano
        // // a.eliminarUsuario(1075689);
        // a.actualizarInfo();


    }
}


