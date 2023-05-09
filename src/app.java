import javax.swing.JOptionPane;

public class app {
    public static void main(String[] args) {
        //  aqui va un import
        // empieza el login y continua el programa principal
        Empleado e = new Empleado();
        if (e.user.getId()== null) {// ? corregir linea; agregarel retorno de un metodo que lea el archivo de passwords.txt
            e = new Administrador();
            
        }
    }

}
