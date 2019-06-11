package clases;

import java.sql.*;
import javax.swing.JOptionPane;
import ventanas.conectar;

/**
 *
 * @author ricky
 */
public class canciones {

    public canciones() {
    
    }
    
    public String[] madrugada(String estilo1, String estilo2) {
        String [] datos = new String[6];
        try {
            String sql = "SELECT * FROM musicas WHERE estilo = '" + estilo1 + "' || estilo = '" + estilo2 + "' ORDER BY RAND()";
            
            
            Statement st = db.createStatement();
            ResultSet res = st.executeQuery(sql);
            
            while(res.next()) {
                datos[0] = res.getString(1);
                datos[1] = res.getString(2);
                datos[2] = res.getString(3);
                datos[3] = res.getString(4);
                datos[4] = res.getString(5) + ":" + res.getString(6);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error al cargar la musica : " + ex);
        }
        
        return datos;
    }
    
    public void temprano() {
        
    }
    
    public void mañana() {
        
    }
    
    public void m_dia() {
        
    }
    
    public void siesta() {
        
    }
    
    public void tarde() {
        
    }
    public void noche() {
        
    }
    
    conectar bd = new conectar();
    Connection db = bd.conexion();
    
}
