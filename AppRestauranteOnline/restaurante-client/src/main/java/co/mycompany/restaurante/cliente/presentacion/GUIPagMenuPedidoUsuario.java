package co.mycompany.restaurante.cliente.presentacion;

import co.mycompany.restaurante.cliente.domain.entity.Componente;
import co.mycompany.restaurante.cliente.domain.entity.Pedido;
import co.mycompany.restaurante.cliente.domain.entity.Restaurante;
import co.mycompany.restaurante.cliente.domain.entity.Usuario;
import static co.mycompany.restaurante.cliente.infra.Messages.warningMessage;
import co.mycompany.restaurante.cliente.infra.Security;
import co.mycompany.restaurante.cliente.infra.services.RestauranteService;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kevith Felipe Bastidas
 */
public class GUIPagMenuPedidoUsuario extends javax.swing.JInternalFrame {
    /**
     * instacia la clase RestauranteService para poder acceder asus servicios
     */
    private final RestauranteService service;
    /**
     * Creates new form GUIPagMenuPedidoUsuario
     * @param service
     * @param vistaPrincipal
     */
    public GUIPagMenuPedidoUsuario(RestauranteService service) {
        initComponents();
        setSize(1366,672);
        this.service = service;
        listarRegistro();
    }
    /**
     * Configuracion de la tabla para ingresar los registros.
     * @return 
     */
    private DefaultTableModel configuracionTablaMenuRestaurante(){
        boolean[] editable = {false,false,false,false,false,false,false,false};
        DefaultTableModel tablaMenuRestuarante = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return editable[column];
            }
        };
        return tablaMenuRestuarante;
    } 
    /**
     * lista toda la informacion de los pedidos del usuario
     */
    private void listarRegistro(){
        DefaultTableModel tablaRegistroPedidos = configuracionTablaMenuRestaurante();
        tablaRegistroPedidos.addColumn("<html><b><span style='font-size:16px'>Codigo</span></b></html>");
        tablaRegistroPedidos.addColumn("<html><b><span style='font-size:16px'>Pedido</span></b></html>");
        tablaRegistroPedidos.addColumn("<html><b><span style='font-size:16px'>Cantidad</span></b></html>");
        tablaRegistroPedidos.addColumn("<html><b><span style='font-size:16px'>Restaurante</span></b></html>");
        tablaRegistroPedidos.addColumn("<html><b><span style='font-size:16px'>Direccion</span></b></html>");
        tablaRegistroPedidos.addColumn("<html><b><span style='font-size:16px'>Total</span></b></html>");
        tablaRegistroPedidos.addColumn("<html><b><span style='font-size:16px'>Medio De Pago</span></b></html>");
        tablaRegistroPedidos.addColumn("<html><b><span style='font-size:16px'>Fecha</span></b></html>");
        Object fila[] = new Object[tablaRegistroPedidos.getColumnCount()];
        
        List<Pedido> pedidos = service.getPedidos(Security.usuario.getUser());
        
        for (Pedido pedido : pedidos) {
            fila[0] = pedido.getPe_id();
           
            String mensaje = "<html>";
            for (Componente componente : pedido.getComponentes()){
                mensaje += "<b>" + componente.getTipo()+"</b>: "+componente.getNombre()+"<br/>";
            }
            fila[1] = mensaje + "</html>";
            Restaurante restaurante = service.getRestaurante(pedido.getRest_id());
            mensaje = "<html><b>Nombre: </b>"+restaurante.getNombre()+"<br/><br/>";
            mensaje += "<b>Direccion: </b>"+restaurante.getDireccion()+"<br/>";
            fila[2] = pedido.getPe_cantidad();
            fila[3] = mensaje+ "</html>";
            Usuario usuario = service.getUsuario(pedido.getUser_id());
            fila[4] = usuario.getDireccion();
            fila[5] = pedido.getTotalPedido();
            fila[6] = pedido.getPe_formapago();
            fila[7] = pedido.getPe_fecha();
            
            tablaRegistroPedidos.addRow(fila);
        }
        
        tablaPedido.setModel(tablaRegistroPedidos);
        tablaPedido.setRowHeight(80);
        tablaPedido.getColumnModel().getColumn(0).setPreferredWidth(10);
        tablaPedido.getColumnModel().getColumn(1).setPreferredWidth(150);
        
    }   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPPrincipal = new javax.swing.JPanel();
        JpSuperior = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JpOpciones = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JpPanelBotones = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        BtnAyuda = new javax.swing.JButton();
        JpCentral = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPedido = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        jPPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPPrincipal.setLayout(new java.awt.BorderLayout());

        JpSuperior.setBackground(new java.awt.Color(138, 0, 58));
        JpSuperior.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JpSuperior.setLayout(new java.awt.GridBagLayout());

        jLabel1.setBackground(new java.awt.Color(159, 0, 70));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/rest.jpg"))); // NOI18N
        JpSuperior.add(jLabel1, new java.awt.GridBagConstraints());

        JpOpciones.setLayout(new java.awt.BorderLayout());
        JpOpciones.add(jLabel2, java.awt.BorderLayout.PAGE_START);
        JpOpciones.add(jLabel4, java.awt.BorderLayout.PAGE_END);

        JpPanelBotones.setBackground(new java.awt.Color(138, 0, 58));

        jLabel3.setText("         ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel9.setText("  Pedidos de usuario     ");

        BtnAyuda.setBackground(new java.awt.Color(255, 255, 255));
        BtnAyuda.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BtnAyuda.setText("Ayuda en linea");
        BtnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAyudaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpPanelBotonesLayout = new javax.swing.GroupLayout(JpPanelBotones);
        JpPanelBotones.setLayout(JpPanelBotonesLayout);
        JpPanelBotonesLayout.setHorizontalGroup(
            JpPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpPanelBotonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpPanelBotonesLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(359, 359, 359))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpPanelBotonesLayout.createSequentialGroup()
                        .addComponent(BtnAyuda)
                        .addGap(78, 78, 78))))
        );
        JpPanelBotonesLayout.setVerticalGroup(
            JpPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpPanelBotonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JpPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(BtnAyuda))
                    .addComponent(jLabel3))
                .addGap(28, 28, 28))
        );

        JpOpciones.add(JpPanelBotones, java.awt.BorderLayout.CENTER);

        JpSuperior.add(JpOpciones, new java.awt.GridBagConstraints());

        jPPrincipal.add(JpSuperior, java.awt.BorderLayout.PAGE_START);

        JpCentral.setBackground(new java.awt.Color(204, 204, 204));
        JpCentral.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JpCentral.setLayout(new java.awt.BorderLayout());

        jLabel5.setText("         ");
        JpCentral.add(jLabel5, java.awt.BorderLayout.PAGE_START);

        jLabel6.setText("             ");
        JpCentral.add(jLabel6, java.awt.BorderLayout.LINE_START);

        jLabel7.setText("         ");
        JpCentral.add(jLabel7, java.awt.BorderLayout.PAGE_END);

        jLabel8.setText("           ");
        JpCentral.add(jLabel8, java.awt.BorderLayout.LINE_END);

        tablaPedido.setBackground(new java.awt.Color(153, 153, 153));
        tablaPedido.setForeground(new java.awt.Color(51, 51, 51));
        tablaPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Pedido", "Restaurante", "Estado", "Title 5", "Total"
            }
        ));
        jScrollPane1.setViewportView(tablaPedido);

        JpCentral.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPPrincipal.add(JpCentral, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * btn Ayuda lo direcciona a una pagina donde un asesor lo atendera
     * @param evt 
     */
    private void BtnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAyudaActionPerformed
        // TODO add your handling code here:
        warningMessage("En construcción....", "Atención");
    }//GEN-LAST:event_BtnAyudaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAyuda;
    private javax.swing.JPanel JpCentral;
    private javax.swing.JPanel JpOpciones;
    private javax.swing.JPanel JpPanelBotones;
    private javax.swing.JPanel JpSuperior;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPedido;
    // End of variables declaration//GEN-END:variables
}
