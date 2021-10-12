package co.mycompany.restaurante.cliente.presentacion;

import co.mycompany.restaurante.cliente.domain.entity.Componente;
import co.mycompany.restaurante.cliente.domain.entity.TipoComponente;
import co.mycompany.restaurante.cliente.domain.patterncommand.CreateCommand;
import co.mycompany.restaurante.cliente.domain.patterncommand.DeleteCommand;
import co.mycompany.restaurante.cliente.domain.patterncommand.FindAllCommand;
import co.mycompany.restaurante.cliente.domain.patterncommand.FindByIdCommand;
import co.mycompany.restaurante.cliente.domain.patterncommand.Invoker;
import co.mycompany.restaurante.cliente.domain.patterncommand.UpdateCommand;
import javax.swing.table.DefaultTableModel;
import co.mycompany.restaurante.cliente.infra.Messages;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 * Interfaz gráfica de Consultar clientes
 * 
 * @author kevith Felipe Bastidas
 */
public class GUIPagAgregarComponentes extends javax.swing.JInternalFrame {

    /**
     * Instancia del invocador para poder enviar comandos al receptor
     * FoodService
     */
    private final Invoker invoker;
    
    /**
     * Constructor
     */
    public GUIPagAgregarComponentes() {
        invoker = new Invoker();
        initComponents();
        setSize(970, 520);
        loadDataTable();
        loadDataCombo();
        initStateButtons();
    }

    /**
     * Carga las comidas en el jTable
     */
    private void loadDataTable() {
        invoker.setCommand(new FindAllCommand());
        invoker.execute();
        FindAllCommand findAllCommand = (FindAllCommand) invoker.getCommand();

        List<Componente> components = findAllCommand.getComponentes();
        DefaultTableModel modelTable = (DefaultTableModel) tblData.getModel();
        clearData(modelTable);
        for (Componente component : components) {
            Object[] fila = new Object[3];
            fila[0] = component.getId();
            fila[1] = component.getNombre();
            fila[2] = component.getTipo().toString();
            modelTable.addRow(fila);
        }
        tblData.setRowHeight(30);
        tblData.getColumnModel().getColumn(1).setPreferredWidth(250);
    }
    /**
     * Elimina las filas del jTable
     *
     * @param modelTable modelo de datos del jTable
     */
    private void clearData(DefaultTableModel modelTable) {
        while (modelTable.getRowCount() > 0) {
            modelTable.removeRow(0);
        }
    }
    /**
     * Carga los tipos de comida en el jComboBox
     */
    private void loadDataCombo() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (TipoComponente ft : TipoComponente.values()) {
            model.addElement(ft);
        }
        cbxTipoComponente.setModel(model);
    }
    /**
     * Poner los botones en su estado inicial
     */
    private void initStateButtons() {
        btnAgregar.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        btnUndo.setEnabled(invoker.hasCommandUndo());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCentro = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblTipoComponente = new javax.swing.JLabel();
        cbxTipoComponente = new javax.swing.JComboBox<>();
        pnlSur = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUndo = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        pnlEste = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        pnlNorte = new javax.swing.JPanel();
        pnlTitiulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Agregar Componente");
        setPreferredSize(new java.awt.Dimension(764, 488));

        pnlCentro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlCentro.setLayout(new java.awt.GridLayout(3, 2));

        lblId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblId.setText("Id");
        pnlCentro.add(lblId);

        txtId.setPreferredSize(new java.awt.Dimension(150, 32));
        txtId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdFocusLost(evt);
            }
        });
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdKeyPressed(evt);
            }
        });
        pnlCentro.add(txtId);

        lblNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText("Nombre");
        pnlCentro.add(lblNombre);
        pnlCentro.add(txtName);

        lblTipoComponente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTipoComponente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTipoComponente.setText("Tipo Componente");
        pnlCentro.add(lblTipoComponente);

        cbxTipoComponente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbxTipoComponente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un tipo", "ENTRADA", "PRINCIPIO", "PROTEINA", "BEBIDA" }));
        cbxTipoComponente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbxTipoComponente.setEnabled(false);
        pnlCentro.add(cbxTipoComponente);

        getContentPane().add(pnlCentro, java.awt.BorderLayout.CENTER);

        pnlSur.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon("./src/main/java/resources/confirmar.png"));
        btnAgregar.setText("Agregar");
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.setEnabled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        pnlSur.add(btnAgregar);

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon("./src/main/java/resources/confirmar.png"));
        btnUpdate.setText("Modificar");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        pnlSur.add(btnUpdate);

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon("./src/main/java/resources/eliminar.png"));
        btnDelete.setText("Eliminar");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        pnlSur.add(btnDelete);

        btnUndo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUndo.setIcon(new javax.swing.ImageIcon("./src/main/java/resources/regreso.png"));
        btnUndo.setText("Deshacer");
        btnUndo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUndoActionPerformed(evt);
            }
        });
        pnlSur.add(btnUndo);

        btnClose.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClose.setIcon(new javax.swing.ImageIcon("./src/main/java/resources/recibo-salida.png"));
        btnClose.setText("Cerrar");
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        pnlSur.add(btnClose);

        getContentPane().add(pnlSur, java.awt.BorderLayout.SOUTH);

        pnlEste.setBorder(new javax.swing.border.MatteBorder(null));
        pnlEste.setLayout(new java.awt.BorderLayout());

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblData);

        pnlEste.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlEste, java.awt.BorderLayout.EAST);

        pnlNorte.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        pnlTitiulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlTitiulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTitulo.setIcon(new javax.swing.ImageIcon("./src/main/java/resources/imagenComponentes.png"));
        lblTitulo.setText("INGRESAR LOS DATOS DEL COMPONENTE");
        pnlTitiulo.add(lblTitulo);

        pnlNorte.add(pnlTitiulo);

        getContentPane().add(pnlNorte, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Controla el estado de los botones
     * @param evt 
     */
    private void txtIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusLost
        String strId = txtId.getText().trim();
        if (strId.isEmpty()) {
            return;
        }

        //Fija el comando del invoker para buscar comida por id 
        invoker.setCommand(new FindByIdCommand());
        //Pasa parámetros al comando
        FindByIdCommand findByIdCommand = (FindByIdCommand) invoker.getCommand();
        findByIdCommand.setComponenteId(Integer.parseInt(strId));
        //Ejecuta el comando
        invoker.execute();
        Componente food = findByIdCommand.getComponente();

        if (food == null) {
            //Agregar
            btnAgregar.setEnabled(true);
            btnUndo.setEnabled(false);
            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);
            cbxTipoComponente.setEnabled(true);
            txtName.setText("");
            cbxTipoComponente.setSelectedIndex(0);
        } else {
            //Editar
            cbxTipoComponente.setEnabled(true);
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            btnUndo.setEnabled(false);
            btnAgregar.setEnabled(false);
            txtName.setText(food.getNombre());
            int cont = 0;
            for (TipoComponente type : TipoComponente.values()) {
                if (food.getTipo().equals(type)) {
                    cbxTipoComponente.setSelectedIndex(cont++);
                }
                cont++;
            }
            //            cboType.setSelectedItem(food.getType().toString());
        }
    }//GEN-LAST:event_txtIdFocusLost
    /**
     * Valida el estado de la caja de texto name.
     * @param evt 
     */
    private void txtIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            txtIdFocusLost(null);
            txtName.requestFocus();
        }
    }//GEN-LAST:event_txtIdKeyPressed

   /**
     * Agrega un Componente valido.
     * @param evt 
     */
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        String name = txtName.getText();
        if (name.isEmpty()) {
            Messages.warningMessage("Debe agregar un nombre", "Atención");
            txtName.requestFocus();
            return;
        }

        int id = Integer.parseInt(txtId.getText());
        String type = cbxTipoComponente.getSelectedItem().toString();
        TipoComponente foodTpye = TipoComponente.valueOf(type);

        addComponente(id, name, foodTpye);

        Messages.successMessage("Comida agregada con éxito", "Atención");
        clearControls();
        initStateButtons();
        loadDataTable();
    }//GEN-LAST:event_btnAgregarActionPerformed
    /**
     * Llama a la logica de negocio para agregar comida mediante el comando
     *
     * @param id identificador de la comida
     * @param name nombre de la comida
     * @param type tipo de comida
     */
    private void addComponente(int id, String name, TipoComponente type) {
        Componente foodComponent = new Componente(id, name, type);

        //Fija el comando del invoker
        invoker.setCommand(new CreateCommand(foodComponent));
        //Ejecuta el comando
        invoker.execute();
    }
    /**
     * Actualiza el componente.
     * @param evt 
     */
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String name = txtName.getText();
        if (name.isEmpty()) {
            Messages.warningMessage("Debe agregar un nombre", "Atención");
            txtName.requestFocus();
            return;
        }
        // Preparar los datos
        int id = Integer.parseInt(txtId.getText());
        String type = cbxTipoComponente.getSelectedItem().toString();
        TipoComponente tipo = TipoComponente.valueOf(type);

        // Crea la comida con los nuevos datos
        Componente componente = new Componente(id, name, tipo);

        // Traer la comida previa
        invoker.setCommand(new FindByIdCommand());
        FindByIdCommand findByIdCommand = (FindByIdCommand) invoker.getCommand();
        findByIdCommand.setComponenteId(id);
        invoker.execute();
        //La comida previa debe crearse en una nueva instancia
        Componente compAux = findByIdCommand.getComponente();
        Componente previous = new Componente(compAux.getId(), compAux.getNombre(), compAux.getTipo());

        //Modifica la comida y guarda el previo
        updateComponente(componente, previous);
        
        clearControls();
        initStateButtons();
        loadDataTable();
    }//GEN-LAST:event_btnUpdateActionPerformed

    /**
     * Llama a la logica de negocio para modificar comida mediante el comando
     *
     * @param food comida a editar
     * @param previous comida antes de ser modificada
     */
    private void updateComponente(Componente componente, Componente previous) {
        //Fija el UpdateCommand
        invoker.setCommand(new UpdateCommand(componente));
        UpdateCommand updateCommand = (UpdateCommand) invoker.getCommand();
        //Fija al comida previa
        updateCommand.setFoodPrevious(previous);
        //Ejecuta el comando
        invoker.execute();
    }
    /**
     * elimina un componente y lo agrega a la pila de commands
     * @param evt 
     */
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String name = txtName.getText();
        if (name.isEmpty()) {
            Messages.warningMessage("Debe agregar un nombre", "Atención");
            txtName.requestFocus();
            return;
        }
        // Preparar los datos
        int id = Integer.parseInt(txtId.getText());
        String type = cbxTipoComponente.getSelectedItem().toString();
        TipoComponente foodTpye = TipoComponente.valueOf(type);

        // Crea la comida con los nuevos datos
        Componente componente = new Componente(id, name, foodTpye);

        // Traer la comida verdadera a eliminar
        invoker.setCommand(new FindByIdCommand());
        FindByIdCommand findByIdCommand = (FindByIdCommand) invoker.getCommand();
        findByIdCommand.setComponenteId(id);
        invoker.execute();
        //recupera la comida verdadera para poder validar que tenga los mismos datos
        Componente compAux = findByIdCommand.getComponente();
        if (compAux!=null) {
            if (compAux.getNombre().equals(name) && compAux.getTipo().name().equals(componente.getTipo().name())) {
                deleteComponente(componente);
            }else{
                return;
            }
        }else{
            return;
        }

        //Modifica la comida y guarda el previo

        Messages.successMessage("Comida eliminada con éxito", "Atención");
        clearControls();
        initStateButtons();
        loadDataTable();
    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * Llama a la logica de negocio para eliminar la comida mediante el comando
     *
     * @param food comida a eliminar
     */
    private void deleteComponente(Componente componente) {
        //Fija el UpdateCommand
        invoker.setCommand(new DeleteCommand(componente));
        //Ejecuta el comando
        invoker.execute();
    }
    /**
     * Button desaser: desase los ultimos cambios existentes.
     * @param evt 
     */
    private void btnUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUndoActionPerformed
        //Ejecuta el comando deshacer
        invoker.undo();
        loadDataTable();
        initStateButtons();
    }//GEN-LAST:event_btnUndoActionPerformed
    /**
     * Cierra la vista de la pagina principal
     * @param evt 
     */
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
        // TODO add your handling code here:
        int row = tblData.getSelectedRow();
        
        String id = tblData.getValueAt(row, 0).toString();
        String name = tblData.getValueAt(row, 1).toString();
        String type = tblData.getValueAt(row, 2).toString();

        
        cbxTipoComponente.setEnabled(true);
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
        btnUndo.setEnabled(false);
        btnAgregar.setEnabled(false);
        txtId.setText(id);
        txtName.setText(name);
        int cont = 0;
        for (TipoComponente tipo : TipoComponente.values()) {
            if (type.equals(tipo.name())) {
                cbxTipoComponente.setSelectedIndex(cont++);
            }
            cont++;
        }
    }//GEN-LAST:event_tblDataMouseClicked

    /**
     * Limpia las cajas de texto
     */
    public void clearControls() {
        txtId.setText("");
        txtName.setText("");
        cbxTipoComponente.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUndo;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbxTipoComponente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTipoComponente;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlEste;
    private javax.swing.JPanel pnlNorte;
    private javax.swing.JPanel pnlSur;
    private javax.swing.JPanel pnlTitiulo;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}