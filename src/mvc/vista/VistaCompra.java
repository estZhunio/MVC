package mvc.vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Zhunio
 */
public class VistaCompra extends javax.swing.JInternalFrame {

    /**
     * Creates new form CrudPersona
     */
    public VistaCompra() {
        initComponents();
    }

    public JButton getBtnBuscar() {
        return btnBuscarPersona;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscarPersona = btnBuscar;
    }


    public JPanel getPnOpciiones() {
        return pnOpciiones;
    }

    public void setPnOpciiones(JPanel pnOpciiones) {
        this.pnOpciiones = pnOpciiones;
    }


    public JTable getTbProducto() {
        return tbProducto;
    }

    public void setTbProducto(JTable tbProducto) {
        this.tbProducto = tbProducto;
    }

    public JTextField getTxtId() {
        return txtNombreProducto;
    }

    public void setTxtId(JTextField txtId) {
        this.txtNombreProducto = txtId;
    }

    public JLabel getLbSubtotal() {
        return lbSubtotal;
    }

    public void setLbSubtotal(JLabel lbSubtotal) {
        this.lbSubtotal = lbSubtotal;
    }

    public JLabel getLbRuc() {
        return lbRuc;
    }

    public void setLbRuc(JLabel lbRuc) {
        this.lbRuc = lbRuc;
    }

    public JLabel getLbNombre() {
        return lbNombre;
    }

    public void setLbNombre(JLabel lbNombre) {
        this.lbNombre = lbNombre;
    }

    public JLabel getLbApellido() {
        return lbApellido;
    }

    public void setLbApellido(JLabel lbApellido) {
        this.lbApellido = lbApellido;
    }

    public JLabel getLbFechaEmision() {
        return lbFechaEmision;
    }

    public void setLbFechaEmision(JLabel lbFechaEmision) {
        this.lbFechaEmision = lbFechaEmision;
    }

    public JLabel getLbTotal() {
        return lbTotal;
    }

    public void setLbTotal(JLabel lbTotal) {
        this.lbTotal = lbTotal;
    }

    public JPopupMenu getMenuOpciones() {
        return menuOpciones;
    }

    public void setMenuOpciones(JPopupMenu menuOpciones) {
        this.menuOpciones = menuOpciones;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgSexo = new javax.swing.ButtonGroup();
        menuOpciones = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnBuscarPersona = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProducto = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        lbSubtotal = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        btnBuscarProducto = new javax.swing.JButton();
        pnOpciiones = new javax.swing.JPanel();
        btnCrear = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        pnDatosClientes = new javax.swing.JPanel();
        lbApellido = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnEscoger = new javax.swing.JButton();
        lbIdProducto2 = new javax.swing.JLabel();
        lbIdProducto3 = new javax.swing.JLabel();
        lbIdProducto4 = new javax.swing.JLabel();
        lbIdProducto5 = new javax.swing.JLabel();
        lbIdProducto6 = new javax.swing.JLabel();
        lbIdProducto7 = new javax.swing.JLabel();
        lbRuc = new javax.swing.JLabel();
        lbFechaEmision = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbIdProducto13 = new javax.swing.JLabel();
        lbIdProducto14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        jPanel6.setOpaque(false);

        btnBuscarPersona.setText("Buscar");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Cedula del cliente:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(jLabel12)
                .addGap(24, 24, 24)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(310, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarPersona)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle Factura"));

        tbProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Precio", "Cantidad", "Debe US $"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbProducto);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Subtotal:");

        lbSubtotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Nombre del producto:");

        btnBuscarProducto.setText("Buscar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1358, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProducto))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSubtotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        pnOpciiones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCrear.setText("Crear");
        pnOpciiones.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1955, 391, 188, 35));

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        pnOpciiones.add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1955, 638, 188, 35));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        pnOpciiones.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1955, 685, 188, 35));

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        pnOpciiones.add(btnRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(1955, 732, 188, 35));

        btnImprimir.setText("Cargar todos los datos");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        pnOpciiones.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1955, 779, -1, 38));

        pnDatosClientes.setOpaque(false);
        pnDatosClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbApellido.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbApellido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnDatosClientes.add(lbApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 60, 330, 30));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Descripcion:");
        pnDatosClientes.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 108, -1));

        btnEscoger.setText("Escoger");
        pnDatosClientes.add(btnEscoger, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 330, -1, -1));

        lbIdProducto2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbIdProducto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnDatosClientes.add(lbIdProducto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 410, 30));

        lbIdProducto3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbIdProducto3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIdProducto3.setText("RUC cliente:");
        pnDatosClientes.add(lbIdProducto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 160, -1));

        lbIdProducto4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbIdProducto4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIdProducto4.setText("Total de factura:");
        pnDatosClientes.add(lbIdProducto4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 150, 170, -1));

        lbIdProducto5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbIdProducto5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIdProducto5.setText("Nombre del cliente:");
        pnDatosClientes.add(lbIdProducto5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 160, -1));

        lbIdProducto6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbIdProducto6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIdProducto6.setText("Fecha de emision:");
        pnDatosClientes.add(lbIdProducto6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 160, -1));

        lbIdProducto7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbIdProducto7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIdProducto7.setText("Apellido del cliente:");
        pnDatosClientes.add(lbIdProducto7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 160, -1));

        lbRuc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbRuc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnDatosClientes.add(lbRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 330, 30));

        lbFechaEmision.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbFechaEmision.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnDatosClientes.add(lbFechaEmision, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 100, 330, 30));

        lbTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnDatosClientes.add(lbTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 140, 330, 30));

        lbNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnDatosClientes.add(lbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 330, 30));

        lbIdProducto13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbIdProducto13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnDatosClientes.add(lbIdProducto13, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 330, 30));

        lbIdProducto14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbIdProducto14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIdProducto14.setText("No. de Factura:");
        pnDatosClientes.add(lbIdProducto14, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 180, -1));

        pnOpciiones.add(pnDatosClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1380, 200));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnOpciiones, javax.swing.GroupLayout.PREFERRED_SIZE, 1380, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnOpciiones, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgSexo;
    private javax.swing.JButton btnBuscarPersona;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEscoger;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbFechaEmision;
    private javax.swing.JLabel lbIdProducto13;
    private javax.swing.JLabel lbIdProducto14;
    private javax.swing.JLabel lbIdProducto2;
    private javax.swing.JLabel lbIdProducto3;
    private javax.swing.JLabel lbIdProducto4;
    private javax.swing.JLabel lbIdProducto5;
    private javax.swing.JLabel lbIdProducto6;
    private javax.swing.JLabel lbIdProducto7;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbRuc;
    private javax.swing.JLabel lbSubtotal;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JPopupMenu menuOpciones;
    private javax.swing.JPanel pnDatosClientes;
    private javax.swing.JPanel pnOpciiones;
    private javax.swing.JTable tbProducto;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombreProducto;
    // End of variables declaration//GEN-END:variables
}
