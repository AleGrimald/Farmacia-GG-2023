import java.awt.Font;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Gestor extends javax.swing.JFrame {
    DefaultTableModel modelo;
    DefaultComboBoxModel modeloCmb; 

    public Gestor() {
        initComponents();
        setLocationRelativeTo(null);  
        
        mostrarTabla();
        modelarTabla();
        mostrarProv();
       
    }
    
    
    //METODOS PARA EL CRUD Y MODELADO DE TABLA
    
    private void modelarTabla(){
        int[] ancho = {65, 250, 330, 160, 100, 100};

        for(int i=0; i<6; i++){
            dgvTabla.getColumnModel().getColumn(i).setMaxWidth(ancho[i]);
            dgvTabla.getColumnModel().getColumn(i).setResizable(false);
        }
        
        dgvTabla.setFont(new Font("Gadugi", Font.PLAIN, 18));
        
        
    }
    private void mostrarTabla() {
        Server con = new Server();
        Connection conexion = con.connect();
        Statement st;
        String sql = "select * from productos";
        String [] datos = new String[6];

        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Proveedor");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        this.dgvTabla.setModel(modelo);
        
        try{
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                modelo.addRow(datos);
                
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "Error: "+e.toString());
        }
        
        con.desconnect();
        
        modelarTabla();
    }
    private void agregarTabla(){
        if(!txtCodigo.getText().isEmpty() &&
           !txtNombre.getText().isEmpty() &&
           !txtPrecio.getText().isEmpty() &&
           !txtStock.getText().isEmpty() &&
           !txtDescripcion.getText().isEmpty() &&
           !cbmProveedor.getSelectedItem().toString().isEmpty()
           )
        {
            int codigo =Integer.parseInt(txtCodigo.getText()) ;
            String nombre = txtNombre.getText();
            String descripcion = txtDescripcion.getText();
            String proveedor = cbmProveedor.getSelectedItem().toString();
            float precio = Float.parseFloat(txtPrecio.getText());
            int stock = Integer.parseInt(txtStock.getText());
            try{
                Server con = new Server();
                Connection conexion = con.connect();
                String sql = "insert into productos values(?,?,?,?,?,?); ";
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setInt(1, codigo);
                ps.setString(2, nombre);
                ps.setString(3, descripcion);
                ps.setString(4, proveedor);
                ps.setFloat(5, precio);
                ps.setInt(6, stock);
                ps.executeUpdate();

                con.desconnect();

            }catch(SQLException e){
                JOptionPane.showMessageDialog(
                        this,
                        "No pueden haber campos vacion.\nError: "+e.toString(),
                        "Sistema de Insercion de datos",
                        JOptionPane.INFORMATION_MESSAGE,
                        null
                );
            }
            
            limpiar();
            mostrarTabla();
        }else{
            JOptionPane.showMessageDialog(
                    rootPane,
                    "No pueden haber campos vacios.\n Revise el Formulario y vuelva a intentar.",
                    "Sistema de Insercion de datos",
                    JOptionPane.WARNING_MESSAGE,
                    null
            );
            
        }
        
    }
    private void modificarTabla(){

        if(!txtCodigo.getText().isEmpty() &&
           !txtNombre.getText().isEmpty() &&
           !txtPrecio.getText().isEmpty() &&
           !txtStock.getText().isEmpty() &&
           !txtDescripcion.getText().isEmpty() &&
           !cbmProveedor.getSelectedItem().toString().isEmpty()
           )
        {
            int codigo =Integer.parseInt(txtCodigo.getText()) ;
            String nombre = txtNombre.getText();
            String descripcion = txtDescripcion.getText();
            String proveedor = cbmProveedor.getSelectedItem().toString();
            float precio = Float.parseFloat(txtPrecio.getText());
            int stock = Integer.parseInt(txtStock.getText());
            try{
                Server con = new Server();
                Connection conexion = con.connect();
                String sql = "update productos set nombre=?, descripcion=?, proveedor=?, precio=?, stock=? where codigo=?;";
                PreparedStatement ps = conexion.prepareStatement(sql);                
                
                ps.setString(1, nombre);
                ps.setString(2, descripcion);
                ps.setString(3, proveedor);
                ps.setFloat(4, precio);
                ps.setInt(5, stock);
                ps.setInt(6, codigo);
                ps.executeUpdate();
                
                con.desconnect();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(
                    this, 
                    "No se pudo modificar el registro\n. Error: "+e.toString(),
                    "Sistema de Actualizacion de datos",   
                    JOptionPane.ERROR_MESSAGE, 
                    null
                );
            }
            
            limpiar();
            mostrarTabla();
        }else{
             JOptionPane.showMessageDialog(
                    rootPane,
                    "No pueden haber campos vacios.\n Revise el Formulario y vuelva a intentar.",
                    "Sistema de Actualizacion de datos",
                    JOptionPane.WARNING_MESSAGE,
                    null
            );
        }

    } 
    public void limpiar(){
        txtCodigo.setText("");
        txtNombre.setText("");
        txtDescripcion.setText("");
        cbmProveedor.setSelectedItem("");
        txtPrecio.setText("");
        txtStock.setText("");
    }
    public void eliminarTabla(){
        int fila = dgvTabla.getSelectedRow();
        
        if (fila >= 0) {
            try{
                Server con = new Server();
                Connection conexion = con.connect();
                String sql = "delete from productos where codigo = ?;";
                PreparedStatement ps = conexion.prepareStatement(sql);  

                ps.setInt(1, fila);
                ps.executeUpdate();

                con.desconnect();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(
                    this,
                    "No pueden haber campos vacion.\nError: "+e.toString(),
                    "Sistema de Insercion de datos",   
                    JOptionPane.INFORMATION_MESSAGE, 
                    null
                );
            }
        } else {
            JOptionPane.showMessageDialog(
                rootPane,
                "Seleccione la Fila que desea borrar",
                "Sistema de Borrado de datos",
                JOptionPane.INFORMATION_MESSAGE,
                null
            );
        }
        
        mostrarTabla();
        modelarTabla();
    }
    private void mostrarProv(){
        Server con = new Server();
        Connection conexion = con.connect();
        Statement st;
        String sql = "select * from proveedor";
        String [] datos = new String[200];
        
        modeloCmb = new DefaultComboBoxModel();
        modeloCmb.addElement("");
        this.cbmProveedor.setModel(modeloCmb);
        
        try{
            int cont=0;
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[cont]=rs.getString(1);
                modeloCmb.addElement(datos[cont]);
                cont++;
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "Error: "+e.toString());
        }
        con.desconnect();
    }
    private void agregarProv(){
        if(!cbmProveedor.getSelectedItem().toString().isEmpty())
        {
            String proveedor = cbmProveedor.getSelectedItem().toString();
            
            try{
                Server con = new Server();
                Connection conexion = con.connect();
                String sql = "insert into proveedor values(?); ";
                PreparedStatement ps = conexion.prepareStatement(sql);
                
                ps.setString(1, proveedor);
                ps.executeUpdate();

                con.desconnect();
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(
                        this,
                        "El Proveedor ya existe.\nError: "+e.toString(),
                        "Sistema de Insercion de Proveedor",
                        JOptionPane.INFORMATION_MESSAGE,
                        null
                );
            } 
        }else{
            JOptionPane.showMessageDialog(
                    rootPane,
                    "El campo proveedor no puede estar vacio.\n Verifique los datos y vuelva a intentar.",
                    "Sistema de Insercion de Proveedor",
                    JOptionPane.INFORMATION_MESSAGE,
                    null
            );
            
        }

        mostrarProv();
    }
    private void eliminarProv(){
        String fila = cbmProveedor.getSelectedItem().toString();
        
        if (!"".equals(fila)) {
            try{
                Server con = new Server();
                Connection conexion = con.connect();
                String sql = "delete from proveedor where nomProv = ?;";
                PreparedStatement ps = conexion.prepareStatement(sql);  

                ps.setString(1, fila);
                ps.executeUpdate();

                con.desconnect();
                mostrarProv();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(
                    this,
                    "No pueden haber campos vacion.\nError: "+e.toString(),
                    "Sistema de Insercion de datos",   
                    JOptionPane.INFORMATION_MESSAGE, 
                    null
                );
            }
        } else {
            JOptionPane.showMessageDialog(
                rootPane,
                "Seleccione el Proveedor que desea borrar.",
                "Sistema de Borrado de Proveedores",
                JOptionPane.INFORMATION_MESSAGE,
                null
            );
        }
    }
    private void buscarProd(){
        Server con = new Server();
        Connection conexion = con.connect();
        Statement st;
        int buscarCodigo = Integer.valueOf(txtBuscar.getText()) ;
        String sql = "select * from productos where codigo = "+buscarCodigo+";";
        String [] datos = new String[6];
        
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Proveedor");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        this.dgvTabla.setModel(modelo);
        
        try{
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                modelo.addRow(datos);
                
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "Error: "+e.toString());
        }
        
        con.desconnect();
        
    }
    //-----------------------------------------
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cbmProveedor = new javax.swing.JComboBox<>();
        txtDescripcion = new javax.swing.JTextField();
        btnAgregarProv = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btnEliminarProv = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dgvTabla = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FARMACIA G&G - GESTOR");
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/farmacia.png"))); // NOI18N
        jLabel1.setText("Farmacia G&G");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        btnAgregar.setBackground(new java.awt.Color(100, 255, 100));
        btnAgregar.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/agregar.png"))); // NOI18N
        btnAgregar.setText("  Agregar");
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        txtNombre.setMargin(new java.awt.Insets(2, 20, 2, 6));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/limpiar.png"))); // NOI18N
        btnLimpiar.setText("  Limpiar");
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nombre");

        cbmProveedor.setEditable(true);
        cbmProveedor.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N

        txtDescripcion.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        txtDescripcion.setMargin(new java.awt.Insets(2, 20, 2, 6));

        btnAgregarProv.setBackground(new java.awt.Color(100, 255, 100));
        btnAgregarProv.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        btnAgregarProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/agregar.png"))); // NOI18N
        btnAgregarProv.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProvActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Descripcion");

        btnEliminarProv.setBackground(new java.awt.Color(255, 100, 100));
        btnEliminarProv.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        btnEliminarProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/eliminar.png"))); // NOI18N
        btnEliminarProv.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProvActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Proveedor");

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        txtPrecio.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        txtPrecio.setMargin(new java.awt.Insets(2, 20, 2, 6));
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Codigo");

        jLabel13.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Precio de Lista");

        txtStock.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        txtStock.setMargin(new java.awt.Insets(2, 20, 2, 6));
        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Stock");

        dgvTabla = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column)
            {
                for(int i=0; i<dgvTabla.getRowCount(); i++)
                {
                    if(row == i)
                    {
                        return false;
                    }
                }
                return true;
            }
        };
        dgvTabla.setAutoCreateRowSorter(true);
        dgvTabla.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        dgvTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {}
            },
            new String [] {

            }
        ));
        dgvTabla.setRowHeight(40);
        dgvTabla.setRowMargin(2);
        dgvTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dgvTablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dgvTabla);

        jLabel8.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Lista de Productos");

        btnEliminar.setBackground(new java.awt.Color(255, 100, 100));
        btnEliminar.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/eliminar.png"))); // NOI18N
        btnEliminar.setText("  Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(255, 255, 100));
        btnModificar.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/editar.png"))); // NOI18N
        btnModificar.setText("  Modificar");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("BIENVENIDO, AL SISTEMA DE GESTION DE PRODUCTOS");

        jLabel9.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Registro de productos");

        btnLogOut.setBackground(new java.awt.Color(153, 177, 218));
        btnLogOut.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        btnLogOut.setForeground(new java.awt.Color(51, 51, 51));
        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/actualizar.png"))); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/cancelar.png"))); // NOI18N
        btnCancelar.setText(" Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(150, 150, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/buscar.png"))); // NOI18N
        btnBuscar.setBorder(null);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnAgregar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnLimpiar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(cbmProveedor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtDescripcion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnAgregarProv, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnEliminarProv, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtPrecio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel16, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtStock, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnEliminar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnModificar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnLogOut, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnActualizar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnCancelar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(506, 506, 506)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogOut))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                    .addGap(158, 158, 158)
                                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtStock, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                            .addComponent(jLabel16)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane1Layout.createSequentialGroup()
                                            .addComponent(cbmProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(26, 26, 26)
                                            .addComponent(btnAgregarProv, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                            .addComponent(btnEliminarProv, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnModificar)))))
                .addGap(43, 43, 43))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnLogOut))
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbmProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarProv, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarProv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(535, 535, 535)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //-------------------------------------------------------------------------
    
    //EVENTOS DE COMPONENTES Y VALIDACIONES DE DATOS    
    private void dgvTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dgvTablaMouseClicked
        JButton botonE = btnEliminar;
        JButton botonA = btnAgregar;
        JButton botonM = btnModificar;
        
        if(evt.getClickCount()==1 && dgvTabla.isEnabled()){
            botonE.setEnabled(true);
        }
        
        if(evt.getClickCount()==2){
            
            txtCodigo.setText((String) modelo.getValueAt(dgvTabla.getSelectedRow(), 0));
            txtNombre.setText((String) modelo.getValueAt(dgvTabla.getSelectedRow(), 1));
            txtDescripcion.setText((String) modelo.getValueAt(dgvTabla.getSelectedRow(), 2));
            cbmProveedor.setSelectedItem((String) modelo.getValueAt(dgvTabla.getSelectedRow(), 3));
            txtPrecio.setText((String) modelo.getValueAt(dgvTabla.getSelectedRow(), 4));
            txtStock.setText((String) modelo.getValueAt(dgvTabla.getSelectedRow(), 5));
            
            dgvTabla.setEnabled(false);
            botonM.setEnabled(true);
            botonE.setEnabled(false);
            botonA.setEnabled(false);
        }
    }//GEN-LAST:event_dgvTablaMouseClicked

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        int key = evt.getKeyChar();

        if((key >=48 && key <= 57) || key == 46 || key == 44){
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyTyped
        int key = evt.getKeyChar();

        if(!(key >=48 && key <= 57)){
            evt.consume();
        }
    }//GEN-LAST:event_txtStockKeyTyped

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        agregarTabla();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAgregarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProvActionPerformed
        agregarProv();

    }//GEN-LAST:event_btnAgregarProvActionPerformed

    private void btnEliminarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProvActionPerformed
        eliminarProv();
    }//GEN-LAST:event_btnEliminarProvActionPerformed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        int key = evt.getKeyChar();

        if(!(key >=48 && key <= 57)){
            evt.consume();
        }
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        int key = evt.getKeyChar();

        if(!((key >=48 && key <= 57) || key==44 || key==46)){
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarTabla();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        JButton botonA = btnAgregar;
        JButton botonM = btnModificar;
        
        modificarTabla();
        botonA.setEnabled(true);
        dgvTabla.setEnabled(true);
        botonM.setEnabled(false);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        LogIn login = new LogIn();
        
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        mostrarTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        JButton botonA = btnAgregar;
        JButton botonM = btnModificar;
        JButton botonE = btnEliminar;

        botonA.setEnabled(true);
        botonM.setEnabled(false);
        botonE.setEnabled(false);
        dgvTabla.setEnabled(true);
        mostrarTabla();
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if("".equals(txtBuscar.getText())){
            mostrarTabla();
        }else buscarProd();
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        
    }//GEN-LAST:event_txtBuscarActionPerformed
    
    
    //FUNCION PRINCIPAL MAIN
    public static void main(String args[]) throws IOException {       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Gestor().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarProv;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarProv;
    public javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLogOut;
    public javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cbmProveedor;
    private javax.swing.JTable dgvTabla;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables

}
