package ventanas;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class resultado extends javax.swing.JFrame {


    public resultado() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_resultados = new javax.swing.JTable();
        btn_listo = new javax.swing.JButton();
        btn_volver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tabla_resultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tabla_resultados);

        btn_listo.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        btn_listo.setText("Listo");
        btn_listo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listoActionPerformed(evt);
            }
        });

        btn_volver.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        btn_volver.setText("Volver");
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel1.setText("PlayList Aleatorio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btn_listo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_listo, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(btn_volver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    public void mostrarCanciones() {
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("N°");
        tabla.addColumn("Artista");
        tabla.addColumn("Titulo");
        tabla.addColumn("Estilo");
        tabla.addColumn("Duración");
        tabla_resultados.setModel(tabla);
        
        String sql = "SELECT * FROM musicas";
        String ale_sql = "SELECT * FROM musicas ORDER BY RAND() LIMIT 5";
        String [] datos = new String[6];
        
        
        int madrugada = 300;/* Tiempo total en minutos para el horario de la madrugada*/
        int tiempo_total = 1430;/*Esto correspomderia a 23hs 50min*/
        int sum_seg, min, total_min = 0;
        
        try{
            Statement st = db.createStatement();
            ResultSet res = st.executeQuery(sql);
            
            while(total_min <= tiempo_total){
                
            }
            
            /*Se repitr extrayendo todos los datos*/
            while(res.next()) {
                
                datos[0] = res.getString(1);
                datos[1] = res.getString(2);
                datos[2] = res.getString(3);
                datos[3] = res.getString(4);
                datos[4] = res.getString(5) + ":" + res.getString(6); /*Se concatenan los minutos y segundos*/
                
                tabla.addRow(datos);
            }
            
            tabla_resultados.setModel(tabla);
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en " + ex);
        }
        
    }
    
    private void btn_listoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_listoActionPerformed

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        principal princ = new principal();
        princ.setVisible(true);
        princ.setLocationRelativeTo(null);
        princ.setTitle("Seleccion Musical");
        this.setVisible(false);
    }//GEN-LAST:event_btn_volverActionPerformed


    
    conectar bd = new conectar();
    Connection db = bd.conexion();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_listo;
    private javax.swing.JButton btn_volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla_resultados;
    // End of variables declaration//GEN-END:variables
}
