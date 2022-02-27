package ec.com.comus.util;

/**
 * importando las librerias necesarias
 */
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ec.com.comus.form.WStoreImage;



/**
 *
 * @author yuriani
 * @author Francisco Aguilar
 * @author Maricarmen Santos
 * @author Ivan luis Jimenez
 */
public class design extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
   se crea un objeto para llamar al frame llamado imagen
     */
    imagen obj = new imagen();
	private String url;
	private WStoreImage wStoreImage;

    /**
     * constructor de la clase
     * @param wStoreImage 
     */
    public design(String url, WStoreImage wStoreImage) {
     	this.url = url;
     	this.wStoreImage = wStoreImage;
        setTitle("Menu principal");
        initComponents();
        filtro_manual.setEnabled(false);
        obj.cargaImag(url);
        obj.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        filtro = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        girar = new javax.swing.JButton();
        ac_filtro_manual = new javax.swing.JCheckBox();
        TAncho= new javax.swing.JSlider();
        filtro_manual = new javax.swing.JSlider();
        jPanel3 = new javax.swing.JPanel();
        RGB = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        Formatos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        Guardar_B = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        new javax.swing.JMenu();
        new javax.swing.JMenuItem();
        Guardar = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();

//        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 0, 51))); // NOI18N

        filtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno", "LookupOp", "Sharpen", "LowPass", "Detectar Bordes", "Negativo", "Espejo" }));
        filtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filtro, 0, 288, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Girar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 0, 51))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        girar.setText("90 Grados");
        girar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                girarActionPerformed(evt);
            }
        });

        ac_filtro_manual.setText("Girar Manualmente");
        ac_filtro_manual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ac_filtro_manualActionPerformed(evt);
            }
        });

        filtro_manual.setMajorTickSpacing(50);
        filtro_manual.setMaximum(360);
        filtro_manual.setPaintLabels(true);
        filtro_manual.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                filtro_manualStateChanged(evt);
            }
        });
        
        ac_filtro_manual.setVisible(false);
        filtro_manual.setVisible(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(filtro_manual, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(girar))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(ac_filtro_manual)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(girar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ac_filtro_manual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filtro_manual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RGB", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 0, 51))); // NOI18N

        RGB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno", "Escala de Grises", "Rojo", "Azul", "Amarillo", "Brillo" }));
        RGB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RGBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RGB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(RGB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Guardar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 0, 51))); // NOI18N

        Formatos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "bmp", "gif", "jpeg", "jpg", "png" }));
        Formatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FormatosActionPerformed(evt);
            }
        });

        jLabel1.setText("Formato:");

        Guardar_B.setText("Guardar");
        Guardar_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guardar_BActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
//                .addComponent(jLabel1)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(Formatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Guardar_B)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(Formatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(jLabel1)
                    .addComponent(Guardar_B))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recortar Imagen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 0, 51))); // NOI18N

        TAncho.setMaximum(0);
        TAncho.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                TAnchoStateChanged(evt);
            }
        });

        jButton2.setText("Guardar Recorte");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TAncho, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jButton2)
                .addGap(12, 12, 12)
                .addComponent(TAncho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mensaje.setBackground(new java.awt.Color(0, 0, 0));
        mensaje.setForeground(new java.awt.Color(204, 0, 51));

//        jMenu1.setText("Archivo");
//
//        jMenuItem1.setText("Abrir");
//        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jMenuItem1ActionPerformed(evt);
//            }
//        });
//        jMenu1.add(jMenuItem1);
//
//        Guardar.setText("Guardar");
//        Guardar.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                GuardarActionPerformed(evt);
//            }
//        });
//        jMenu1.add(Guardar);
//
//        jMenuBar1.add(jMenu1);

        jMenu3.setText("Zoom");

        jMenu4.setText("Zoom (-)");

        jMenuItem6.setText("25%");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuItem7.setText("50%");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuItem8.setText("75%");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuItem9.setText("99%");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenu3.add(jMenu4);

        jMenu5.setText("Zoom (+)");

        jMenuItem10.setText("25%");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem10);

        jMenuItem11.setText("50%");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem11);

        jMenuItem12.setText("75%");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem12);

        jMenuItem13.setText("99%");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem13);

        jMenu3.add(jMenu5);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent winEvt) {
            	dispose();
            	obj.dispose();
                try {
					finalize();
				} catch (Throwable e) {
					e.printStackTrace();
				}
            }
        });
        pack();
        
        
    }// </editor-fold>//GEN-END:initComponents


    private void filtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroActionPerformed
        if (obj.isVisible()) {
            //seleccion de los filtros del combobox
            if (filtro.getSelectedItem() == "Ninguno") {
                obj.r_efecto(0);
                obj.repaint();
                mos_msj("Imagen Original");
            }
            if (filtro.getSelectedItem() == "LookupOp") {
                obj.r_efecto(14);
                obj.repaint();
                mos_msj("Se aplicó filtro LookupOp");
            }
            if (filtro.getSelectedItem() == "Sharpen") {
                obj.r_efecto(13);
                obj.repaint();
                mos_msj("Se aplicó filtro Sharpen");
            }
            if (filtro.getSelectedItem() == "LowPass") {
                obj.r_efecto(12);
                obj.repaint();
                mos_msj("Se aplicó filtro LowPass");
            }
            if (filtro.getSelectedItem() == "Detectar Bordes") {
                obj.r_efecto(10);
                obj.repaint();
                mos_msj("Filtro de marcado de bordes");
            }
            if (filtro.getSelectedItem() == "Negativo") {
                obj.r_efecto(9);
                obj.repaint();
                mos_msj("Se aplicó filtro Negativo");
            }
            if (filtro.getSelectedItem() == "Espejo") {
                obj.r_efecto(7);
                obj.repaint();
                mos_msj("Se tranformo a espejo");
            }
        }
    }//GEN-LAST:event_filtroActionPerformed

    private void girarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_girarActionPerformed
        try {
            //llamamada del metodo rotar imagen
            obj.rotacionImagen(90);
            obj.actualiza_frame();
            obj.repaint();
            mos_msj("Se giró la imagen");
        } catch (Exception e) {
            System.out.println("");
        }
    }//GEN-LAST:event_girarActionPerformed

    private void ac_filtro_manualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ac_filtro_manualActionPerformed

        if (ac_filtro_manual.isSelected()) {
            filtro_manual.setEnabled(true);
            mos_msj("Giro manual ACTIVADO");
        } else {
            filtro_manual.setEnabled(false);
            mos_msj("Giro manual DESACTIVADO");
        }
    }//GEN-LAST:event_ac_filtro_manualActionPerformed

    private void filtro_manualStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_filtro_manualStateChanged
        //llamada del metodo grados para girar la imagen
        obj.Grados(filtro_manual.getValue());
        obj.r_efecto(4);
    }//GEN-LAST:event_filtro_manualStateChanged

    private void RGBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RGBActionPerformed
        //seleccion de los filtros del comboboxRGB
        if (RGB.getSelectedItem() == "Ninguno") {
            obj.r_efecto(0);
            obj.repaint();
            mos_msj("Imagen Original");
        }
        if (RGB.getSelectedItem() == "Escala de Grises") {
            obj.r_efecto(3);
            obj.repaint();
            mos_msj("Se aplicó escala de grises");
        }
        if (RGB.getSelectedItem() == "Azul") {
            obj.r_efecto(1);
            obj.repaint();
            mos_msj("Se aplicó filtro azul");
        }
        if (RGB.getSelectedItem() == "Rojo") {
            obj.r_efecto(6);
            obj.repaint();
            mos_msj("Se aplico filtro rojo");
        }
        if (RGB.getSelectedItem() == "Amarillo") {
            obj.r_efecto(5);
            obj.repaint();
            mos_msj("Se aplicó filtro amarillo");
        }
        if (RGB.getSelectedItem() == "Brillo") {
            obj.r_efecto(2);
            obj.repaint();
            mos_msj("Se aplicó brillo");
        }
    }//GEN-LAST:event_RGBActionPerformed

    private void FormatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FormatosActionPerformed
    }//GEN-LAST:event_FormatosActionPerformed


    private void Guardar_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guardar_BActionPerformed
        try {
            //llamada del metodo guardar
            guardar();
        } catch (IOException ex) {
            System.out.println("");
        }
    }//GEN-LAST:event_Guardar_BActionPerformed

    private void TAnchoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_TAnchoStateChanged
        //llamada del metodo recortar imagen
        try {

            obj.RecortarImagen();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_TAnchoStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //llamada del metodo guardar recorte
        obj.GuardarRecorte(new File(url));
        File compressedImageFile = new File(url+".prev");
    	wStoreImage.resizeImagen(obj.getBi(), compressedImageFile,50,50);
        obj.dispose();
    	dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        //metodo que llama al metodo tam para aplicar zoom al -%99
        obj.tam(0.75, 0.75);
        obj.r_efecto(11);

        obj.repaint();

    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        //metodo que llama al metodo tam para aplicar zoom al  -%50
        obj.tam(0.5, 0.5);
        obj.r_efecto(11);
        obj.repaint();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        //metodo que llama al metodo tam para aplicar zoom al -%25
        obj.tam(0.25, 0.25);
        obj.r_efecto(11);
        obj.repaint();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        //metodo que llama al metodo tam para aplicar zoom al -%10:
        obj.tam(0.1, 0.1);
        obj.r_efecto(11);
        obj.repaint();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        //metodo que llama al metodo tam para aplicar zoom al %25
        obj.tam(1.25, 1.25);
        obj.r_efecto(11);
        obj.repaint();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        //metodo que llama al metodo tam para aplicar zoom al %50
        obj.tam(1.5, 1.5);
        obj.r_efecto(11);
        obj.repaint();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        //metodo que llama al metodo tam para aplicar zoom al %75
        obj.tam(1.75, 1.75);
        obj.r_efecto(11);
        obj.repaint();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        //metodo que llama al metodo tam para aplicar zoom al %99
        obj.tam(1.9, 1.9);
        obj.r_efecto(11);

        obj.repaint();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    /**
     * metodo que guarda la imagen
     *
     * @throws IOException variable IOException
     */
    public void guardar() throws IOException {
//        try {
//
//            String formato = (String) Formatos.getSelectedItem();
//            File saveFile = new File("Imagen." + formato);
//            JFileChooser chooser = new JFileChooser();
//            chooser.setSelectedFile(saveFile);
//            int rFormato = chooser.showSaveDialog(Formatos);
//            if (rFormato == JFileChooser.APPROVE_OPTION) {
//                saveFile = chooser.getSelectedFile();
//                ImageIO.write(obj.getBi(), formato, saveFile);
//                mos_msj("Se guardó correctamente");
//            }
//        } catch (Exception e) {
//        }
    	try {
	    	File saveImagen = new File(url);
	    	ImageIO.write(obj.getBi(), "png", saveImagen);
	    	
	    	
	    	File compressedImageFile = new File(url+".prev");
	    	wStoreImage.resizeImagen(obj.getBi(), compressedImageFile,50,50);
	    	
	    	obj.dispose();
	    	dispose();
    	} catch (Exception e) { 
    		e.printStackTrace();
    	}
  	
    }

    
    public static void mos_msj(String Mensaje) {
        mensaje.setText(Mensaje);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(final String image, final WStoreImage wStoreImage){
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         * 
         * 
         */
    	
    	
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        
        new design(image,wStoreImage).setVisible(true);
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new design(image,wStoreImage).setVisible(true);
//
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox Formatos;
    private javax.swing.JMenuItem Guardar;
    private javax.swing.JButton Guardar_B;
    private javax.swing.JComboBox<String> RGB;
    public static  javax.swing.JSlider TAncho ;
    private javax.swing.JCheckBox ac_filtro_manual;
    private javax.swing.JComboBox<String> filtro;
    private javax.swing.JSlider filtro_manual;
    private javax.swing.JButton girar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    public static final javax.swing.JLabel mensaje = new javax.swing.JLabel();
    // End of variables declaration//GEN-END:variables

}
