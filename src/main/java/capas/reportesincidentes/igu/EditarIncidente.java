package capas.reportesincidentes.igu;

import capas.reportesincidentes.logica.Cliente;
import capas.reportesincidentes.logica.Controladora;
import capas.reportesincidentes.logica.Incidente;
import capas.reportesincidentes.logica.Servicio;
import capas.reportesincidentes.logica.Tecnico;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class EditarIncidente extends javax.swing.JFrame {
    Controladora control;
    int idTecnico;
    int idIncidente;
    public EditarIncidente(Controladora control, int idTecnico, int idIncidente) {
        this.control = new Controladora();
        this.idTecnico = idTecnico;
        this.idIncidente = idIncidente;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTecnicos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaServicios = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtCuit = new javax.swing.JTextPane();
        btnBuscarTec = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtDificultad = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtFechaRes = new javax.swing.JTextPane();
        txtColchonHora = new javax.swing.JFormattedTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtEstado = new javax.swing.JTextPane();
        jLabel14 = new javax.swing.JLabel();
        txtFechaAlta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MODIFICACION DE INCIDENTES");

        cmbCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cmbCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbClienteItemStateChanged(evt);
            }
        });
        cmbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClienteActionPerformed(evt);
            }
        });

        jLabel2.setText("CLIENTE:");

        jLabel6.setText("CUIT:");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("FECHA DE HOY:");

        jSeparator1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tablaTecnicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaTecnicos);

        tablaServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaServicios);

        jLabel12.setText("SERVICIOS CONTRATADOS:");

        jLabel13.setText("TECNICOS DISPONIBLES:");

        jLabel8.setText("DESCRIPCION:");

        jLabel3.setText("FECHA RESOLUCION:");

        txtDescripcion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        jLabel10.setText("COLCHON DE HORAS");

        jLabel9.setText("DIFICULTAD:");

        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtCuit.setEditable(false);
        jScrollPane3.setViewportView(txtCuit);

        btnBuscarTec.setText("BUSCAR TECNICOS:");
        btnBuscarTec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTecActionPerformed(evt);
            }
        });

        jScrollPane5.setViewportView(txtDificultad);

        jScrollPane7.setViewportView(txtFechaRes);

        txtColchonHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jScrollPane6.setViewportView(txtEstado);

        jLabel14.setText("ESTADO:");

        txtFechaAlta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtFechaAlta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane7)))
                                        .addGap(89, 89, 89)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel9))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel14)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                    .addComponent(txtColchonHora)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscarTec))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(529, 673, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtFechaAlta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFechaAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(btnBuscarTec))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(jLabel3)
                                .addComponent(txtColchonHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel14)))
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir)
                    .addComponent(btnGuardar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Incidente incidente = control.traerUnIncidente(idIncidente);
        txtFechaAlta.setText(incidente.getFechaAlta());
        cmbCliente.addItem(incidente.getCliente().getRazonSocial());
        txtCuit.setText(incidente.getCliente().getCuit());
        cargarTablaServicios(incidente.getCliente().getRazonSocial());
        txtDescripcion.setText(incidente.getDescripcion());
        txtColchonHora.setText(incidente.getColchonHoras());
        txtFechaRes.setText(incidente.getFechaResolucion());
        txtDificultad.setText(incidente.getDificultad());
        txtEstado.setText(incidente.getEstado());
        
       
            
     
    }//GEN-LAST:event_formWindowOpened

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
      
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void cmbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClienteActionPerformed
        String cliSelec = cmbCliente.getItemAt(cmbCliente.getSelectedIndex());
        List<Cliente>listaClientes = control.traerClientes();
        for (Cliente listaCliente : listaClientes) {
            if(cliSelec.equalsIgnoreCase(listaCliente.getRazonSocial())){
                txtCuit.setText(listaCliente.getCuit());
            }
            
        }
        cargarTablaServicios(cliSelec);
        
        
        
    }//GEN-LAST:event_cmbClienteActionPerformed

    private void cmbClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbClienteItemStateChanged
        
    }//GEN-LAST:event_cmbClienteItemStateChanged

    private void btnBuscarTecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTecActionPerformed
        MesaDeAyuda mesaDeAyuda = new MesaDeAyuda(control, idTecnico,idIncidente);
        if (tablaServicios.getRowCount() > 0) {
            //controlo que se haya seleccionado almenos una fila
            if (tablaServicios.getSelectedRow() != -1) {
                //obtengo la id del Servicio a eliminar
                int idServicio = Integer.parseInt(String.valueOf(tablaServicios.getValueAt(tablaServicios.getSelectedRow(), 0)));
                cargarTablaTecnicos(idServicio);
                
                
            }
            else{ mesaDeAyuda.mostrarMensaje("debe seleccionar un Servicio", "Error", "Error al Cargar");}
        }
        else { mesaDeAyuda.mostrarMensaje("El cliente no tiene Servivios contratados", "Error", "Error al Cargar");}
    }//GEN-LAST:event_btnBuscarTecActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        List<Cliente>listaClientes = control.traerClientes();
        String cliente = cmbCliente.getItemAt(cmbCliente.getSelectedIndex());
        int idCliente=-1;
        for (Cliente unCliente : listaClientes) {
            if(cliente.equalsIgnoreCase(unCliente.getRazonSocial())){
                idCliente = unCliente.getId();
            }
        }
        String fechaAlta = txtFechaAlta.getText();
        String cuit = txtCuit.getText();
        int idTecnico = Integer.parseInt(String.valueOf(tablaTecnicos.getValueAt(tablaTecnicos.getSelectedRow(),0)));
        int idServicio = Integer.parseInt(String.valueOf(tablaServicios.getValueAt(tablaServicios.getSelectedRow(),0)));
        String descripcion = txtDescripcion.getText();
        String dificultad = txtDificultad.getText();
        String tipoProblema = String.valueOf(tablaServicios.getValueAt(tablaServicios.getSelectedRow(),2));
        String fechaReso = txtFechaRes.getText();
        String colchonHoras = txtColchonHora.getText();
        String estado = txtEstado.getText();
        
        control.editarIncidente(idIncidente, idCliente, idServicio, idTecnico, descripcion, dificultad, tipoProblema, estado, fechaAlta, fechaReso, colchonHoras);
        MesaDeAyuda mesaDeAyuda = new MesaDeAyuda(control, idTecnico,idIncidente);
        mesaDeAyuda.mostrarMensaje("El incidente se guardó correctamente", "Info", "Guardado");
        this.dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarTec;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaServicios;
    private javax.swing.JTable tablaTecnicos;
    private javax.swing.JFormattedTextField txtColchonHora;
    private javax.swing.JTextPane txtCuit;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextPane txtDificultad;
    private javax.swing.JTextPane txtEstado;
    private javax.swing.JLabel txtFechaAlta;
    private javax.swing.JTextPane txtFechaRes;
    // End of variables declaration//GEN-END:variables

public void cargarTablaServicios(String cliente) {
        //definir el modelo que queremos que tenga la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel() {

            //que fila y columna no sean editables
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //establecemos los nombres de las columnas1
        String titulos[] = {"ID", "Nombre", "Tipo"};
        modeloTabla.setColumnIdentifiers(titulos);

        //carga de los datos desde la base de datos
        List<Cliente> listaClientes = control.traerClientes();
        List<Servicio> listaServicios = control.traerServicios();
        //Recorrer la lista y mostrar cada uno de los elementos en la tabla
        
        if (!listaClientes.isEmpty()) {
            for (Cliente cli : listaClientes) {
                if(cliente.equalsIgnoreCase(cli.getRazonSocial())){
                    List<Servicio> serv = cli.getServicios();
                    for (Servicio servicio : serv) {
                        Object[] objeto = {servicio.getId(),servicio.getNombre(),servicio.getTipo()};
                        modeloTabla.addRow(objeto);
                    }
                }
            }
        }

        tablaServicios.setModel(modeloTabla);
    }

    private void cargarTablaTecnicos(int idServicio) {
         //definir el modelo que queremos que tenga la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel() {

            //que fila y columna no sean editables
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //establecemos los nombres de las columnas1
        String titulos[] = {"ID", "Nombre"};
        modeloTabla.setColumnIdentifiers(titulos);
        List<Tecnico>listaTecnicos = control.traerTecnicos();
        List<Servicio>especialdiad = new ArrayList<>();
        
        
        if (!listaTecnicos.isEmpty()) {
            for (Tecnico tec : listaTecnicos) {
                List<Servicio> especialidad = tec.getEspecialidad();
                for (Servicio tecEsp : especialidad) {
                    if(idServicio == tecEsp.getId()){
                        Object[] objeto = {tec.getId(),tec.getNombre()};
                        modeloTabla.addRow(objeto);
                    }
                }
            }
            
        }

        tablaTecnicos.setModel(modeloTabla);
    }   

    private void cargarDificultad(String tipoServ) {
        String dificultad;
        if(tipoServ.equalsIgnoreCase("Sistema Operativo")){
                txtDificultad.setText("Compleja");
        }
        else { txtDificultad.setText("Normal");}
        if(txtDificultad.getText().equalsIgnoreCase("Normal")){
            txtColchonHora.setText("8");
        }
        else { txtColchonHora.setText("16");}
        
    }
}