import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class LogIn extends javax.swing.JFrame {
    
    public LogIn() {
        initComponents();
        LogUsEmp2.requestFocus();
        setLocationRelativeTo(null);
        this.setTitle("FARMACIA G&G - LOGIN");
        lblVisible.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        LogUsEmp2 = new javax.swing.JTextField();
        LogClaEmp2 = new javax.swing.JPasswordField();
        BLogGest2 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        BRegLog2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblOculto = new javax.swing.JLabel();
        lblVisible = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FARMACIA G&G - LOGIN");
        setResizable(false);

        jDesktopPane1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel15.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("BIENVENIDO AL SISTEMA DE FARMACIA");

        jLabel19.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/farmacia.png"))); // NOI18N
        jLabel19.setText("Farmacia G & G");
        jLabel19.setToolTipText("");

        LogUsEmp2.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        LogUsEmp2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        LogUsEmp2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LogUsEmp2.setMargin(new java.awt.Insets(2, 200, 2, 2));
        LogUsEmp2.setMaximumSize(new java.awt.Dimension(32, 29));

        LogClaEmp2.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        LogClaEmp2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LogClaEmp2.setMargin(new java.awt.Insets(2, 20, 2, 6));

        BLogGest2.setBackground(new java.awt.Color(153, 177, 218));
        BLogGest2.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        BLogGest2.setForeground(new java.awt.Color(51, 51, 51));
        BLogGest2.setText("Ingresar");
        BLogGest2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLogGestActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("¿No tienes cuenta?");

        BRegLog2.setBackground(new java.awt.Color(153, 177, 218));
        BRegLog2.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        BRegLog2.setForeground(new java.awt.Color(51, 51, 51));
        BRegLog2.setText("Registrarse");
        BRegLog2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRegLogActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/usuario.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/contrasena.png"))); // NOI18N

        lblOculto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/invisible.png"))); // NOI18N
        lblOculto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOcultoMouseClicked(evt);
            }
        });

        lblVisible.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/visible.png"))); // NOI18N
        lblVisible.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVisibleMouseClicked(evt);
            }
        });

        jDesktopPane1.setLayer(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel19, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(LogUsEmp2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(LogClaEmp2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(BLogGest2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel18, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(BRegLog2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lblOculto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lblVisible, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LogUsEmp2, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                            .addComponent(LogClaEmp2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblOculto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblVisible)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(0, 58, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(213, 213, 213))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BRegLog2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BLogGest2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(151, 151, 151))))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LogUsEmp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(55, 55, 55)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LogClaEmp2)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOculto)
                            .addComponent(lblVisible))))
                .addGap(55, 55, 55)
                .addComponent(BLogGest2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BRegLog2)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BLogGestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLogGestActionPerformed
        Server con = new Server(); //Objeto de la clase Server
        Connection conexion = con.connect(); //se abre la conexion a la base de datos
        Statement st; //variable que se encarga de la ejecucion de una sentencia
        String sql = "select * from empleado";//sentencia de ejecucion de base de datos
        String usuarioIngresado = LogUsEmp2.getText();
        String claveIngresada = LogClaEmp2.getText();
        

        try{
            st = conexion.createStatement();//se inicializa la sentencia en la base de datos
            ResultSet rs = st.executeQuery(sql);//se le asigna a un resultado lo que traiga de la ejecucion de sql
            boolean encontrado = false;
            
            while(rs.next()){   //rs recibe un array y lo recorre con next             
                if (usuarioIngresado.equals(rs.getString(2)) && claveIngresada.equals(rs.getString(3))) {
                    // En caso que los datos esten correctos
                    encontrado = true;
                    break;
                } 
            }
            
            if(encontrado){
                Gestor redic9 = new Gestor();
                redic9.setVisible(true);
                this.dispose();
            }else {
                // Si los datos no coinciden con los registros muestra este mensaje
                JOptionPane.showMessageDialog(this, "Usuario o clave incorrectos.\nPor favor, inténtelo de nuevo.");
                LogUsEmp2.setText("");
                LogClaEmp2.setText("");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "Error: "+e.toString());
        }
        
        con.desconnect();        
    }//GEN-LAST:event_BLogGestActionPerformed

    private void BRegLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRegLogActionPerformed
        Registros Redic2= new Registros();
        Redic2.setVisible(true);   //Esto redirecciona del boton registro de la ventana log a la ventana registro
        this.dispose();
    }//GEN-LAST:event_BRegLogActionPerformed

    private void lblOcultoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOcultoMouseClicked
        lblOculto.setVisible(false);
        lblVisible.setVisible(true);
        LogClaEmp2.setEchoChar((char)0);
    }//GEN-LAST:event_lblOcultoMouseClicked

    private void lblVisibleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVisibleMouseClicked
        lblOculto.setVisible(true);
        lblVisible.setVisible(false);
        LogClaEmp2.setEchoChar('*');
    }//GEN-LAST:event_lblVisibleMouseClicked
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BLogGest2;
    private javax.swing.JButton BRegLog2;
    private javax.swing.JPasswordField LogClaEmp2;
    private javax.swing.JTextField LogUsEmp2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblOculto;
    private javax.swing.JLabel lblVisible;
    // End of variables declaration//GEN-END:variables
}
