package clases;

import java.sql.*;
import javax.swing.JOptionPane;
import ventanas.conectar;

/**
 *
 * @author ricky
 */
public class resultado {

    public resultado() {
    
    }
    
    public void datos(String estilo) {
        try {
            String sql = "SELECT * FROM musicas WHERE estilo = '" + estilo + "'";
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error al cargar la musica");
        }
    }
    
    conectar bd = new conectar();
    Connection db = bd.conexion();
    
}
