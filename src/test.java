import Objects.Usuario;

public class test {
    public static void main(String[] args) {
        opcList o = new opcList();
        o.Import();
        ListaEmpleados listaEmpleados = o.getListaEmpleados();
        // Menu m = new Menu(listaEmpleados);
        // m.Login();
        Usuario user = ((Empleado) listaEmpleados.getLista().first().getDato()).getUser();
        // Administrador a = new Administrador(listaEmpleados, user);
        
        
        // a.registrarUsuarios(); // si se registra un user, cuando guarda el archivo borra su contenido
        // listaEmpleados.getLista().print(); // ? muestra mas no en texto plano
        // // a.eliminarUsuario(1075689);
        // a.actualizarInfo();
        Empleado e = new Empleado(user);
        e.revisarBandeja();
        e.verBorradores();
        e.verMensajesLeidos();

    }
}


