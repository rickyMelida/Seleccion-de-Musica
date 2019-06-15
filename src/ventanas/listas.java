package ventanas;
import com.sun.istack.internal.logging.Logger;
import java.sql.*;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class listas extends javax.swing.JFrame {

    
    public listas() {
        initComponents();
        mostrarCanciones("", "");
    }
    
    public static boolean esNumero(String cadena) {
        boolean resultado;
        
        try{
            Integer.parseInt(cadena);
            resultado = true;
        }catch(NumberFormatException Exception) {
            resultado = false;
        }
        
        return resultado;
    }
    
    public void mostrarCanciones(String columna, String nombre) {
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("N°");
        tabla.addColumn("Artista");
        tabla.addColumn("Titulo");
        tabla.addColumn("Estilo");
        tabla.addColumn("Duración");
        tabla_datos.setModel(tabla);
        
        String sql = "";
        
        if(nombre == "" || columna == "") {
            sql = "SELECT * FROM musicas";
        }else {
            sql = "SELECT * FROM musicas WHERE " + columna + " = '" + nombre + "';" ; 
        }
        
        String [] datos = new String[6];
        
        try{
            Statement st = db.createStatement();
            ResultSet res = st.executeQuery(sql);
            
            while(res.next()) {
                datos[0] = res.getString(1);
                datos[1] = res.getString(2);
                datos[2] = res.getString(3);
                datos[3] = res.getString(4);
                datos[4] = res.getString(5) + ":" + res.getString(6);
                
                tabla.addRow(datos);
            }
            tabla_datos.setModel(tabla);
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en " + ex);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modificar = new javax.swing.JDialog();
        duracion_modificado = new javax.swing.JTextField();
        btn_grabar = new javax.swing.JButton();
        btn_regresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        artista_modificado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        titulo_modificado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        estilo_modificado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        panel_principal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_datos = new javax.swing.JTable();
        btn_volver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        seleccionador = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();

        duracion_modificado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duracion_modificadoActionPerformed(evt);
            }
        });

        btn_grabar.setText("Grabar");
        btn_grabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_grabarActionPerformed(evt);
            }
        });

        btn_regresar.setText("Cancelar");
        btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel2.setText("Modificar Canciones");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Artista:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Titulo:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Estilo:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Duración:");

        javax.swing.GroupLayout modificarLayout = new javax.swing.GroupLayout(modificar.getContentPane());
        modificar.getContentPane().setLayout(modificarLayout);
        modificarLayout.setHorizontalGroup(
            modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modificarLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(modificarLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(artista_modificado, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(modificarLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(24, 24, 24)
                            .addComponent(titulo_modificado, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, modificarLayout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(estilo_modificado, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, modificarLayout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(duracion_modificado, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, modificarLayout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(btn_grabar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_regresar))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        modificarLayout.setVerticalGroup(
            modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modificarLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addGroup(modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(artista_modificado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(titulo_modificado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(estilo_modificado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(duracion_modificado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_grabar)
                    .addComponent(btn_regresar))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 385));
        setResizable(false);

        panel_principal.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 102, 102)));
        panel_principal.setPreferredSize(new java.awt.Dimension(980, 687));

        tabla_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_datosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_datos);

        btn_volver.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_volver.setText("Volver");
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel1.setText("Canciones de la Base de Datos");

        btn_modificar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_modificar.setText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_eliminar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        seleccionador.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        seleccionador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "artista", "titulo", "estilo" }));
        seleccionador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionadorActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel7.setText("Buscar por:");

        btn_buscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_principalLayout = new javax.swing.GroupLayout(panel_principal);
        panel_principal.setLayout(panel_principalLayout);
        panel_principalLayout.setHorizontalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panel_principalLayout.createSequentialGroup()
                            .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(117, 117, 117)
                            .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(118, 118, 118)
                            .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1))
                    .addGroup(panel_principalLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seleccionador, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_buscar)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        panel_principalLayout.setVerticalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(seleccionador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.PREFERRED_SIZE, 804, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        principal princ = new principal();
        this.setVisible(false);
        princ.setVisible(true);
        princ.setLocationRelativeTo(null);
        princ.setTitle("Seleccion Musical");
    }//GEN-LAST:event_btn_volverActionPerformed

    private void tabla_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_datosMouseClicked
       
    }//GEN-LAST:event_tabla_datosMouseClicked

    int minutos;
    int segundos;
    String id;
    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        modificar.setSize(370,340);
        modificar.setVisible(true);
        modificar.setLocationRelativeTo(null);
        modificar.setTitle("Modificar Canción");
        
        int fila = tabla_datos.getSelectedRow();
        String[] datos = new String[5];
        
        for (int i = 0; i < 5; i++) {
            //Evalua los datos que contiene la fila seleccionada
            datos[i] = (String)tabla_datos.getValueAt(fila, i);
        }
        
        artista_modificado.setText(datos[1]);
        titulo_modificado.setText(datos[2]);
        estilo_modificado.setText(datos[3]);
        duracion_modificado.setText(datos[4]);
        
        id = datos[0];
        
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        int fila = tabla_datos.getSelectedRow();
        String cod = tabla_datos.getValueAt(fila, 0).toString();
        
        try {
            PreparedStatement rm = db.prepareStatement("DELETE FROM musicas WHERE id_musica='" + cod + "'");
            rm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se elimino la musica de la base de datos");
            mostrarCanciones("", "");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la musica, " + ex);
            
            //java.util.logging.Logger.getLogger(listas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void duracion_modificadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duracion_modificadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_duracion_modificadoActionPerformed

    private void btn_grabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_grabarActionPerformed
        String[] dura = new String[5];
        
        String duracion = duracion_modificado.getText();
        
        for (int i = 0; i < duracion.length(); i++) {
            dura[i] = String.valueOf(duracion.charAt(i));
        }
        
        /*Si el minuto de duracion es menor a 10*/
        if(dura[1].equals(":")){
            minutos = Integer.parseInt("0" + dura[0]);
            if(duracion.length() >= 4) {
                segundos = Integer.parseInt(dura[2] + dura[3]);
            }else {
                segundos = Integer.parseInt("0" + dura[2]);
            }
        }
        
        if(dura[2].equals(":")) {
            minutos = Integer.parseInt(dura[0] + dura[1]);
            if(duracion.length() >= 5) {
                segundos = Integer.parseInt(dura[3] + dura[4]);
            }else {
                segundos = Integer.parseInt("0" + dura[3]);
            }
        }
        
        try {
            PreparedStatement pst = db.prepareStatement("UPDATE musicas SET artista= '" + artista_modificado.getText() + "',titulo='" + titulo_modificado.getText() + "',estilo='" + estilo_modificado.getText() + "',minutos='" + minutos + "',segundos='" + segundos + "' WHERE id_musica='" + id + "'");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se modificó la cancion correctamente");
            mostrarCanciones("", "");
            modificar.dispose();
            
        } catch (SQLException ex) {
            //java.util.logging.Logger.getLogger(listas.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al modificar la canción, " + ex);
        }
    }//GEN-LAST:event_btn_grabarActionPerformed

    private void btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresarActionPerformed
        modificar.dispose();
    }//GEN-LAST:event_btn_regresarActionPerformed

    private void seleccionadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionadorActionPerformed
       
    }//GEN-LAST:event_seleccionadorActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
      
        if(nombre.getText() == "" || nombre.getText() == "Todos"){
            mostrarCanciones("", "");
        }else {
            mostrarCanciones(seleccionador.getSelectedItem().toString(), nombre.getText());
        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField artista_modificado;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_grabar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JTextField duracion_modificado;
    private javax.swing.JTextField estilo_modificado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JDialog modificar;
    private javax.swing.JTextField nombre;
    private javax.swing.JPanel panel_principal;
    private javax.swing.JComboBox<String> seleccionador;
    private javax.swing.JTable tabla_datos;
    private javax.swing.JTextField titulo_modificado;
    // End of variables declaration//GEN-END:variables

    conectar bd = new conectar();
    Connection db = bd.conexion();

}
