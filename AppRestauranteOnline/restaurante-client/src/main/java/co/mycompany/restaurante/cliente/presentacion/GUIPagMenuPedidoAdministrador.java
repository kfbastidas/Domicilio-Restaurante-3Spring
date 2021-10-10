package co.mycompany.restaurante.cliente.presentacion;
import co.mycompany.restaurante.cliente.domain.entity.Componente;
import co.mycompany.restaurante.cliente.domain.entity.Pedido;
import co.mycompany.restaurante.cliente.domain.entity.Restaurante;
import co.mycompany.restaurante.cliente.domain.entity.Usuario;
import co.mycompany.restaurante.cliente.infra.services.RestauranteService;
import static co.mycompany.restaurante.cliente.infra.Messages.successMessage;
import co.mycompany.restaurante.cliente.infra.Security;
import co.mycompany.restaurante.cliente.infra.imgTabla;
import java.util.List;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kevit
 */
public class GUIPagMenuPedidoAdministrador extends javax.swing.JInternalFrame {
    /**
     * instacia la clase RestauranteService para poder acceder asus servicios
     */
    private final RestauranteService service; 
    /**
     * Creates new form GUIPagMenuPedidoAdministrador
     * @param service
     * @param restaurante
     * @param vistaPrincipal
     */
    public GUIPagMenuPedidoAdministrador(RestauranteService service) {
        initComponents();
        setSize(1366,672);
        this.service = service;
        obtenerRestaurantescbx();
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
    
    private void obtenerRestaurantescbx(){
        List<Restaurante> restaurantes = service.getRestaurantes(Security.usuario.getUser());
        cbxRestaurante.removeAllItems();
        for (Restaurante restaurante : restaurantes) {
            cbxRestaurante.addItem(restaurante+"");
        }
    }
    
    /**
     * Lista todos los pedidos que tiene el administrador en un restaurante determinado
     */
    private void listarRegistro(){
        DefaultTableModel tablaRegistroPedidos = configuracionTablaMenuRestaurante();
        tablaRegistroPedidos.addColumn("<html><b><span style='font-size:16px'>Codigo</span></b></html>");
        tablaRegistroPedidos.addColumn("<html><b><span style='font-size:16px'>Pedido</span></b></html>");
        tablaRegistroPedidos.addColumn("<html><b><span style='font-size:16px'>Cantidad</span></b></html>");
        tablaRegistroPedidos.addColumn("<html><b><span style='font-size:16px'>Hora</span></b></html>");
        tablaRegistroPedidos.addColumn("<html><b><span style='font-size:16px'>Direccion</span></b></html>");
        tablaRegistroPedidos.addColumn("<html><b><span style='font-size:16px'>Total</span></b></html>");
        tablaRegistroPedidos.addColumn("<html><b><span style='font-size:16px'>Medio De Pago</span></b></html>");
        if (cbxMostrarPedido.getSelectedIndex()==0){
            tablaRegistroPedidos.addColumn("<html><b><span style='font-size:16px'>Estado</span></b></html>");
        }
        
        
        Object fila[] = new Object[tablaRegistroPedidos.getColumnCount()];
        List<Pedido> pedidos = service.getPedidos(cbxRestaurante.getSelectedIndex(), cbxMostrarPedido.getSelectedIndex());
        if (cbxMostrarPedido.getSelectedIndex()==0) {
            
            tablaPedido.setDefaultRenderer(Object.class, new imgTabla());
            JButton btnDetalles=new JButton("Enviar Pedido");
            fila[7] = btnDetalles;
        }
        
        for (Pedido pedido : pedidos) {
            fila[0] = pedido.getPe_id();
           
            String mensaje = "<html>";
            for (Componente componente : pedido.getComponentes()){
                mensaje += "<b>" + componente.getTipo()+"</b>: "+componente.getNombre()+"<br/>";
            }
            fila[1] = mensaje + "</html>";
            fila[2] = pedido.getPe_cantidad();
            fila[3] = pedido.getPe_fecha();
            Usuario usuario = service.getUsuario(pedido.getUser_id());
            fila[4] = usuario.getDireccion();
            fila[5] = pedido.getTotalPedido();
            fila[6] = pedido.getPe_formapago();
            
            
            tablaRegistroPedidos.addRow(fila);
        }
        
        tablaPedido.setModel(tablaRegistroPedidos);
        tablaPedido.setRowHeight(80);
        tablaPedido.getColumnModel().getColumn(0).setPreferredWidth(10);
        tablaPedido.getColumnModel().getColumn(1).setPreferredWidth(150);
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpSuperior = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cbxMostrarPedido = new javax.swing.JComboBox<>();
        lblRestaurante = new javax.swing.JLabel();
        cbxRestaurante = new javax.swing.JComboBox<>();
        JpCentral = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPedido = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("MenuPedido");

        JpSuperior.setBackground(new java.awt.Color(138, 0, 58));

        jPanel1.setBackground(new java.awt.Color(138, 0, 58));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(138, 0, 58));
        jLabel1.setFont(new java.awt.Font("High Tower Text", 1, 24)); // NOI18N
        jLabel1.setText("Administracion de pedidios");
        jPanel1.add(jLabel1, java.awt.BorderLayout.LINE_END);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/rest.jpg"))); // NOI18N
        jPanel1.add(jLabel2, java.awt.BorderLayout.LINE_START);

        jPanel2.setBackground(new java.awt.Color(138, 0, 58));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel3.setBackground(new java.awt.Color(138, 0, 58));
        jLabel3.setText("  ");
        jPanel2.add(jLabel3, java.awt.BorderLayout.PAGE_START);

        jLabel4.setBackground(new java.awt.Color(138, 0, 58));
        jLabel4.setText("  ");
        jPanel2.add(jLabel4, java.awt.BorderLayout.LINE_START);

        jLabel5.setBackground(new java.awt.Color(138, 0, 58));
        jLabel5.setText("          ");
        jPanel2.add(jLabel5, java.awt.BorderLayout.LINE_END);

        jLabel6.setBackground(new java.awt.Color(138, 0, 58));
        jPanel2.add(jLabel6, java.awt.BorderLayout.PAGE_END);

        jPanel3.setBackground(new java.awt.Color(138, 0, 58));

        jTextField2.setBackground(new java.awt.Color(204, 204, 204));
        jTextField2.setText("Filtar por Codigo");
        jTextField2.setToolTipText("HOLA MUNDO");

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buscar.png"))); // NOI18N
        jButton3.setText("Buscar");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("MOSTRAR PEDIDOS: ");

        cbxMostrarPedido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbxMostrarPedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Enviados", "Enviados" }));
        cbxMostrarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMostrarPedidoActionPerformed(evt);
            }
        });

        lblRestaurante.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblRestaurante.setText("RESTAURANTE:");

        cbxRestaurante.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbxRestaurante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0" }));
        cbxRestaurante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxRestauranteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxMostrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRestaurante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbxMostrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRestaurante)
                    .addComponent(cbxRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout JpSuperiorLayout = new javax.swing.GroupLayout(JpSuperior);
        JpSuperior.setLayout(JpSuperiorLayout);
        JpSuperiorLayout.setHorizontalGroup(
            JpSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                .addContainerGap())
        );
        JpSuperiorLayout.setVerticalGroup(
            JpSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpSuperiorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(JpSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(JpSuperior, java.awt.BorderLayout.PAGE_START);

        JpCentral.setBackground(new java.awt.Color(204, 204, 204));
        JpCentral.setLayout(new java.awt.BorderLayout());

        jLabel7.setText("            ");
        JpCentral.add(jLabel7, java.awt.BorderLayout.LINE_START);

        jLabel8.setText("     ");
        JpCentral.add(jLabel8, java.awt.BorderLayout.PAGE_START);

        jLabel9.setText("    ");
        JpCentral.add(jLabel9, java.awt.BorderLayout.PAGE_END);

        jLabel10.setText("          ");
        JpCentral.add(jLabel10, java.awt.BorderLayout.LINE_END);

        tablaPedido.setBackground(new java.awt.Color(153, 153, 153));
        tablaPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Pedido", "Hora", "Direccion", "Total", "Estado", "Observaciones"
            }
        ));
        tablaPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPedidoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPedido);

        JpCentral.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(JpCentral, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPedidoMouseClicked
        // TODO add your handling code here:
        int columna=tablaPedido.getColumnModel().getColumnIndexAtX(evt.getX()); 
        
        if (columna==7) {
            int fila=evt.getY()/tablaPedido.getRowHeight();
            DefaultTableModel modelo = (DefaultTableModel) tablaPedido.getModel();
            
            List<Pedido> pedidos = service.getPedidos(cbxRestaurante.getSelectedIndex(), cbxMostrarPedido.getSelectedIndex());
            int codigo =-1;
            for (Pedido pedido : pedidos) {
                if (pedido.getPe_id()==Integer.parseInt(modelo.getValueAt(fila, 0).toString())) {
                    codigo = pedido.getPe_id();
                    byte estado = 1;
                    pedido.setPe_estado(estado);
                    service.updatePedido(codigo, pedido);
                }
            }
            
//            service.updatePedido(, pedido);
            successMessage("Se envio con exito el pedido con Codigo: "+codigo,"Estado Del Pedido");
            listarRegistro();
            
        }
    }//GEN-LAST:event_tablaPedidoMouseClicked

    private void cbxMostrarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMostrarPedidoActionPerformed
        // TODO add your handling code here:
        listarRegistro();
        
    }//GEN-LAST:event_cbxMostrarPedidoActionPerformed

    private void cbxRestauranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxRestauranteActionPerformed
        // TODO add your handling code here:
        listarRegistro();
    }//GEN-LAST:event_cbxRestauranteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpCentral;
    private javax.swing.JPanel JpSuperior;
    private javax.swing.JComboBox<String> cbxMostrarPedido;
    private javax.swing.JComboBox<String> cbxRestaurante;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblRestaurante;
    private javax.swing.JTable tablaPedido;
    // End of variables declaration//GEN-END:variables
}
