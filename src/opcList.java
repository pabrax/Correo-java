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
    
    public DoubleNode Buscar(Long id) {
        DoubleNode actual = listaEmpleados.getLista().first();
        while (actual != null) {
            Usuario u = ((Empleado) actual.getDato()).getUser();
            if (u.getId() == id) {
                return actual;
            }
            actual = actual.getNext();
        }
        return null;
    }
    // public DoubleNode Buscar(Long id) {
    //     DoubleNode actual = listaEmpleados.getLista().first();
    //     while (actual != null) {
    //         Empleado emp = (Empleado) actual.getDato();
    //         if (emp.getUser().getId() == id) {
    //             return actual;
    //         }
    //         actual = actual.getNext();
    //     }
    //     return null;
    // }

    public void toFile() {
        try {
            File file = new File((System.getProperty("user.dir") + "/src/Files/Empleados.txt"));

            PrintWriter writer = new PrintWriter(new FileWriter(file, true));
            DoubleNode actual = listaEmpleados.getLista().first();
            while (actual != null) {
                Usuario u = ((Empleado) actual.getDato()).getUser();
                writer.println(u.toString());
                actual = actual.getNext();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error al guardar los usuarios");
        }

        try {
            File file = new File((System.getProperty("user.dir") + "/src/Files/Password.txt"));

            PrintWriter writer = new PrintWriter(new FileWriter(file, true));
            DoubleNode actual = listaEmpleados.getLista().first();
            while (actual != null) {
                Usuario u = ((Empleado) actual.getDato()).getUser();
                String credenciales = (u.getId() + " " + u.getContrasena() + " " + u.getTipoUsuario());
                writer.println(credenciales);
                actual = actual.getNext();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error al guardar las credenciales");
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
                System.out.println("Se han importado las credenciales desde el archivo");
            } catch (IOException e) {
                System.out.println("Error al tratar de importar la informacion");
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
            System.out.println("Se han importado los usuarios desde el archivo");

        } catch (IOException e) {
            System.out.println("Error al tratar de importar la informacion");
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
        user.setnombre(JOptionPane.showInputDialog(null, "Nombre"));
        user.setId(Long.parseLong(JOptionPane.showInputDialog(null, "ID")));
        user.setCiudad_nacimiento(JOptionPane.showInputDialog(null, "ciudad de nacimiento"));
        user.setTel(Long.parseLong(JOptionPane.showInputDialog(null, "Telefono")));

        fecha.setDia(Short.parseShort(JOptionPane.showInputDialog(null, "Fecha:\nDia")));
        fecha.setMes(Short.parseShort(JOptionPane.showInputDialog(null, "Fecha:\nMes")));
        fecha.setA(Short.parseShort(JOptionPane.showInputDialog(null, "Fecha:\nAño")));
        user.setFecha(fecha);

        user.setEmail(JOptionPane.showInputDialog(null, "Email"));

        dir.setCalle(JOptionPane.showInputDialog(null, "Direccion:\nCalle"));
        dir.setNomenclatura(JOptionPane.showInputDialog(null, "Direccion:\nNomenclatura"));
        dir.setBarrio(JOptionPane.showInputDialog(null, "Direccion:\nBarrio"));
        dir.setCiudad(JOptionPane.showInputDialog(null, "Direccion:\nCiudad"));
        dir.setEdificio(JOptionPane.showInputDialog(null, "Direccion:\nEdificio"));
        dir.setApto(JOptionPane.showInputDialog(null, "Direccion:\nApartamento"));
        user.setDir(dir);

        // credenciales

        user.setContrasena(JOptionPane.showInputDialog(null, "digite la contraseña del usuario"));
        user.setTipoUsuario("empleado");

        return user;
    }
}
