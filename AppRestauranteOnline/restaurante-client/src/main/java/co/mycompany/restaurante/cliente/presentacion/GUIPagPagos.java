package co.mycompany.restaurante.cliente.presentacion;

import javax.swing.JOptionPane;

/**
 *
 * @author Kevith Felipe Bastidas
 */
public class GUIPagPagos extends javax.swing.JInternalFrame {

    /**
     * Instacia de la vistaPrincipal
     */
    private final GUIPrincipal vistaPrincipal;
    /**
     * Instancia de la vistaMenuPlato
     */
    private final GUIPagMenuPlato vistaMenuPlato;
    /**
     * Creates new form Pagos
     * @param vistaPrincipal
     * @param vistaMenuPlato
     */
    public GUIPagPagos(GUIPrincipal vistaPrincipal,GUIPagMenuPlato vistaMenuPlato) {
        initComponents();
        this.vistaPrincipal = vistaPrincipal;
        this.vistaMenuPlato = vistaMenuPlato;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlPrincipal = new javax.swing.JPanel();
        lbVacioCentroTitutlo = new javax.swing.JLabel();
        lbSeleccionPago = new javax.swing.JLabel();
        lbVacioControlCentroDerecho = new javax.swing.JLabel();
        lbVacioControlCentroIzq = new javax.swing.JLabel();
        btnPSE = new javax.swing.JButton();
        btnTarjetaCredito = new javax.swing.JButton();
        btnTarjetaDebito = new javax.swing.JButton();
        btnEfectivo = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setTitle("Pagos");

        PnlPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbSeleccionPago.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSeleccionPago.setText("Método de pago:");

        btnPSE.setBackground(new java.awt.Color(63, 84, 98));
        btnPSE.setText("Pago por PSE");
        btnPSE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPSEActionPerformed(evt);
            }
        });

        btnTarjetaCredito.setBackground(new java.awt.Color(63, 84, 98));
        btnTarjetaCredito.setText("Tarjeta de crédito");
        btnTarjetaCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTarjetaCreditoActionPerformed(evt);
            }
        });

        btnTarjetaDebito.setBackground(new java.awt.Color(63, 84, 98));
        btnTarjetaDebito.setText("Tarjeta de débito");
        btnTarjetaDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTarjetaDebitoActionPerformed(evt);
            }
        });

        btnEfectivo.setBackground(new java.awt.Color(63, 84, 98));
        btnEfectivo.setText("Pago en efectivo");
        btnEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEfectivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnlPrincipalLayout = new javax.swing.GroupLayout(PnlPrincipal);
        PnlPrincipal.setLayout(PnlPrincipalLayout);
        PnlPrincipalLayout.setHorizontalGroup(
            PnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbVacioCentroTitutlo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSeleccionPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PnlPrincipalLayout.createSequentialGroup()
                        .addComponent(lbVacioControlCentroIzq, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(PnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEfectivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTarjetaDebito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTarjetaCredito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPSE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(lbVacioControlCentroDerecho, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PnlPrincipalLayout.setVerticalGroup(
            PnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbVacioCentroTitutlo, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSeleccionPago)
                .addGap(18, 18, 18)
                .addGroup(PnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbVacioControlCentroDerecho, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbVacioControlCentroIzq, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPSE))
                .addGap(18, 18, 18)
                .addComponent(btnTarjetaCredito)
                .addGap(18, 18, 18)
                .addComponent(btnTarjetaDebito)
                .addGap(18, 18, 18)
                .addComponent(btnEfectivo)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPSEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPSEActionPerformed
        JOptionPane.showMessageDialog(null, "Pago del pedido realizado con éxito", 
                "Pago exitoso", JOptionPane.OK_OPTION);
        generarPago("PSE");
        
    }//GEN-LAST:event_btnPSEActionPerformed

    private void btnTarjetaCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTarjetaCreditoActionPerformed
        JOptionPane.showMessageDialog(null, "Pago del pedido realizado con éxito", 
                "Pago exitoso", JOptionPane.OK_OPTION);
        generarPago("TARJETA CREDITO");
    }//GEN-LAST:event_btnTarjetaCreditoActionPerformed

    private void btnTarjetaDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTarjetaDebitoActionPerformed
        JOptionPane.showMessageDialog(null, "Pago del pedido realizado con éxito", 
                "Pago exitoso", JOptionPane.OK_OPTION);
        generarPago("TARJETA DEBITO");
    }//GEN-LAST:event_btnTarjetaDebitoActionPerformed

    private void btnEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEfectivoActionPerformed
        JOptionPane.showMessageDialog(null, "Pago del pedido realizado con éxito", 
                "Pago exitoso", JOptionPane.OK_OPTION);
        generarPago("EFECTIVO");
    }//GEN-LAST:event_btnEfectivoActionPerformed

    public void generarPago(String metodo){
        this.vistaPrincipal.agregarComponente(this.vistaMenuPlato);
        
        this.vistaMenuPlato.show();
        
        this.dispose();
        this.vistaMenuPlato.generarPedido(metodo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnlPrincipal;
    private javax.swing.JButton btnEfectivo;
    private javax.swing.JButton btnPSE;
    private javax.swing.JButton btnTarjetaCredito;
    private javax.swing.JButton btnTarjetaDebito;
    private javax.swing.JLabel lbSeleccionPago;
    private javax.swing.JLabel lbVacioCentroTitutlo;
    private javax.swing.JLabel lbVacioControlCentroDerecho;
    private javax.swing.JLabel lbVacioControlCentroIzq;
    // End of variables declaration//GEN-END:variables
}
