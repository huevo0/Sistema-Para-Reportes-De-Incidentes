package capas.reportesincidentes.igu;

import capas.reportesincidentes.logica.Cliente;
import capas.reportesincidentes.logica.Controladora;
import capas.reportesincidentes.logica.Incidente;
import capas.reportesincidentes.logica.Servicio;
import capas.reportesincidentes.logica.Tecnico;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AreaTecnico extends javax.swing.JFrame {

    Controladora control;
    int idTecnico;
    int idIncidente;

    public AreaTecnico(Controladora control, int idTecnico, int idIncidente) {
        this.control = control;
        this.idTecnico = idTecnico;
        this.idIncidente = idIncidente;
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaIncidentes = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnResuelto = new javax.swing.JButton();
        btnRecargar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnPendiente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtTituloTecnico = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tablaIncidentes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tablaIncidentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaIncidentes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 847, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnResuelto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnResuelto.setText("ESTADO RESUELTO");
        btnResuelto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnResuelto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResueltoActionPerformed(evt);
            }
        });

        btnRecargar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRecargar.setText("RECARGAR");
        btnRecargar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecargarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnPendiente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPendiente.setText("ESTADO PENDIENTE");
        btnPendiente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPendiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPendienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnResuelto, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(btnRecargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPendiente, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnResuelto, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPendiente, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRecargar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("AREA DE SOPORTE TÉCNICO");

        txtTituloTecnico.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtTituloTecnico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTituloTecnico.setText("-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTituloTecnico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTituloTecnico)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Tecnico tecnico = control.traerUnTecnico(idTecnico);
        txtTituloTecnico.setText("INCIDENTES PARA EL TÉCNICO:  " + tecnico.getNombre());
        cargarTabla();
    }//GEN-LAST:event_formWindowOpened

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Principal pantalla = new Principal();
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnResueltoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResueltoActionPerformed
        if (tablaIncidentes.getRowCount() > 0) {
            //controlo que se haya seleccionado almenos una fila
            if (tablaIncidentes.getSelectedRow() != -1) {
                //obtengo la id del Incidente a eliminar
                idIncidente = Integer.parseInt(String.valueOf(tablaIncidentes.getValueAt(tablaIncidentes.getSelectedRow(), 0)));
                String estado = String.valueOf(tablaIncidentes.getValueAt(tablaIncidentes.getSelectedRow(), 6));
                if(!estado.equalsIgnoreCase("Resuelto")){
                    control.estadoResuelto(idIncidente);
                    mostrarMensaje("Estado cambiado con exito a Resuelto", "Info", "Cambio de estado");
                }
                else { mostrarMensaje("El incidente ya está marcado como RESUELTO", "ERROR", "Cambio de Estado");}
            }
            else { mostrarMensaje("Seleccione un Incidente para modificar.", "Error", "Error al Cambiar Estado");}
        }
        else { mostrarMensaje("No hay incidente a modificar.", "ERROR", "Error al modificar");}
    }//GEN-LAST:event_btnResueltoActionPerformed

    private void btnRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecargarActionPerformed
        cargarTabla();
    }//GEN-LAST:event_btnRecargarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        cargarTabla();
    }//GEN-LAST:event_formWindowActivated

    private void btnPendienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPendienteActionPerformed
        if (tablaIncidentes.getRowCount() > 0) {
            //controlo que se haya seleccionado almenos una fila
            if (tablaIncidentes.getSelectedRow() != -1) {
                //obtengo la id del Incidente a eliminar
                idIncidente = Integer.parseInt(String.valueOf(tablaIncidentes.getValueAt(tablaIncidentes.getSelectedRow(), 0)));
                String estado = String.valueOf(tablaIncidentes.getValueAt(tablaIncidentes.getSelectedRow(), 6));
                if(!estado.equalsIgnoreCase("Pendiente")){
                    control.estadoPendiente(idIncidente);
                    mostrarMensaje("Estado cambiado con exito a PENDIENTE", "Info", "Cambio de estado");
                }
                else { mostrarMensaje("El incidente ya está marcado como PENDIENTE", "ERROR", "Cambio de Estado");}
            }
            else { mostrarMensaje("Seleccione un Incidente para modificar.", "Error", "Error al Cambiar Estado");}
        }
        else { mostrarMensaje("No hay incidente a modificar.", "ERROR", "Error al modificar");}
    }//GEN-LAST:event_btnPendienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPendiente;
    private javax.swing.JButton btnRecargar;
    private javax.swing.JButton btnResuelto;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaIncidentes;
    private javax.swing.JLabel txtTituloTecnico;
    // End of variables declaration//GEN-END:variables

    public void cargarTabla() {
        //definir el modelo que queremos que tenga la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel() {

            //que fila y columna no sean editables
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //establecemos los nombres de las columnas1
        String titulos[] = {"ID", "CLIENTE", "DESCRIPCION", "DIFICULTAD", "SERVICIO", "TIPO" , "ESTADO" , "FECHA INGRESO" , "FECHA RESOLUCION", "COLCHON DE HORAS"};
        modeloTabla.setColumnIdentifiers(titulos);
        
        //carga de los datos desde la base de datos
        List<Incidente> listaIncidentes = control.traerIncidentes();
        
        //Recorrer la lista y mostrar cada uno de los elementos en la tabla
        if (!listaIncidentes.isEmpty()) {
            for (Incidente inc : listaIncidentes) {
                if(idTecnico == inc.getTecnico().getId()){
                    Object[] objeto = {inc.getId(), inc.getCliente().getRazonSocial(), inc.getDescripcion(), inc.getDificultad(),inc.getServicio().getNombre() ,
                                    inc.getTipoProblema(), inc.getEstado(), inc.getFechaAlta(), inc.getFechaResolucion(), inc.getColchonHoras()};
                    modeloTabla.addRow(objeto);
                }
            }
        }

        tablaIncidentes.setModel(modeloTabla);
    }

    public void mostrarMensaje(String mensaje, String tipo, String titulo) {
        JOptionPane optionPane = new JOptionPane(mensaje);
        if (tipo.equalsIgnoreCase("Info")) {
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        } else if (tipo.equalsIgnoreCase("Error")) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);

        }
        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setVisible(true);
        dialog.setAlwaysOnTop(true);
        dialog.setLocationRelativeTo(null);
    }
}
