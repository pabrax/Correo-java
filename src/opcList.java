import Objects.*;
import data_structures.*;

import java.io.*;
import javax.swing.JOptionPane;

public class opcList {

    ListaEmpleados listaEmpleados;

    public opcList(ListaEmpleados lista) {
        this.listaEmpleados = lista;
    }
    public opcList() {
        this.listaEmpleados = new ListaEmpleados();
    }

    public ListaEmpleados getListaEmpleados() {
        return listaEmpleados;
    }
    
    public DoubleNode BuscarC(Long id) {
        DoubleNode actual = listaEmpleados.getLista().first();
        while (actual != null) {
            Usuario u = ((Empleado) actual.getDato()).getUser();
            if (u.getId().equals(id)) {
                return actual;
            }
            actual = actual.getNext();
        }
        return null;
    }

    public DoubleNode Buscar(Long id) {
        DoubleNode actual = listaEmpleados.getLista().first();
        while (actual != null) {
            if (actual.getDato() instanceof Empleado) {
                Empleado empleado = (Empleado) actual.getDato();
                Usuario u = empleado.getUser();
                if (u.getId().equals(id)) {
                    return actual;
                }
            }
            actual = actual.getNext();
        }
        return null;
    }

    public void toFile() {
        try {
            File file = new File((System.getProperty("user.dir") + "/src/Files/Empleados.txt"));

            FileWriter fWriter = new FileWriter(file); // linea que borra la informacion
            BufferedWriter writer = new BufferedWriter(fWriter);
            DoubleNode actual = listaEmpleados.getLista().first();
            while (actual != null) {
                Usuario u = ((Empleado) actual.getDato()).getUser();
                writer.write(u.toString());
                writer.newLine();
                actual = actual.getNext();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error al Guardar los Usuarios");
        }

        try {
            File file = new File((System.getProperty("user.dir") + "/src/Files/Password.txt"));

            FileWriter fWriter = new FileWriter(file); // linea que borra la informacion
            BufferedWriter writer = new BufferedWriter(fWriter);
            DoubleNode actual = listaEmpleados.getLista().first();
            while (actual != null) {
                Usuario u = ((Empleado) actual.getDato()).getUser();
                String credenciales = (u.getId() + " " + u.getContrasena() + " " + u.getTipoUsuario());
                writer.write(credenciales);
                writer.newLine();
                actual = actual.getNext();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error al Guardar las Credenciales");
        }
    }

   
    public void Import() {

        File file = new File((System.getProperty("user.dir") + "/src/Files/Empleados.txt"));
        File filePwd = new File((System.getProperty("user.dir") + "/src/Files/Password.txt"));
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            List credenciales = new List();
            try (BufferedReader br2 = new BufferedReader(new FileReader(filePwd))) {
                String line2;
                while ((line2 = br2.readLine()) != null) {
                    String[] credentials = line2.split(" ");
                    credenciales.addLast(credentials);
                }
                br2.close();
                System.out.println("Se han Importado las Credenciales Desde el Archivo");
            } catch (IOException e) {
                System.out.println("Error al Tratar de Importar la Información");
                e.printStackTrace();
            }

            int credIndex = 0;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");
                Usuario usuario = userData(data);
                usuario.setContrasena(((String[]) credenciales.get(credIndex))[1]);
                usuario.setTipoUsuario(((String[]) credenciales.get(credIndex))[2]);
                credIndex += 1;
                Empleado e = new Empleado(usuario);
                listaEmpleados.getLista().addLast(e);
            }
            br.close();
            System.out.println("Se han Importado los Usuarios Desde el Archivo");

        } catch (IOException e) {
            System.out.println("Error al Tratar de Importar la Información");
            e.printStackTrace();
        }
    }

    private Usuario userData(String[] data) {
        String nombre = data[0];
        long id = Long.parseLong(data[1]);
        short dia = Short.parseShort(data[2]);
        short mes = Short.parseShort(data[3]);
        short anio = Short.parseShort(data[4]);
        Fecha fecha = new Fecha(dia, mes, anio);
        String ciudadNacimiento = data[5];
        long tel = Long.parseLong(data[6]);
        String email = data[7];
        String calle = data[8];
        String nomenclatura = data[9];
        String barrio = data[10];
        String ciudad = data[11];
        String edificio = data[12];
        String apto = data[13];
        Direccion dir = new Direccion(calle, nomenclatura, barrio, ciudad, edificio, apto);
        Usuario usuario = new Usuario(nombre, id, fecha, ciudadNacimiento, tel, email, dir);
        return usuario;
    }

    public Usuario create() {
        Usuario user = new Usuario();
        Fecha fecha = new Fecha();
        Direccion dir = new Direccion();
        user.setnombre(JOptionPane.showInputDialog(null, "Nombre","Registro Usuario",1));
        user.setId(Long.parseLong(JOptionPane.showInputDialog(null, "ID","Registro Usuario",1)));
        user.setCiudad_nacimiento(JOptionPane.showInputDialog(null, "Ciudad de Nacimiento","Registro Usuario",1));
        user.setTel(Long.parseLong(JOptionPane.showInputDialog(null, "Telefono","Registro Usuario",1)));

        fecha.setDia(Short.parseShort(JOptionPane.showInputDialog(null, "Fecha:\nDia","Registro Usuario",1)));
        fecha.setMes(Short.parseShort(JOptionPane.showInputDialog(null, "Fecha:\nMes","Registro Usuario",1)));
        fecha.setA(Short.parseShort(JOptionPane.showInputDialog(null, "Fecha:\nAño","Registro Usuario",1)));
        user.setFecha(fecha);

        user.setEmail(JOptionPane.showInputDialog(null, "Email","Registro Usuario",1));

        dir.setCalle(JOptionPane.showInputDialog(null, "Dirección:\nCalle","Registro Usuario",1));
        dir.setNomenclatura(JOptionPane.showInputDialog(null, "Dirección:\nNomenclatura","Registro Usuario",1));
        dir.setBarrio(JOptionPane.showInputDialog(null, "Dirección:\nBarrio","Registro Usuario",1));
        dir.setCiudad(JOptionPane.showInputDialog(null, "Dirección:\nCiudad","Registro Usuario",1));
        dir.setEdificio(JOptionPane.showInputDialog(null, "Dirección:\nEdificio","Registro Usuario",1));
        dir.setApto(JOptionPane.showInputDialog(null, "Dirección:\nApartamento","Registro Usuario",1));
        user.setDir(dir);

        // credenciales

        user.setContrasena(JOptionPane.showInputDialog(null, "Digite la Contraseña del Usuario"));
        user.setTipoUsuario("empleado");

        return user;
    }
}
