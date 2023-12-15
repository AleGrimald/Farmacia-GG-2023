import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Venta extends javax.swing.JFrame {
    DefaultTableModel modelo;
    int cantidad;
    public Venta() {
        initComponents();
        setLocationRelativeTo(null);
        this.setTitle("FARMACIA G&G - GESTOR DE VENTAS");
        mostrarVenta();
        modelarTabla();
    }
    
    private void modelarTabla(){
        int[] ancho = {75, 350, 380, 200, 150, 150};

        for(int i=0; i<6; i++){
            dgvTablaVenta.getColumnModel().getColumn(i).setMaxWidth(ancho[i]);
            dgvTablaVenta.getColumnModel().getColumn(i).setResizable(false);
        }
        
        dgvTablaVenta.setFont(new Font("Gadugi", Font.PLAIN, 18));
    }
    
    private void mostrarVenta(){
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
        this.dgvTablaVenta.setModel(modelo);
        
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
    private void venderProducto(){
       
        if(!txtCodigoVenta.getText().isEmpty() &&
           !txtNombreVenta.getText().isEmpty() &&
           !txtPrecioVenta.getText().isEmpty() &&
           !txtCantidadVenta.getText().isEmpty()           
           )
        {
            int codigo =Integer.parseInt(txtCodigoVenta.getText()) ;
            cantidad = Integer.parseInt(txtCantidadVenta.getText());        
            int stockActual = Integer.parseInt(dgvTablaVenta.getValueAt(dgvTablaVenta.getSelectedRow(), 5).toString());
            int stockNuevo = stockActual - cantidad;
            ImageIcon icono = new  ImageIcon("src/recursos/accept.png");

            if(stockNuevo>=0 && cantidad>0){
                try{
                    Server con = new Server();
                    Connection conexion = con.connect();
                    String sql = "update productos set stock=? where codigo=?;";
                    PreparedStatement ps = conexion.prepareStatement(sql);                

                    ps.setInt(1,stockNuevo);
                    ps.setInt(2, codigo);
                    ps.executeUpdate();

                    con.desconnect();
                    JOptionPane.showMessageDialog(
                            rootPane,
                            "Producto: "+txtNombreVenta.getText()+"\n"+
                            "Precio x1: "+txtPrecioVenta.getText()+"\n"+
                            "Cantidad: "+txtCantidadVenta.getText()+"\n"+
                            "Total: "+txtTotalVenta.getText()+"\n",
                            "VENTA EXITOSA",
                            JOptionPane.OK_OPTION,
                            icono
                    );
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(
                            this,
                            "No pueden haber campos vacion.\nError: "+e.toString(),
                            "Sistema de Insercion de datos",
                            JOptionPane.INFORMATION_MESSAGE,
                            null
                    );
                }
            }else JOptionPane.showMessageDialog(rootPane,"No hay stock disponible.","Sistema de Ventas",JOptionPane.INFORMATION_MESSAGE, null);
            
        }else{
            JOptionPane.showMessageDialog(
                    rootPane,
                    "No pueden haber campos vacios.\n Revise el Formulario y vuelva a intentar.",
                    "Sistema de Ventas",
                    JOptionPane.WARNING_MESSAGE,
                    null
            );
        }
        mostrarVenta();
        limpiar();
    }
    public void limpiar(){
        txtCodigoVenta.setText("");
        txtNombreVenta.setText("");
        txtPrecioVenta.setText("");
        txtCantidadVenta.setText("");
        txtTotalVenta.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        dgvTablaVenta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtNombreVenta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCodigoVenta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCantidadVenta = new javax.swing.JTextField();
        lblTotalVenta = new javax.swing.JLabel();
        txtTotalVenta = new javax.swing.JTextField();
        btnTotalVenta = new javax.swing.JButton();
        btnCalcularVenta = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(800, 640));

        dgvTablaVenta = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column)
            {
                for(int i=0; i<dgvTablaVenta.getRowCount(); i++)
                {
                    if(row == i)
                    {
                        return false;
                    }
                }
                return true;
            }
        };
        dgvTablaVenta.setAutoCreateRowSorter(true);
        dgvTablaVenta.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        dgvTablaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {}
            },
            new String [] {

            }
        ));
        dgvTablaVenta.setRowHeight(40);
        dgvTablaVenta.setRowMargin(2);
        dgvTablaVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dgvTablaVentaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dgvTablaVenta);

        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre");

        txtNombreVenta.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        txtNombreVenta.setMargin(new java.awt.Insets(2, 20, 2, 2));

        jLabel2.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Codigo");

        txtCodigoVenta.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        txtCodigoVenta.setMargin(new java.awt.Insets(2, 20, 2, 2));

        jLabel3.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Precio");

        txtPrecioVenta.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        txtPrecioVenta.setMargin(new java.awt.Insets(2, 20, 2, 2));

        jLabel4.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cantidad");

        txtCantidadVenta.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        txtCantidadVenta.setMargin(new java.awt.Insets(2, 20, 2, 2));

        lblTotalVenta.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        lblTotalVenta.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalVenta.setText("Total a Pagar");
        lblTotalVenta.setEnabled(false);

        txtTotalVenta.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        txtTotalVenta.setEnabled(false);
        txtTotalVenta.setMargin(new java.awt.Insets(2, 20, 2, 2));

        btnTotalVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/carrito.png"))); // NOI18N
        btnTotalVenta.setEnabled(false);
        btnTotalVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalVentaActionPerformed(evt);
            }
        });

        btnCalcularVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/calcular.png"))); // NOI18N
        btnCalcularVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularVentaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/farmacia.png"))); // NOI18N
        jLabel6.setText("Farmacia G&G");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        btnCerrar.setBackground(new java.awt.Color(153, 177, 218));
        btnCerrar.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(51, 51, 51));
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtNombreVenta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtCodigoVenta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtPrecioVenta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtCantidadVenta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lblTotalVenta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtTotalVenta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnTotalVenta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnCalcularVenta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnCerrar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1310, Short.MAX_VALUE)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(txtNombreVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtCodigoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                            .addComponent(lblTotalVenta)
                                            .addGap(210, 210, 210))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                            .addComponent(txtTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                            .addComponent(btnTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(210, 210, 210))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                            .addComponent(txtCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                            .addComponent(btnCalcularVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(37, 37, 37)))))
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btnCerrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCalcularVenta)))
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNombreVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCodigoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(lblTotalVenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1340, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTotalVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalVentaActionPerformed
        venderProducto();
    }//GEN-LAST:event_btnTotalVentaActionPerformed

    private void dgvTablaVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dgvTablaVentaMouseClicked
        if(evt.getClickCount()==2){
            txtCodigoVenta.setText((String) modelo.getValueAt(dgvTablaVenta.getSelectedRow(), 0));
            txtNombreVenta.setText((String) modelo.getValueAt(dgvTablaVenta.getSelectedRow(), 1));
            txtPrecioVenta.setText((String) modelo.getValueAt(dgvTablaVenta.getSelectedRow(), 4));
        }
    }//GEN-LAST:event_dgvTablaVentaMouseClicked

    private void btnCalcularVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularVentaActionPerformed
        if(!txtPrecioVenta.getText().isEmpty() &&
           !txtNombreVenta.getText().isEmpty() &&
           !txtCodigoVenta.getText().isEmpty() &&
           !txtCantidadVenta.getText().isEmpty()
        ){
            float precio = Float.parseFloat(txtPrecioVenta.getText());
            cantidad = Integer.parseInt(txtCantidadVenta.getText());   
            precio = precio * cantidad;
            txtTotalVenta.setText(String.valueOf(precio));

            lblTotalVenta.setEnabled(true);
            txtTotalVenta.setEnabled(true);
            btnTotalVenta.setEnabled(true);
        }else JOptionPane.showMessageDialog(
                rootPane,
                "No puede haber campos vacios.\n Verifique la informacion.", "Sistema de Ventas",
                JOptionPane.INFORMATION_MESSAGE,
                null
            );
    }//GEN-LAST:event_btnCalcularVentaActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        Gestor gestor = new Gestor();
        gestor.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Venta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcularVenta;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnTotalVenta;
    private javax.swing.JTable dgvTablaVenta;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotalVenta;
    private javax.swing.JTextField txtCantidadVenta;
    private javax.swing.JTextField txtCodigoVenta;
    private javax.swing.JTextField txtNombreVenta;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtTotalVenta;
    // End of variables declaration//GEN-END:variables
}
