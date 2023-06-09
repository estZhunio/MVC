package mvc.vista;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Zhunio
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public JPanel getPnInternalFrame() {
        return pnInternalFrame;
    }

    public void setPnInternalFrame(JPanel pnInternalFrame) {
        this.pnInternalFrame = pnInternalFrame;
    }

    public JMenuItem getMnMantenimientoClientes() {
        return mnMantenimientoClientes;
    }

    public void setMnMantenimientoClientes(JMenuItem mnMantenimientoClientes) {
        this.mnMantenimientoClientes = mnMantenimientoClientes;
    }

    public JMenuItem getMnMantenimientoProductos() {
        return mnMantenimientoProductos;
    }

    public void setMnMantenimientoProductos(JMenuItem mnMantenimientoProductos) {
        this.mnMantenimientoProductos = mnMantenimientoProductos;
    }

    public JMenuItem getMnCompra() {
        return mnCompra;
    }

    public void setMnCompra(JMenuItem mnCompra) {
        this.mnCompra = mnCompra;
    }

    public JMenuItem getMnReportes() {
        return mnReportes;
    }

    public void setMnReportes(JMenuItem mnReportes) {
        this.mnReportes = mnReportes;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnInternalFrame = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnMantenimientoClientes = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnMantenimientoProductos = new javax.swing.JMenuItem();
        mnCompra = new javax.swing.JMenuItem();
        mnReporte = new javax.swing.JMenu();
        mnReportes = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnInternalFrame.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout pnInternalFrameLayout = new javax.swing.GroupLayout(pnInternalFrame);
        pnInternalFrame.setLayout(pnInternalFrameLayout);
        pnInternalFrameLayout.setHorizontalGroup(
            pnInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnInternalFrameLayout.setVerticalGroup(
            pnInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 871, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(173, Short.MAX_VALUE)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 929, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(297, 297, 297))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jMenu1.setText("Clientes");

        mnMantenimientoClientes.setText("Mantenimiento");
        mnMantenimientoClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnMantenimientoClientesActionPerformed(evt);
            }
        });
        jMenu1.add(mnMantenimientoClientes);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Productos");

        mnMantenimientoProductos.setText("Mantenimiento");
        jMenu2.add(mnMantenimientoProductos);

        mnCompra.setText("Compra");
        jMenu2.add(mnCompra);

        jMenuBar1.add(jMenu2);

        mnReporte.setText("Reportes");

        mnReportes.setText("Enlistar reportes");
        mnReporte.add(mnReportes);

        jMenuBar1.add(mnReporte);

        jMenu4.setText("Ayuda");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnInternalFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnInternalFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnMantenimientoClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnMantenimientoClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnMantenimientoClientesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JMenuItem mnCompra;
    private javax.swing.JMenuItem mnMantenimientoClientes;
    private javax.swing.JMenuItem mnMantenimientoProductos;
    private javax.swing.JMenu mnReporte;
    private javax.swing.JMenuItem mnReportes;
    private javax.swing.JPanel pnInternalFrame;
    // End of variables declaration//GEN-END:variables
}
