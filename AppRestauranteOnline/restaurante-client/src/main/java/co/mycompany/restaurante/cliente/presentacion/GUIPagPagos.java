package co.mycompany.restaurante.cliente.presentacion;

import static co.mycompany.restaurante.cliente.infra.Messages.successMessage;
import co.mycompany.restaurante.cliente.presentacion.mediodepago.GUIPagBancoPSE;
import co.mycompany.restaurante.cliente.presentacion.mediodepago.GUIPagTarjetaCredito;
import javax.swing.JOptionPane;
/**
 *
 * @author Kevith Felipe Bastidas
 */
public class GUIPagPagos extends javax.swing.JInternalFrame {
    /**
     * Instancia de la vistaMenuPlato
     */
    private final GUIPagMenuPlato vistaMenuPlato;
    /**
     * Creates new form Pagos
     * @param vistaMenuPlato
     */
    public GUIPagPagos(GUIPagMenuPlato vistaMenuPlato) {
        initComponents();
        this.vistaMenuPlato = vistaMenuPlato;
        setSize(431, 524);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        lbCentroTitulo = new javax.swing.JLabel();
        lbSelectMetodoPago = new javax.swing.JLabel();
        btnPSE = new javax.swing.JButton();
        lbCcentroIzqBotones = new javax.swing.JLabel();
        lbCentroDerBotones = new javax.swing.JLabel();
        btnTarjCredito = new javax.swing.JButton();
        btnEfectivo = new javax.swing.JButton();
        btnVolerMenuPrincipal = new javax.swing.JButton();
        lbEspaciadoBotones1 = new javax.swing.JLabel();
        lbEspaciadoBotones2 = new javax.swing.JLabel();

        setBorder(null);
        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        pnlPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlPrincipal.setAutoscrolls(true);

        lbCentroTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCentroTitulo.setIcon(new javax.swing.ImageIcon("./src/main/java/resources/metodo-de-pago.png"));

        lbSelectMetodoPago.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSelectMetodoPago.setText("Seleccione su método de pago:");

        btnPSE.setIcon(new javax.swing.ImageIcon("./src/main/java/resources/logo-pse.png"));
        btnPSE.setText("PSE");
        btnPSE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPSE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPSEActionPerformed(evt);
            }
        });

        btnTarjCredito.setIcon(new javax.swing.ImageIcon("./src/main/java/resources/pago-con-tarjetas-de-credito.png"));
        btnTarjCredito.setText("Tarjeta de crédito");
        btnTarjCredito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTarjCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTarjCreditoActionPerformed(evt);
            }
        });

        btnEfectivo.setIcon(new javax.swing.ImageIcon("./src/main/java/resources/pago-en-efectivo.png"));
        btnEfectivo.setText("Efectivo");
        btnEfectivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEfectivoActionPerformed(evt);
            }
        });

        btnVolerMenuPrincipal.setIcon(new javax.swing.ImageIcon("./src/main/java/resources/regreso.png"));
        btnVolerMenuPrincipal.setText("Cancelar Pedido");
        btnVolerMenuPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolerMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolerMenuPrincipalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCentroTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSelectMetodoPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(lbCcentroIzqBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEfectivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTarjCredito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPSE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbEspaciadoBotones1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbEspaciadoBotones2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(lbCentroDerBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVolerMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCentroTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSelectMetodoPago)
                .addGap(18, 18, 18)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbCentroDerBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                        .addComponent(lbCcentroIzqBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(btnPSE, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbEspaciadoBotones1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTarjCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lbEspaciadoBotones2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEfectivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolerMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Crea una instancia de GUIPagBancoPSE y la muestra
     * La vista maneja el pago por medio de PSE
     * @param evt 
     */
    private void btnPSEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPSEActionPerformed
        GUIPagBancoPSE vistaPSE = new GUIPagBancoPSE(this);
        this.vistaMenuPlato.getVistaPrincipal().agregarComponente(vistaPSE);
    }//GEN-LAST:event_btnPSEActionPerformed
    /**
     * Crea una instancia de GUIPagTarjetaCredito y la muestra
     * La vista maneja el pago por medio de Tarjeta de Credito.
     * @param evt 
     */
    private void btnTarjCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTarjCreditoActionPerformed
        GUIPagTarjetaCredito vistaPSE = new GUIPagTarjetaCredito(this);
        this.vistaMenuPlato.getVistaPrincipal().agregarComponente(vistaPSE);
    }//GEN-LAST:event_btnTarjCreditoActionPerformed
    /**
     * Realiza el pago mediante EFECTIVO 
     * @param evt 
     */
    private void btnEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEfectivoActionPerformed
        successMessage("Pedido registrado con éxito, deberá pagar cuando se entregue el pedido","Pedido solicitado");
        
        this.vistaMenuPlato.getVistaPrincipal().agregarComponente(vistaMenuPlato);
        this.vistaMenuPlato.generarPedido("Efectivo");
    }//GEN-LAST:event_btnEfectivoActionPerformed
    /**
     * En caso de querer cancelar el pedido lo redireccionara a la vista
     * del Menu de Plato
     * @param evt 
     */
    private void btnVolerMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolerMenuPrincipalActionPerformed
        this.vistaMenuPlato.getVistaPrincipal().agregarComponente(vistaMenuPlato);
    }//GEN-LAST:event_btnVolerMenuPrincipalActionPerformed
    /**
     * Devuelve una referencia de la vistaPrincipal
     * @return 
     */
    public GUIPrincipal getVistaPrincipal(){
        return this.vistaMenuPlato.getVistaPrincipal();
    }
    /**
     * Devuelve una referencia de la vistaMenuPlato
     * @return 
     */
    public GUIPagMenuPlato getVistaMenuPlato(){
        return this.vistaMenuPlato;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEfectivo;
    private javax.swing.JButton btnPSE;
    private javax.swing.JButton btnTarjCredito;
    private javax.swing.JButton btnVolerMenuPrincipal;
    private javax.swing.JLabel lbCcentroIzqBotones;
    private javax.swing.JLabel lbCentroDerBotones;
    private javax.swing.JLabel lbCentroTitulo;
    private javax.swing.JLabel lbEspaciadoBotones1;
    private javax.swing.JLabel lbEspaciadoBotones2;
    private javax.swing.JLabel lbSelectMetodoPago;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
