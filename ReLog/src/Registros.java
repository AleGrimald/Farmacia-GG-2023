import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * @author Gavilan
 */
public class Registros extends javax.swing.JFrame {

    public Registros() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        CBP = new javax.swing.JComboBox<>();
        PanelApe = new javax.swing.JTextField();
        CBC = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        PanelMail = new javax.swing.JTextField();
        BConfReg = new javax.swing.JButton();
        PanelDNI = new javax.swing.JTextField();
        PanelUs = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        LCiu = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        LUser = new javax.swing.JLabel();
        LApellido = new javax.swing.JLabel();
        LNombre = new javax.swing.JLabel();
        BLogReg = new javax.swing.JButton();
        PanelNom = new javax.swing.JTextField();
        LProv = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        LClaC = new javax.swing.JLabel();
        PanelCla = new javax.swing.JPasswordField();
        PanelCel = new javax.swing.JTextField();
        LMAIL = new javax.swing.JLabel();
        LCEL = new javax.swing.JLabel();
        LCla = new javax.swing.JLabel();
        LDNI = new javax.swing.JLabel();
        PanelConfCla = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jTextField2.setText("jTextField2");

        setTitle("Farmacia G & G");
        setLocation(new java.awt.Point(50, 50));

        jDesktopPane2.setBackground(new java.awt.Color(255, 255, 255));

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

        CBP.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        CBP.setForeground(new java.awt.Color(51, 51, 51));
        CBP.setMaximumRowCount(25);
        CBP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una Provincia", "Buenos Aires", "CABA", "Catamarca", "Chaco", "Chubut", "Córdoba", "Corrientes", "Entre Ríos", "Formosa", "Jujuy", "La Pampa", "La Rioja", "Mendoza", "Misiones", "Neuquén", "Río Negro", "Salta", "San Juan", "San Luis", "Santa Cruz", "Santa Fe", "Santiago del Estero", "Tierrra del Fuego", "Tucumán" }));
        CBP.setToolTipText("");
        CBP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBPItemStateChanged(evt);
            }
        });

        PanelApe.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        PanelApe.setForeground(new java.awt.Color(51, 51, 51));
        PanelApe.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        PanelApe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PanelApeKeyTyped(evt);
            }
        });

        CBC.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        CBC.setForeground(new java.awt.Color(51, 51, 51));
        CBC.setMaximumRowCount(19);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Alejandro Grimaldi");

        PanelMail.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        PanelMail.setForeground(new java.awt.Color(51, 51, 51));
        PanelMail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        BConfReg.setBackground(new java.awt.Color(153, 177, 218));
        BConfReg.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        BConfReg.setText("Confirmar");
        BConfReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BConfRegActionPerformed(evt);
            }
        });

        PanelDNI.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        PanelDNI.setForeground(new java.awt.Color(51, 51, 51));
        PanelDNI.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        PanelDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PanelDNIKeyTyped(evt);
            }
        });

        PanelUs.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        PanelUs.setForeground(new java.awt.Color(51, 51, 51));

        jLabel8.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/farmacia.png"))); // NOI18N
        jLabel8.setText("Farmacia G & G");

        LCiu.setBackground(new java.awt.Color(255, 255, 255));
        LCiu.setFont(new java.awt.Font("Gadugi", 1, 20)); // NOI18N
        LCiu.setForeground(new java.awt.Color(255, 255, 255));
        LCiu.setText("Ciudad");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Galvan Gabriel");

        LUser.setBackground(new java.awt.Color(255, 255, 255));
        LUser.setFont(new java.awt.Font("Gadugi", 1, 20)); // NOI18N
        LUser.setForeground(new java.awt.Color(255, 255, 255));
        LUser.setText("Usuario");

        LApellido.setBackground(new java.awt.Color(255, 255, 255));
        LApellido.setFont(new java.awt.Font("Gadugi", 1, 20)); // NOI18N
        LApellido.setForeground(new java.awt.Color(255, 255, 255));
        LApellido.setText("Apellido");

        LNombre.setBackground(new java.awt.Color(255, 255, 255));
        LNombre.setFont(new java.awt.Font("Gadugi", 1, 20)); // NOI18N
        LNombre.setForeground(new java.awt.Color(255, 255, 255));
        LNombre.setText("Nombre");

        BLogReg.setBackground(new java.awt.Color(153, 177, 218));
        BLogReg.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        BLogReg.setText("Log In");
        BLogReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLogRegActionPerformed(evt);
            }
        });

        PanelNom.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        PanelNom.setForeground(new java.awt.Color(51, 51, 51));
        PanelNom.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        PanelNom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PanelNomKeyTyped(evt);
            }
        });

        LProv.setBackground(new java.awt.Color(255, 255, 255));
        LProv.setFont(new java.awt.Font("Gadugi", 1, 20)); // NOI18N
        LProv.setForeground(new java.awt.Color(255, 255, 255));
        LProv.setText("Provincia");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("(Sin puntos)");

        LClaC.setBackground(new java.awt.Color(255, 255, 255));
        LClaC.setFont(new java.awt.Font("Gadugi", 1, 20)); // NOI18N
        LClaC.setForeground(new java.awt.Color(255, 255, 255));
        LClaC.setText("Confirmar Clave");

        PanelCla.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        PanelCla.setForeground(new java.awt.Color(51, 51, 51));

        PanelCel.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        PanelCel.setForeground(new java.awt.Color(51, 51, 51));
        PanelCel.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        PanelCel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        PanelCel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PanelCelKeyTyped(evt);
            }
        });

        LMAIL.setBackground(new java.awt.Color(255, 255, 255));
        LMAIL.setFont(new java.awt.Font("Gadugi", 1, 20)); // NOI18N
        LMAIL.setForeground(new java.awt.Color(255, 255, 255));
        LMAIL.setText("E-Mail (Opcional)");

        LCEL.setBackground(new java.awt.Color(255, 255, 255));
        LCEL.setFont(new java.awt.Font("Gadugi", 1, 20)); // NOI18N
        LCEL.setForeground(new java.awt.Color(255, 255, 255));
        LCEL.setText("Tel-Cel");

        LCla.setBackground(new java.awt.Color(255, 255, 255));
        LCla.setFont(new java.awt.Font("Gadugi", 1, 20)); // NOI18N
        LCla.setForeground(new java.awt.Color(255, 255, 255));
        LCla.setText("Clave");

        LDNI.setBackground(new java.awt.Color(255, 255, 255));
        LDNI.setFont(new java.awt.Font("Gadugi", 1, 20)); // NOI18N
        LDNI.setForeground(new java.awt.Color(255, 255, 255));
        LDNI.setText("DNI");

        PanelConfCla.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        PanelConfCla.setForeground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Gadugi", 2, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("¿Ya está registrado?");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Proyecto, Taller de programación by:");

        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BIENVENIDO, AL SISTEMA DE REGISTRO DE EMPLEADO");

        jDesktopPane1.setLayer(CBP, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(PanelApe, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(CBC, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(PanelMail, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(BConfReg, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(PanelDNI, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(PanelUs, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(LCiu, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(LUser, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(LApellido, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(LNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(BLogReg, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(PanelNom, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(LProv, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(LClaC, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(PanelCla, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(PanelCel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(LMAIL, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(LCEL, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(LCla, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(LDNI, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(PanelConfCla, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(PanelMail, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                                .addComponent(LNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LCEL, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane1Layout.createSequentialGroup()
                                    .addComponent(LDNI)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel14))
                                .addComponent(LApellido, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(PanelNom, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(PanelApe, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(PanelDNI, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(PanelCel, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(LMAIL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(LUser)
                                .addGap(340, 340, 340))
                            .addComponent(LCla)
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(PanelCla, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(PanelUs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(LClaC)
                            .addComponent(PanelConfCla, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LProv)
                            .addComponent(LCiu)
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(CBC, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CBP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(106, 106, 106))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(93, 93, 93))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(339, 339, 339)
                .addComponent(jLabel1)
                .addContainerGap(418, Short.MAX_VALUE))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(474, 474, 474)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BLogReg, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(BConfReg, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel8)
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LUser, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LNombre))
                        .addGap(7, 7, 7)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PanelUs, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                            .addComponent(PanelNom))
                        .addGap(39, 39, 39)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LApellido)
                            .addComponent(LCla))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PanelCla, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                            .addComponent(PanelApe))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LDNI)
                            .addComponent(jLabel14)
                            .addComponent(LClaC))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PanelConfCla, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                            .addComponent(PanelDNI))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LCEL)
                            .addComponent(LProv))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CBP, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PanelCel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LMAIL)
                            .addComponent(LCiu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CBC, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PanelMail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(BConfReg, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BLogReg)
                .addGap(41, 41, 41)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5))))
        );

        jDesktopPane2.setLayer(jDesktopPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CBPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBPItemStateChanged
    if(evt.getStateChange() == ItemEvent.SELECTED)
    {
        if(this.CBP.getSelectedIndex()>0)
        {
            this.CBC.setModel(new DefaultComboBoxModel(getCiudades(this.CBP.getSelectedItem().toString())));
        }
    } //codigo para hacer que funcione como se espera el box
    }//GEN-LAST:event_CBPItemStateChanged

    private void BLogRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLogRegActionPerformed
    LogIn Redic= new LogIn();
    Redic.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_BLogRegActionPerformed

    private void BConfRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BConfRegActionPerformed
        //apartado mysql
        Server con = new Server();
        String Usuario=PanelUs.getText();
        String Clave=PanelCla.getText();
        int dni = Integer.parseInt(PanelDNI.getText()) ;
        String ConfClave=PanelConfCla.getText();
        Connection conexion = con.connect();
        String sql = "insert into empleado values(?,?,?)";


         if (!Usuario.isEmpty() && !Clave.isEmpty() && !ConfClave.isEmpty()) {
             try{            

                 PreparedStatement ps = conexion.prepareStatement(sql);
                 ps.setInt(1, dni);
                 ps.setString(2, Usuario);
                 ps.setString(3, Clave);
                 ps.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Datos guardados.");

             }catch (SQLException e){
                 JOptionPane.showMessageDialog(null, "Error, no se pudieron guardar los datos. \n Error: "+e);
             }


         }else{
             JOptionPane.showMessageDialog(null, "Formulario incompleto, rellene los campos necesarios.");
     }


     
    //apartado de txt.  
    char[] passwordChars = PanelCla.getPassword();
    String password = new String(passwordChars);

    char[] confirmarPasswordChars = PanelConfCla.getPassword();
    String confirmarPassword = new String(confirmarPasswordChars);

    if (PanelUs.getText().isEmpty() || password.isEmpty() || confirmarPassword.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Formulario incompleto, rellene los campos necesarios.");
    } 
        else {
            // Valida si las contraseñas coinciden
            if (password.equals(confirmarPassword)) {
                // Escribe los datos en el archivo de texto
                escribirDatosEnArchivo();
            
                // Abre la ventana de inicio de sesión
                LogIn login = new LogIn();
                login.setVisible(true);
                this.dispose();
        } 
                else {
                    JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden. Por favor, inténtelo de nuevo.");
                    // Si no coinciden las claves, se borran.
                    PanelCla.setText("");
                    PanelConfCla.setText("");
        }
    }
}

private void escribirDatosEnArchivo() {
    String usuario = PanelUs.getText();
    String clave = new String(PanelCla.getPassword());

    // Ruta del archivo de texto donde se guardarán los datos
    String rutaArchivo = "src/DatosUs.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
         // Escribi los datos en el archivo
         writer.write(usuario + "," + clave);
         writer.newLine();
        JOptionPane.showMessageDialog(this, "Registro correcto.");
         // Limpia los campos después del registro
         PanelUs.setText("");
         PanelCla.setText("");
         PanelConfCla.setText("");
        } 
            catch (IOException e) {
                e.printStackTrace(); // Manejo de errores
                JOptionPane.showMessageDialog(this, "No se pudo registrar, intentelo otra vez.");
        }
    }//GEN-LAST:event_BConfRegActionPerformed

    private void PanelDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PanelDNIKeyTyped
        char validar=evt.getKeyChar();
                if(Character.isLetter(validar)){
                getToolkit().beep();
                evt.consume();
                JOptionPane.showMessageDialog(PanelDNI,"Ingrese solo números");
                }
    }//GEN-LAST:event_PanelDNIKeyTyped

    private void PanelCelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PanelCelKeyTyped
    char validar=evt.getKeyChar();
                if(Character.isLetter(validar)){
                getToolkit().beep();
                evt.consume();
                JOptionPane.showMessageDialog(PanelCel,"Ingrese solo números");
                }
    }//GEN-LAST:event_PanelCelKeyTyped

    private void PanelNomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PanelNomKeyTyped
    char validar=evt.getKeyChar();
                if(Character.isDigit(validar)){//Permite que solo se puedan ingresar letras
                getToolkit().beep();
                evt.consume();
                JOptionPane.showMessageDialog(PanelNom,"Solo se permiten letras");
                }
    }//GEN-LAST:event_PanelNomKeyTyped

    private void PanelApeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PanelApeKeyTyped
    char validar=evt.getKeyChar();
                if(Character.isDigit(validar)){
                getToolkit().beep();
                evt.consume();
                JOptionPane.showMessageDialog(PanelApe,"Solo se permiten letras");
                }
    }//GEN-LAST:event_PanelApeKeyTyped
public String[] getCiudades(String provincia) //Este if hace que si seleccionas una provincia, se deslpiegue-
                                             //solo las ciudades de dicha provincia.
    {
        String[] Ciudades = new String[20];
        if(provincia.equalsIgnoreCase("Tucumán"))
        {
        Ciudades [0] = "Seleccione una Ciudad";  
        Ciudades [1] = "Aguilares";
        Ciudades [2] = "Alderete";
        Ciudades [3] = "Banda del Río Salí";
        Ciudades [4] = "Bella Vista";
        Ciudades [5] = "Burruyacú";
        Ciudades [6] = "Concepción";
        Ciudades [7] = "Famaillá";
        Ciudades [8] = "Graneros";
        Ciudades [9] = "Juan Bautista Alberdi";
        Ciudades [10] = "La Cocha";
        Ciudades [11] = "Las Talitas";
        Ciudades [12] = "Lules";
        Ciudades [13] = "Monteros";
        Ciudades [14] = "San Miguel de Tucumán";
        Ciudades [15] = "Simoca";
        Ciudades [16] = "Tafí del Valle";
        Ciudades [17] = "Tafí Viejo";
        Ciudades [18] = "Trancas";
        Ciudades [19] = "Yerba Buena";
        }    
        return Ciudades;
    } 
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BConfReg;
    private javax.swing.JButton BLogReg;
    private javax.swing.JComboBox<String> CBC;
    private javax.swing.JComboBox<String> CBP;
    private javax.swing.JLabel LApellido;
    private javax.swing.JLabel LCEL;
    private javax.swing.JLabel LCiu;
    private javax.swing.JLabel LCla;
    private javax.swing.JLabel LClaC;
    private javax.swing.JLabel LDNI;
    private javax.swing.JLabel LMAIL;
    private javax.swing.JLabel LNombre;
    private javax.swing.JLabel LProv;
    private javax.swing.JLabel LUser;
    private javax.swing.JTextField PanelApe;
    private javax.swing.JTextField PanelCel;
    private javax.swing.JPasswordField PanelCla;
    private javax.swing.JPasswordField PanelConfCla;
    private javax.swing.JTextField PanelDNI;
    private javax.swing.JTextField PanelMail;
    private javax.swing.JTextField PanelNom;
    private javax.swing.JTextField PanelUs;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
