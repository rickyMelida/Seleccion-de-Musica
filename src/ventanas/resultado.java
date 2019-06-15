package ventanas;
import clases.canciones;
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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_quitar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(207, 207, 207)
                            .addComponent(btn_listo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_quitar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_listo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        
        String [] datos ;
        String estilo = "Lento", estilo_2 = "Romantico";
       
        int tiempo_total = 1430;/*Esto correspomderia a 23hs 50min */
        
        int sum_seg = 0, sum_min = 0, min = 0, total_min = 0;

        
        try{
            canciones can = new canciones();
            String tiempo;
            String segundos = "", minutos = "";
            String art_actual = "", art_ant = "", art_ant2 = "";
            int cont = 0, fila = 0;
            
            
            while(total_min <= tiempo_total) {
                datos = can.madrugada(estilo, estilo_2);
                
                art_ant2 = art_ant;
                art_ant = art_actual;
                art_actual = datos[1];
                
                cont = total_min;
                tabla.addRow(datos);
                tiempo = datos[4];//duracion de la musica seleccionada
                
                
/*------------------------------------------------------------------------------------------------------------*/                
                /*-----------------Definimos todos los posibles casos de los horaios de cancioones
                para poder desmenuzar los minutos y segundos, ya que estan llegano en formato string----*/
                
                if(tiempo.length() == 5 && String.valueOf(tiempo.charAt(2)).equals(":")){
                    segundos = String.valueOf(tiempo.charAt(3)) + String.valueOf(tiempo.charAt(4));
                    sum_seg = Integer.parseInt(segundos) + sum_seg;//Sumamos consecutivamente los segundos

                    minutos = String.valueOf(tiempo.charAt(0)) + String.valueOf(tiempo.charAt(1));
                    sum_min = Integer.parseInt(minutos) + sum_min;//Sumamos consecutivamente los minutos
                }

                if(tiempo.length() == 4 && String.valueOf(tiempo.charAt(1)).equals(":")) {
                    segundos = String.valueOf(tiempo.charAt(2)) + String.valueOf(tiempo.charAt(3));
                    sum_seg = Integer.parseInt(segundos) + sum_seg;

                    minutos = String.valueOf(tiempo.charAt(0));
                    sum_min = Integer.parseInt(minutos) + sum_min;
                }

                if(tiempo.length() == 3 && String.valueOf(tiempo.charAt(1)).equals(":")) {
                    segundos = String.valueOf(tiempo.charAt(2));
                    sum_seg = Integer.parseInt(segundos) + sum_seg;

                    minutos = String.valueOf(tiempo.charAt(0));
                    sum_min = Integer.parseInt(minutos) + sum_min;
                }

                if(tiempo.length() == 4 && String.valueOf(tiempo.charAt(2)).equals(":")) {
                    segundos = String.valueOf(tiempo.charAt(3));
                    sum_seg = Integer.parseInt(segundos) + sum_seg;

                    minutos = String.valueOf(tiempo.charAt(0) + String.valueOf(tiempo.charAt(1)));
                    sum_min = Integer.parseInt(minutos) + sum_min;
                }

/*----------------------------------------------------------------------------------------------------------*/
                
                /*Si la cantidad de segundos es igual o supera 60
                sumamos un minuto y restamos la suma de segundos entre 60*/
                if(sum_seg >= 60){
                    min ++ ; 
                    sum_seg -= 60;                    
                }


                /*Sumamos el total de minutos*/
                total_min = sum_min + min;
                

/*-------------Condiciones para selecionar los estilos de musica de acuerdo al horario-------------------------*/
                if(total_min >= 240 && total_min < 360 ) {
                    estilo = "Polka";
                    estilo_2 = "";
                }    
                if(total_min >= 360 && total_min < 720){
                    estilo="Movido";
                    estilo_2 = "Intermedio"; 
                }        

                if(total_min >= 720 && total_min < 780){
                    estilo = "Predica";
                    estilo_2 = "Lento";
                }           

                if(total_min >= 780 && total_min < 900){
                    estilo = "Lento";
                    estilo_2 = "Intermedio";
                }       

                if(total_min >= 900 && total_min < 1200) {
                    estilo = "Movido";
                    estilo_2 = "Intermedio";
                }     
                if(total_min >= 1200) {
                    estilo = "Predica";
                    estilo_2 = "Movido";
                }
               
                
/*--------------Condicional para evitar que se repitan tres veces las musicas--------------------------------*/
                if(cont < 180 && art_actual.equals(art_ant2)) {
                    int seg = Integer.parseInt(segundos);
                    int minu = Integer.parseInt(minutos);
                    System.out.println("Se detecto musica repetida, de duracion " + minutos + ":" + segundos);
                    System.out.println(" a los " + cont + " minutos, la fila es " + fila);
                    
                    total_min -= minu;
                    
                    if(sum_seg < seg) {
                        total_min -= 1;
                        seg += 60;
                    }
                    sum_seg -= seg;
                    //tabla.removeRow(fila);
                    
                }
                
/*--------------Si se llega a los 180(minutos, correspondiente a las tres horas de condion para ---------------
  --------------que no se repita las musicas) el contador vuelve a cero--------------------------*/
                if(cont > 180){
                    cont = 0;
                }
                
/*---------------------------Sumamos uno mas la fila que se añade----------------------------------*/
                fila ++;
                
                          tabla_resultados.setModel(tabla);
  
            }
            
/*----------Agregamos la tabla(Model table) a la tabla del jframe----------------------------------*/            
            //tabla_resultados.setModel(tabla);
            System.out.println("El tiempo total es: " + total_min + ":" + sum_seg);
           
            
        }catch(Exception ex) {
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
