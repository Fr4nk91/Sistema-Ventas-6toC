/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import alertas.principal.AWTUtilities;
import alertas.principal.ErrorAlert;
import alertas.principal.SuccessAlert;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import clientes.FormClientes;
import clientes.Cliente;
import clientes.ClienteDAO;


public class ModalClienteM extends javax.swing.JDialog {

    Timer timer = null;
    TimerTask task;
    int i = 32;

    public ModalClienteM(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        AWTUtilities.setOpaque(this, false);
        this.id.setVisible(false);
        Ubicar(0);
        this.nombre.requestFocus();
    }

    private void limpiarCampos() {

        this.nombre.requestFocus();

        this.nombre.setText("");
        this.apellido.setText("");
        this.direccion.setText("");
        this.telefono.setText("");
        this.email.setText("");
        this.documento.setText("");
        ClienteDAO.listar("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        jPanel2 = new javax.swing.JPanel();
        cerrar = new principal.MaterialButton();
        titulo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        nombre = new app.bolivia.swing.JCTextField();
        apellido = new app.bolivia.swing.JCTextField();
        jLabel3 = new javax.swing.JLabel();
        telefono = new app.bolivia.swing.JCTextField();
        jLabel6 = new javax.swing.JLabel();
        email = new app.bolivia.swing.JCTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        direccion = new app.bolivia.swing.JCTextField();
        jLabel8 = new javax.swing.JLabel();
        documento = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        limpiar = new principal.MaterialButton();
        registrar = new principal.MaterialButton();
        id = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alertas/img/fondo.png"))); // NOI18N
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(58, 159, 171));

        cerrar.setBackground(new java.awt.Color(255, 255, 255));
        cerrar.setForeground(new java.awt.Color(58, 159, 171));
        cerrar.setText("X");
        cerrar.setToolTipText("<html> <head> <style> #contenedor{background:white;color:black; padding-left:10px;padding-right:10px;margin:0; padding-top:5px;padding-bottom:5px;} </style> </head> <body> <h4 id=\"contenedor\">Cerrar</h4> </body> </html>");
        cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cerrar.setFont(new java.awt.Font("Roboto Medium", 1, 20)); // NOI18N
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("TITULO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 10, 458, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        jPanel4.setBorder(dropShadowBorder1);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombre.setBorder(null);
        nombre.setForeground(new java.awt.Color(58, 159, 171));
        nombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nombre.setPlaceholder("NOMBRE");
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
        });
        jPanel4.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 240, 30));

        apellido.setBorder(null);
        apellido.setForeground(new java.awt.Color(58, 159, 171));
        apellido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        apellido.setPlaceholder("APELLIDO");
        apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellidoKeyTyped(evt);
            }
        });
        jPanel4.add(apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 240, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/trabajadores/campo.png"))); // NOI18N
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        telefono.setBorder(null);
        telefono.setForeground(new java.awt.Color(58, 159, 171));
        telefono.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        telefono.setPlaceholder("TELÉFONO");
        telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefonoKeyTyped(evt);
            }
        });
        jPanel4.add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 240, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/trabajadores/campo.png"))); // NOI18N
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        email.setEditable(true);
        email.setBorder(null);
        email.setForeground(new java.awt.Color(58, 159, 171));
        email.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        email.setPlaceholder("EMAIL");
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailKeyTyped(evt);
            }
        });
        jPanel4.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 240, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/trabajadores/campo.png"))); // NOI18N
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/trabajadores/campo.png"))); // NOI18N
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        direccion.setBorder(null);
        direccion.setForeground(new java.awt.Color(58, 159, 171));
        direccion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        direccion.setPlaceholder("DIRECCIÓN");
        direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                direccionKeyTyped(evt);
            }
        });
        jPanel4.add(direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 240, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/trabajadores/campo.png"))); // NOI18N
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, -1, -1));

        documento.setBorder(null);
        documento.setForeground(new java.awt.Color(58, 159, 171));
        documento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        documento.setPlaceholder("DOCUMENTO");
        documento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                documentoKeyTyped(evt);
            }
        });
        jPanel4.add(documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 240, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/trabajadores/campo.png"))); // NOI18N
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        panel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 420, 500));

        jPanel3.setBackground(new java.awt.Color(58, 159, 171));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        limpiar.setBackground(new java.awt.Color(255, 255, 255));
        limpiar.setForeground(new java.awt.Color(58, 159, 171));
        limpiar.setText("LIMPIAR CAMPOS");
        limpiar.setToolTipText("<html> <head> <style> #contenedor{background:#3A9FAB;color:white; padding-left:10px;padding-right:10px;margin:0; padding-top:5px;padding-bottom:5px;} </style> </head> <body> <h4 id=\"contenedor\">Limpiar campos</h4> </body> </html>");
        limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        limpiar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });
        jPanel3.add(limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 160, 50));

        registrar.setBackground(new java.awt.Color(255, 255, 255));
        registrar.setForeground(new java.awt.Color(58, 159, 171));
        registrar.setText("REGISTRAR");
        registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        registrar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });
        registrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                registrarKeyTyped(evt);
            }
        });
        jPanel3.add(registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 170, 50));

        id.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        id.setText("id");
        jPanel3.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 30, -1));

        panel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 459, 200));

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 476, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        task = new TimerTask() {
            @Override
            public void run() {
                if (i == 0) {
                    Cerrar();
                } else {
                    Ubicar(i);
                    i -= 32;
                    Trasparencia((float) i / 352);
                }
            }
        };
        timer = new Timer();
        timer.schedule(task, 0, 2);
    }//GEN-LAST:event_cerrarActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_limpiarActionPerformed

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
        char letras = evt.getKeyChar();
        if ((letras < 'a' || letras > 'z') && (letras < 'A' | letras > 'Z')) {
            if ((letras != 'ñ') && (letras != 'Ñ') && (letras != 'á') && (letras != 'Á') && (letras != 'é') && (letras != 'É') && (letras != 'í')
                    && (letras != 'Í') && (letras != 'ó') && (letras != 'Ó') && (letras != 'ú') && (letras != 'Ú') && (letras != ' ')) {
                evt.consume();
            }
        }
        if (Character.isLowerCase(letras)) {
            String cad = ("" + letras).toUpperCase();
            letras = cad.charAt(0);
            evt.setKeyChar(letras);
        }
    }//GEN-LAST:event_nombreKeyTyped

    private void apellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidoKeyTyped
        char letras = evt.getKeyChar();
        if ((letras < 'a' || letras > 'z') && (letras < 'A' | letras > 'Z')) {
            if ((letras != 'ñ') && (letras != 'Ñ') && (letras != 'á') && (letras != 'Á') && (letras != 'é') && (letras != 'É') && (letras != 'í')
                    && (letras != 'Í') && (letras != 'ó') && (letras != 'Ó') && (letras != 'ú') && (letras != 'Ú') && (letras != ' ')) {
                evt.consume();
            }
        }
        if (Character.isLowerCase(letras)) {
            String cad = ("" + letras).toUpperCase();
            letras = cad.charAt(0);
            evt.setKeyChar(letras);
        }
    }//GEN-LAST:event_apellidoKeyTyped

    private void telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoKeyTyped
        char num = evt.getKeyChar();
        if ((num < '0' || num > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_telefonoKeyTyped

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        if (this.nombre.getText().equals("") 
                || this.apellido.getText().equals("")
                || this.direccion.getText().equals("")
                || this.email.getText().equals("")
                || this.documento.getText().equals("")
                || this.telefono.getText().equals("")) {

            ErrorAlert er = new ErrorAlert(new JFrame(), true);
            er.titulo.setText("ADVERTENCIA");
            er.msj.setText("FALTAN CAMPOS DE LLENAR");
            er.msj1.setText("");
            er.setVisible(true);

        } else if (this.documento.getText().length() != 8 || !this.documento.getText().matches("\\d{8}")) {
        ErrorAlert er = new ErrorAlert(new JFrame(), true);
        er.titulo.setText("ADVERTENCIA");
        er.msj.setText("EL DOCUMENTO DEBE TENER 8 DIGITOS");
        er.msj1.setText("");
        er.setVisible(true);
        
        } else{
            
            int idCliente = getIdCliente();
            if (!ClienteDAO.esDocumentoUnico(this.documento.getText(),idCliente)) {
                ErrorAlert er = new ErrorAlert(new JFrame(), true);
                er.titulo.setText("ADVERTENCIA");
                er.msj.setText("EL DOCUMENTO YA EXISTE");
                er.msj1.setText("");
                er.setVisible(true);
            
        } else {

            if (this.registrar.getText().equals("GUARDAR")) {

                Cliente s = new Cliente();

                s.setNombre(this.nombre.getText());
                s.setApellido(this.apellido.getText());
                s.setDocumento(this.documento.getText());
                s.setTelefono(this.telefono.getText());
                s.setDireccion(this.direccion.getText());
                s.setEmail(this.email.getText());
                s.setId(Integer.parseInt(this.id.getText()));

                int opcion = ClienteDAO.actualizar(s);
                if (opcion != 0) {
                    String fila = this.id.getText();
                    ClienteDAO.listar("");
                    FormClientes.seleccionaFila(fila);
                    SuccessAlert sa = new SuccessAlert(new JFrame(), true);
                    sa.titulo.setText("¡REGISTRO EXITOSO!");
                    sa.msj.setText("SE HAN GUARDADO LOS CAMBIOS");
                    sa.msj1.setText("");
                    sa.setVisible(true);
                }

            } else {

                Cliente s = new Cliente();

                s.setNombre(this.nombre.getText());
                s.setApellido(this.apellido.getText());
                s.setDocumento(this.documento.getText());
                s.setTelefono(this.telefono.getText());
                s.setDireccion(this.direccion.getText());
                s.setEmail(this.email.getText());

                int opcion = ClienteDAO.registrar(s);
                if (opcion != 0) {
                    String fila = String.valueOf(ClienteDAO.extraerID());
                    limpiarCampos();
                    FormClientes.seleccionaFila(fila);
                    SuccessAlert sa = new SuccessAlert(new JFrame(), true);
                    sa.titulo.setText("¡REGISTRO EXITOSO!");
                    sa.msj.setText("SE HA REGISTRADO UN");
                    sa.msj1.setText("NUEVO CLIENTE");
                    sa.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_registrarActionPerformed
    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        task = new TimerTask() {
            @Override
            public void run() {
                if (i == 352) {
                    timer.cancel();
                } else {
                    Ubicar(i);
                    i += 32;
                    Trasparencia((float) i / 352);
                }
            }
        };
        timer = new Timer();
        timer.schedule(task, 0, 2);
    }//GEN-LAST:event_formWindowOpened

    private void registrarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_registrarKeyTyped
        if ((evt.getKeyChar() == KeyEvent.VK_ENTER)) {
            if (this.nombre.getText().equals("") || this.apellido.getText().equals("")
                    || this.documento.getText().equals("") || this.telefono.getText().equals("")) {

                ErrorAlert er = new ErrorAlert(new JFrame(), true);
                er.titulo.setText("ADVERTENCIA");
                er.msj.setText("FALTAN CAMPOS DE LLENAR");
                er.msj1.setText("");
                er.setVisible(true);

        } else if (this.documento.getText().length() != 8 || !this.documento.getText().matches("\\d{8}")) {
        ErrorAlert er = new ErrorAlert(new JFrame(), true);
        er.titulo.setText("ADVERTENCIA");
        er.msj.setText("EL DOCUMENTO DEBE TENER 8 DIGITOS");
        er.msj1.setText("");
        er.setVisible(true);
        
        } else{
            int idCliente = getIdCliente();
            if (!ClienteDAO.esDocumentoUnico(this.documento.getText(), idCliente)) {
        ErrorAlert er = new ErrorAlert(new JFrame(), true);
        er.titulo.setText("ADVERTENCIA");
        er.msj.setText("EL DOCUMENTO YA EXISTE");
        er.msj1.setText("");
        er.setVisible(true);

        
            
            } else {

                if (this.registrar.getText().equals("GUARDAR")) {

                    Cliente s = new Cliente();

                    s.setNombre(this.nombre.getText());
                    s.setApellido(this.apellido.getText());
                    s.setTelefono(this.telefono.getText());
                    s.setDocumento(this.telefono.getText());
                    s.setDireccion(this.direccion.getText());
                    s.setEmail(this.email.getText());


                    int opcion = ClienteDAO.actualizar(s);
                    if (opcion != 0) {
                        String fila = this.id.getText();
                        ClienteDAO.listar("");
                        FormClientes.seleccionaFila(fila);
                        SuccessAlert sa = new SuccessAlert(new JFrame(), true);
                        sa.titulo.setText("¡REGISTRO EXITOSO!");
                        sa.msj.setText("SE HAN GUARDADO LOS CAMBIOS");
                        sa.msj1.setText("");
                        sa.setVisible(true);
                    }

                } else {

                    Cliente s = new Cliente();

                    s.setNombre(this.nombre.getText());
                    s.setApellido(this.apellido.getText());
                    s.setDocumento(this.telefono.getText());
                    s.setTelefono(this.telefono.getText());
                    s.setDireccion(this.direccion.getText());
                    s.setEmail(this.email.getText());
                    int opcion = ClienteDAO.registrar(s);
                    if (opcion != 0) {
                        String fila = String.valueOf(ClienteDAO.extraerID());
                        limpiarCampos();
                        FormClientes.seleccionaFila(fila);
                        SuccessAlert sa = new SuccessAlert(new JFrame(), true);
                        sa.titulo.setText("¡REGISTRO EXITOSO!");
                        sa.msj.setText("SE HA REGISTRADO UN");
                        sa.msj1.setText("NUEVO CLIENTE");
                        sa.setVisible(true);
                    }
                }
            }
        }
    }//GEN-LAST:event_registrarKeyTyped
    }
    private void emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyTyped

    }//GEN-LAST:event_emailKeyTyped

    private void direccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direccionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_direccionKeyTyped

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void documentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_documentoKeyTyped
        char c = evt.getKeyChar();
        // Verificar si el carácter no es un dígito
        if (!Character.isDigit(c)) {
            evt.consume(); // Ignorar el carácter no válido
        }

        // Obtener el texto actual del campo
        String texto = ((javax.swing.JTextField) evt.getSource()).getText();

        // Verificar si el texto actual más el nuevo carácter superan los 8 dígitos
        if (texto.length() >= 8) {
            evt.consume(); // Ignorar el carácter adicional si el límite se ha alcanzado
        }
    }//GEN-LAST:event_documentoKeyTyped

    private int getIdCliente() {
        
        try{
        return Integer.parseInt(this.id.getText());
        }catch(NumberFormatException e){
            return 0;
        }  
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModalClienteM.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModalClienteM.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModalClienteM.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModalClienteM.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModalClienteM dialog = new ModalClienteM(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static app.bolivia.swing.JCTextField apellido;
    private principal.MaterialButton cerrar;
    public static app.bolivia.swing.JCTextField direccion;
    public static app.bolivia.swing.JCTextField documento;
    public static app.bolivia.swing.JCTextField email;
    public static javax.swing.JLabel id;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private principal.MaterialButton limpiar;
    public static app.bolivia.swing.JCTextField nombre;
    private org.edisoncor.gui.panel.Panel panel1;
    public static principal.MaterialButton registrar;
    public static app.bolivia.swing.JCTextField telefono;
    public static javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables

    private void Cerrar() {
        this.dispose();
        timer = null;
        task = null;
    }

    private void Trasparencia(float trasp) {
        AWTUtilities.setOpacity(this, trasp);
    }

    private void Ubicar(int y) {
        this.setLocation(603, y - 200);
    }
}