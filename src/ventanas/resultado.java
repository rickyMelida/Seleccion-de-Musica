package ventanas;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class resultado extends javax.swing.JFrame {


    public resultado() {
        initComponents();
        mostrarCanciones();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_resultados = new javax.swing.JTable();
        btn_listo = new javax.swing.JButton();
        btn_volver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_quitar = new javax.swing.JButton();

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

        btn_quitar.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        btn_quitar.setText("Quitar");
        btn_quitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitarActionPerformed(evt);
            }
        });

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
                            .addComponent(btn_quitar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(207, 207, 207)
                            .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_volver, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                        .addComponent(btn_quitar, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
   
    DefaultTableModel tabla = new DefaultTableModel();
        
    
    public void mostrarCanciones() {
        
        tabla.addColumn("N°");
        tabla.addColumn("Artista");
        tabla.addColumn("Titulo");
        tabla.addColumn("Estilo");
        tabla.addColumn("Duración");
        tabla_resultados.setModel(tabla);
        
        String [] datos = new String[6];
        String estilo = "Lento", estilo_2 = "Romantico";
        
        
        int temprano = 240;/* Tiempo total en minutos para el horario de la madrugada*/
        int mañana = 360;/* Tiempo total en minutos para el horario de la madrugada*/
        int tiempo_total = 1430;/*Esto correspomderia a 23hs 50min*/
        
        int sum_seg = 0, sum_min = 0, min = 0, total_min = 0;

        
        try{
            
            while(total_min <= tiempo_total) {
                String ale_sql = "SELECT * FROM musicas WHERE estilo = '" + estilo + "' || estilo = '" + estilo_2 + "' ORDER BY RAND()";
            
                Statement st = db.createStatement();
                ResultSet res = st.executeQuery(ale_sql);
                
                
                switch(total_min){
                    case 240: {
                        estilo="Polka";
                    }
                    break;
                    
                    case 360: {
                        estilo="Movido";
                    }
                    break;
                    
                    case 720: {
                        estilo = "Lento";
                    }
                    break;
                    
                    case 780: {
                        estilo = "Lento";
                    }
                    break;
                    
                    case 900: {
                        estilo = "Movido";
                    }
                    break;
                    
                    case 1200: {
                        estilo = "Movido";
                    }
                    break;
                }
                
            
                /*Se repite extrayendo todos los datos*/
                while(res.next()) {
                
                    datos[0] = res.getString(1);
                    datos[1] = res.getString(2);
                    datos[2] = res.getString(3);
                    datos[3] = res.getString(4);
                    datos[4] = res.getString(5) + ":" + res.getString(6); /*Se concatenan los minutos y segundos*/
                
                    tabla.addRow(datos);
                
                    /*Sumamos consecutivamente los segundos*/
                    sum_seg = Integer.parseInt(res.getString(6)) + sum_seg; 
                
                    /*Si la cantidad de segundos es igual o supera 60
                    sumamos un minuto y restamos la suma de segundos entre 60*/
                    if(sum_seg >= 60){
                        min ++ ; 
                        sum_seg = sum_seg - 60;                    
                    }
                    /*Sumamos consecutivamente los minutos*/
                    sum_min = Integer.parseInt(res.getString(5)) + sum_min;
                
                    /*Sumamos el total de minutos*/
                    total_min = sum_min + min;
                }
            
                System.out.println("El tiempo total es: " + total_min + ":" + sum_seg);
                tabla_resultados.setModel(tabla); 
            }
            
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en " + ex);
        }
        
    }
    
    
    private void btn_listoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listoActionPerformed
        tabla.removeRow(0);
        
    }//GEN-LAST:event_btn_listoActionPerformed

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        principal princ = new principal();
        princ.setVisible(true);
        princ.setLocationRelativeTo(null);
        princ.setTitle("Seleccion Musical");
        this.setVisible(false);
    }//GEN-LAST:event_btn_volverActionPerformed

    private void btn_quitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarActionPerformed
        try {
            tabla.removeRow(tabla_resultados.getSelectedRow());
        }catch(Exception ex) {
            JOptionPane.showMessageDialog(null,"Seleccione una fila para quital de las lista");
        }
        
    }//GEN-LAST:event_btn_quitarActionPerformed


    
    conectar bd = new conectar();
    Connection db = bd.conexion();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_listo;
    private javax.swing.JButton btn_quitar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla_resultados;
    // End of variables declaration//GEN-END:variables
}
