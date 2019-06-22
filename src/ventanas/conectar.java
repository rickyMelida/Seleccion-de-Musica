package ventanas;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conectar {
    Connection conectar = null;
    
    public Connection conexion(){
        String url = "jdbc:mysql://db4free.net:3306/radio_panambi";
        String usuario = "ricky_melida";
        String pass = "5181789781Ri-";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost/radio", "root", "");
            System.out.println("Conexion establecida");
        }catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Mensaje", JOptionPane.PLAIN_MESSAGE);
            System.out.println("No se pudo conectar con la base de datos");
        }
        return conectar;
    }
}
