package co.mycompany.restaurante.cliente.presentacion;
import co.mycompany.restaurante.cliente.access.Factory;
import co.mycompany.restaurante.cliente.access.IRestauranteAccess;
import co.mycompany.restaurante.cliente.domain.TipoUser;
import co.mycompany.restaurante.cliente.domain.entity.Componente;
import co.mycompany.restaurante.cliente.domain.entity.Pedido;
import co.mycompany.restaurante.cliente.domain.entity.Restaurante;
import static co.mycompany.restaurante.cliente.infra.Messages.successMessage;
import static co.mycompany.restaurante.cliente.infra.Messages.warningMessage;
import co.mycompany.restaurante.cliente.infra.Security;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author kevith felipe bastidas
 */
public class GUIPagMenuPlato extends javax.swing.JInternalFrame {
    /**
     * atributo: referencia a la vista AgregarPlato
     */
    GUIPagAgregarPlato vistaAgregarPlato;
    /**
     * Instacia de la vistaPrincipal
     */
    private final GUIPagMenuRestaurante vistaMenuRestaurantes;
    /**
     * atributo: restaurante con el que trabaja la interfaz
     */
    private final Restaurante restaurante;
    /**
     * Constructor privado: new form GUIMenuPlato
     * @param restaurante
     * @param vistaMenuRestaurantes
     * @param vistaAgregarPlato
     */
    public GUIPagMenuPlato(Restaurante restaurante,GUIPagMenuRestaurante vistaMenuRestaurantes,GUIPagAgregarPlato vistaAgregarPlato) {       
        initComponents();
        setSize(1366,672);
        this.restaurante = restaurante;
        this.vistaMenuRestaurantes = vistaMenuRestaurantes;
        this.vistaAgregarPlato = vistaAgregarPlato;
        
        if (this.vistaMenuRestaurantes != null) {
            btnGenerarPedido.setEnabled(true);
        } else if (this.vistaAgregarPlato != null) {
            btnGenerarPedido.setEnabled(false);
        }
        this.listarDatos();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblDescripcion = new javax.swing.JTextPane();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        lblMensajeValorPlato = new javax.swing.JLabel();
        lblPrecioPlato = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        lblValorTotalPlatos2 = new javax.swing.JLabel();
        lblValorTotalPlatos = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lblValorDomicilio = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lblValorTotalPedido = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbxEntrada = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbxPrincipio = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbxProteina = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbxBebida = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        lblMensajeCantidad = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblDisminuirCantidad = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblAgregarCantidad = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblDatosDelRestaurante = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnGenerarPedido = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Menu Plato");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        lblImagen.setIcon(new javax.swing.ImageIcon("./src/main/java/resources/sincaratula.jpg"));
        jPanel1.add(lblImagen);

        jPanel7.setLayout(new java.awt.GridLayout(2, 0));

        jPanel8.setLayout(new java.awt.BorderLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("DESCRIPCION");
        jPanel8.add(jLabel5, java.awt.BorderLayout.NORTH);

        lblDescripcion.setEditable(false);
        jScrollPane2.setViewportView(lblDescripcion);

        jPanel8.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel8);

        jPanel9.setLayout(new java.awt.GridLayout(5, 0));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("PRECIO DEL PEDIDO");
        jPanel9.add(jLabel6);

        jPanel10.setLayout(new java.awt.GridLayout(1, 0));

        lblMensajeValorPlato.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMensajeValorPlato.setText("Valor por Plato:");
        jPanel10.add(lblMensajeValorPlato);

        lblPrecioPlato.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrecioPlato.setText("_");
        jPanel10.add(lblPrecioPlato);

        jPanel9.add(jPanel10);

        jPanel11.setLayout(new java.awt.GridLayout(1, 0));

        lblValorTotalPlatos2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblValorTotalPlatos2.setText("Valor Total Platos:");
        jPanel11.add(lblValorTotalPlatos2);

        lblValorTotalPlatos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValorTotalPlatos.setText("_");
        jPanel11.add(lblValorTotalPlatos);

        jPanel9.add(jPanel11);

        jPanel12.setLayout(new java.awt.GridLayout(1, 0));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Valor Domicilio: ");
        jPanel12.add(jLabel11);

        lblValorDomicilio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValorDomicilio.setText("_");
        jPanel12.add(lblValorDomicilio);

        jPanel9.add(jPanel12);

        jPanel13.setLayout(new java.awt.GridLayout(1, 0));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Valor Total Pedido: ");
        jPanel13.add(jLabel13);

        lblValorTotalPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValorTotalPedido.setText("_");
        jPanel13.add(lblValorTotalPedido);

        jPanel9.add(jPanel13);

        jPanel7.add(jPanel9);

        jPanel1.add(jPanel7);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new java.awt.GridLayout(10, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ENTRADA");
        jPanel2.add(jLabel1);

        cbxEntrada.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        cbxEntrada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion", "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxEntrada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbxEntrada.setNextFocusableComponent(cbxPrincipio);
        jPanel2.add(cbxEntrada);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PRINCIPIO");
        jPanel2.add(jLabel2);

        cbxPrincipio.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        cbxPrincipio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion", "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxPrincipio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(cbxPrincipio);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PROTEINA");
        jPanel2.add(jLabel3);

        cbxProteina.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        cbxProteina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion", "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxProteina.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(cbxProteina);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("BEBIDA");
        jPanel2.add(jLabel4);

        cbxBebida.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        cbxBebida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion", "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxBebida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(cbxBebida);

        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        lblMensajeCantidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMensajeCantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMensajeCantidad.setText("CANTIDAD: ");
        jPanel6.add(lblMensajeCantidad);

        jPanel2.add(jPanel6);

        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        lblDisminuirCantidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDisminuirCantidad.setIcon(new javax.swing.ImageIcon("./src/main/java/resources/menos.png"));
        lblDisminuirCantidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDisminuirCantidadMouseClicked(evt);
            }
        });
        jPanel5.add(lblDisminuirCantidad);

        lblCantidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCantidad.setText("0");
        jPanel5.add(lblCantidad);

        lblAgregarCantidad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAgregarCantidad.setIcon(new javax.swing.ImageIcon("./src/main/java/resources/mas.png"));
        lblAgregarCantidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregarCantidadMouseClicked(evt);
            }
        });
        jPanel5.add(lblAgregarCantidad);

        jPanel2.add(jPanel5);

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_START);

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblDatosDelRestaurante.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDatosDelRestaurante.setIcon(new javax.swing.ImageIcon("./src/main/java/resources/imagenPlato.png"));
        lblDatosDelRestaurante.setText("RESTAURANTE: NOMBRE");
        jPanel3.add(lblDatosDelRestaurante);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        btnGenerarPedido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGenerarPedido.setIcon(new javax.swing.ImageIcon("./src/main/java/resources/confirmar.png"));
        btnGenerarPedido.setText("Generar Pedido");
        btnGenerarPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPedidoActionPerformed(evt);
            }
        });
        jPanel4.add(btnGenerarPedido);

        btnVolver.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnVolver.setIcon(new javax.swing.ImageIcon("./src/main/java/resources/recibo-salida.png"));
        btnVolver.setText("Volver Menu Principal");
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel4.add(btnVolver);

        getContentPane().add(jPanel4, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Genera el pedido del cliente - En construccion
     * @param evt 
     */
    private void btnGenerarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPedidoActionPerformed
        // TODO add your handling code here:
        if (validarGenerarPedido()) {
            if (Security.usuario.getLogin()==TipoUser.VISITANTE) {
                warningMessage("Tiene que iniciar seccion....", "Atención");
                GUIPagLogin vistaLogin = new GUIPagLogin(this.vistaMenuRestaurantes.getVistaPrincipal(),this);
                vistaMenuRestaurantes.getVistaPrincipal().agregarComponente(vistaLogin);
                vistaLogin.show();
            }else{
                GUIPagPagos vistaPagos = new GUIPagPagos(this);
                this.vistaMenuRestaurantes.getVistaPrincipal().agregarComponente(vistaPagos);
                vistaPagos.show();
                //warningMessage("Se genero el pedido....", "Atención");
            }
            
        }else{
            warningMessage("Por Favor Complete Todos Los Campos....", "Atención");
        }
        
    }//GEN-LAST:event_btnGenerarPedidoActionPerformed
    
    public void generarPedido(String metodoDePago){
        IRestauranteAccess repo = Factory.getInstance().getRestauranteService();
        Pedido pedido = new Pedido();
        pedido.setUser_id(Security.usuario.getUser());
        byte estado = 0;
        pedido.setPe_estado(estado);
        int cantidad = Integer.parseInt(lblCantidad.getText());
        pedido.setPe_cantidad(cantidad);
        pedido.setComponentes(obtenerComponentesDelPlato());
        pedido.setRest_id(restaurante.getId());
        pedido.setPe_formapago(metodoDePago);
        pedido.setPe_precio(restaurante.getPlato().getPrecio());
        String result = repo.addPedido(pedido);
        String expResult = "Pedido añadido correctamente";
        if (result.equals(expResult)) {
            successMessage("Se genero el pedido con exito.\nSu pedido llegara en un tiempo promedio de acuerdo a su ubicacion","Pedido exitoso");
        }
        this.listarDatos();
        lblCantidad.setText(0 + "");
        calcularPrecio();
        System.out.println(pedido);
    }
    
    private List<Componente> obtenerComponentesDelPlato(){
        IRestauranteAccess repo = Factory.getInstance().getRestauranteService();
        List<Componente> lista = new ArrayList<>();
        List<Componente> componentes = repo.getComponentes();
        for (Componente componente : componentes) {
            switch (componente.getTipo()) {
                case ENTRADA: {
                    if (componente.getNombre().equals(cbxEntrada.getSelectedItem().toString())) {
                        lista.add(componente);
                    }
                    break;
                }
                case PRINCIPIO: {
                    if (componente.getNombre().equals(cbxPrincipio.getSelectedItem().toString())) {
                        lista.add(componente);
                    }
                    break;
                }
                case PROTEINA: {
                    if (componente.getNombre().equals(cbxProteina.getSelectedItem().toString())) {
                        lista.add(componente);
                    }
                    break;
                }
                case BEBIDA: {
                    if (componente.getNombre().equals(cbxBebida.getSelectedItem().toString())) {
                        lista.add(componente);
                    }
                    break;
                }
            }
        }
        return lista;
    }
    
    private boolean validarGenerarPedido(){
        int cantidad = Integer.parseInt(lblCantidad.getText());
        if (!cbxEntrada.getSelectedItem().toString().equals("Seleccione una opcion")
                && !cbxPrincipio.getSelectedItem().toString().equals("Seleccione una opcion")
                && !cbxProteina.getSelectedItem().toString().equals("Seleccione una opcion")
                && !cbxBebida.getSelectedItem().toString().equals("Seleccione una opcion")
                && cantidad>0) {
            return true;
        }else{
            return false;
        }
    }
    /**
     * se devuelve a la vista que creo la referencia
     */
    private void volverPaginaAnterior(){
        if (this.vistaMenuRestaurantes != null) {
//            btnGenerarPedido.setVisible(true);
            vistaMenuRestaurantes.getVistaPrincipal().agregarComponente(vistaMenuRestaurantes);
            this.dispose();
            vistaMenuRestaurantes.show();
        }else if(this.vistaAgregarPlato!=null){
//            btnGenerarPedido.setVisible(false);
            vistaAgregarPlato.getVistaPrincipal().agregarComponente(vistaAgregarPlato);
            this.dispose();
            vistaAgregarPlato.show();
        }
        
    }
    /**
     * Se devuelve a la interfaz principal y hace dispose a la interfaz actual
     * @param evt 
     */
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        volverPaginaAnterior();
        
    }//GEN-LAST:event_btnVolverActionPerformed
    
    private void calcularPrecio(){
        int cantidad = Integer.parseInt(lblCantidad.getText());
        if (cantidad>0) {
            lblPrecioPlato.setText(restaurante.getPlato().getPrecio()+"");
            int valorTotalPlatos = restaurante.getPlato().getPrecio()*cantidad;
            lblValorTotalPlatos2.setText("Valor Total Platos ("+cantidad+"):");
            lblValorTotalPlatos.setText(valorTotalPlatos+"");
            int valorDomicilio = 3000;
            lblValorDomicilio.setText(valorDomicilio+"");
            int valorTotalPedido = valorTotalPlatos+valorDomicilio;
            lblValorTotalPedido.setText(valorTotalPedido+"");
        }else{
            lblPrecioPlato.setText("_");
            lblValorTotalPlatos.setText("_");
            lblValorDomicilio.setText("_");
            lblValorTotalPedido.setText("_");
        }
    }
    
    /**
     * disminuye la cantidad de pedidos del plato
     */
    private void disminuirCantidadDePlatos(){
        int cantidad = Integer.parseInt(lblCantidad.getText());
        if (cantidad > 0) {
            cantidad--;
            lblCantidad.setText(cantidad + "");
        }        
    }
    /**
     * aumenta la cantidad de pedidos del plato
     */
    private void aumentarCantidadDePlatos(){
        int cantidad = Integer.parseInt(lblCantidad.getText());
        if (cantidad<10) {
            cantidad++;
            lblCantidad.setText(cantidad+"");
        }
        
    }
    /**
     * Aumenta la cantidad de platos y calcula el precio
     * @param evt 
     */
    private void lblAgregarCantidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarCantidadMouseClicked
        // TODO add your handling code here:
        aumentarCantidadDePlatos();
        calcularPrecio();
    }//GEN-LAST:event_lblAgregarCantidadMouseClicked
    /**
     * Disminuye la cantidad de platos y calcula el precio
     * @param evt 
     */
    private void lblDisminuirCantidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDisminuirCantidadMouseClicked
        // TODO add your handling code here:
        disminuirCantidadDePlatos();
        calcularPrecio();
    }//GEN-LAST:event_lblDisminuirCantidadMouseClicked

    
    
   /**
     * Lista los datos que maneja la interfaz actual
     * @param restaurante 
     */
    private void listarDatos() {
        
        if (Security.usuario.getLogin().name().equals("ADMINISTRADOR")) {
            btnVolver.setText("Volver A Editar El Plato");
            lblDatosDelRestaurante.setText("<html><b>VISTA PREVIA DEL PLATO EJECUTIVO</b></html>");
        } else {
            btnGenerarPedido.setVisible(true);
            btnVolver.setVisible(true);
            lblDatosDelRestaurante.setText("<html><b>RESTAURANTE:</b>"
                    + "    " + restaurante.getNombre() + "  <b>CIUDAD:</b>    " + restaurante.getCiudad() + "  <b>TELEFONO:</b>    "
                    + "" + restaurante.getTelefono() + "</html>");
        }
        lblImagen.setText("");
        int ancho = 420;
        lblImagen.setIcon(getImageIcon(getImagen(restaurante.getPlato().getUrl_imagen()), ancho, ancho));
        
        lblImagen.setSize(ancho, ancho);
        
        lblDescripcion.setText(restaurante.getPlato().getDescripcion());
        //ENTRADA
        cbxEntrada.removeAllItems();
        cbxEntrada.addItem("Seleccione una opcion");
        for (Componente componente : restaurante.getMenuSemanal()) 
            if (componente.getTipo().name().equals("ENTRADA")) 
                cbxEntrada.addItem(componente.getNombre());
        //PRINCIPIO
        cbxPrincipio.removeAllItems();
        cbxPrincipio.addItem("Seleccione una opcion");
        for (Componente componente : restaurante.getMenuSemanal()) 
            if (componente.getTipo().name().equals("PRINCIPIO")) 
                cbxPrincipio.addItem(componente.getNombre());
        //PROTEINA
        cbxProteina.removeAllItems();
        cbxProteina.addItem("Seleccione una opcion");
        for (Componente componente : restaurante.getMenuSemanal()) 
            if (componente.getTipo().name().equals("PROTEINA")) 
                cbxProteina.addItem(componente.getNombre());
        //BEBIDA
        cbxBebida.removeAllItems();
        cbxBebida.addItem("Seleccione una opcion");
        for (Componente componente : restaurante.getMenuSemanal())
            if (componente.getTipo().name().equals("BEBIDA"))
                cbxBebida.addItem(componente.getNombre());
    }
    /**
     * get un vector byte[] de una ruta especificada
     * @param pathname ruta de la imagen
     * @return -
     */
    private byte[] getImagen(String pathname) {
        File archivo = new File(pathname);
        byte[] image = new byte[(int) archivo.length()];
        try {
            FileInputStream entrada = new FileInputStream(archivo);
            entrada.read(image);
        } catch (Exception e) {
        }
        return image;
    }
    /**
     * convierte un vector de byte[] en una ImageIcon con un ancho y alto
     * especificado
     * @param imagenEnbyte
     * @param width
     * @param high
     * @return una ImageIcon
     */
    private ImageIcon getImageIcon(byte[] imagenEnbyte,int width,int height) {
        try {
            InputStream in = new ByteArrayInputStream(imagenEnbyte);
            BufferedImage image = ImageIO.read(in);
            ImageIcon img = new ImageIcon(image.getScaledInstance(width, height, 0));
            return img;
        } catch (Exception e) {
            try {
                InputStream in = new ByteArrayInputStream(getImagen("src/main/java/resources/sincaratula.jpg"));
                BufferedImage image = ImageIO.read(in);
                ImageIcon img = new ImageIcon(image.getScaledInstance(width, height, 0));
                return img;
            } catch (Exception e2) {
            }
            return null;
        }
    }
    
    public GUIPrincipal getVistaPrincipal(){
        return this.vistaMenuRestaurantes.getVistaPrincipal();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarPedido;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cbxBebida;
    private javax.swing.JComboBox<String> cbxEntrada;
    private javax.swing.JComboBox<String> cbxPrincipio;
    private javax.swing.JComboBox<String> cbxProteina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAgregarCantidad;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblDatosDelRestaurante;
    private javax.swing.JTextPane lblDescripcion;
    private javax.swing.JLabel lblDisminuirCantidad;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblMensajeCantidad;
    private javax.swing.JLabel lblMensajeValorPlato;
    private javax.swing.JLabel lblPrecioPlato;
    private javax.swing.JLabel lblValorDomicilio;
    private javax.swing.JLabel lblValorTotalPedido;
    private javax.swing.JLabel lblValorTotalPlatos;
    private javax.swing.JLabel lblValorTotalPlatos2;
    // End of variables declaration//GEN-END:variables
}
