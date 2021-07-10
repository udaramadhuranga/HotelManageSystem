/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Udara
 */
public class ingridient extends javax.swing.JFrame {

    /**
     * Creates new form ingridient
     */
    public ingridient() {
        initComponents();
        Connect();
        setIngridientCode();
        tHeader();
    }
    
    Connection con;
    PreparedStatement pst;
    DefaultTableModel df;
    
   

    public void Connect(){
        
        
       
    
         
             try {
                 Class.forName("com.mysql.jdbc.Driver");
                 
                   con =DriverManager.getConnection("jdbc:mysql://localhost/itp","root","");
                 
             } catch (ClassNotFoundException ex) {
           
             } catch (SQLException ex) {
                 Logger.getLogger(ingridient.class.getName()).log(Level.SEVERE, null, ex);
             
          
       
    }
         }
    
    
           private void tHeader() {
   JTableHeader theader =  inventory.getTableHeader();
   
        theader.setFont(new Font("Segoe UI",Font.BOLD,15));
        theader.setForeground(Color.BLUE);
        theader.setBackground(Color.YELLOW);
    
    
    }
    
    
    public void load(){
    
        int a;
        try {
            pst =con.prepareStatement("select * from foodingridient");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rd = rs.getMetaData();
            
            a= rd.getColumnCount();
            df = (DefaultTableModel)inventory.getModel();
            df.setRowCount(0);
            tHeader();
            while(rs.next()){
            
                Vector v2 = new Vector();
                
                for(int i=1;i<a;i++){
                   v2.add(rs.getInt("ICode"));
                   //v2.add(rs.getString("ICode"));
                   
                    v2.add(rs.getString("name"));
                    
                   v2.add(rs.getInt("Quantity"));
                   //v2.add(rs.getString("Quantity"));
                   
                   
                   v2.add(rs.getInt("minimumQuantity"));
                 //  v2.add(rs.getString("minimumQuantity"));
                   
                   
                    v2.add(rs.getString("measuringunit"));
                    
                    v2.add(rs.getString("storingstate"));
                    
                    
                           
                }
                
                df.addRow(v2);
                        
            }
                
                    
                    } catch (SQLException ex) {
            Logger.getLogger(ingridient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
       public void load2(){
    
        int a;
        try {
            
            String ser =search.getText();
            
            pst =con.prepareStatement("select * from foodingridient where name like '"+ser+"%'");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rd = rs.getMetaData();
            
            a= rd.getColumnCount();
            df = (DefaultTableModel)inventory.getModel();
            df.setRowCount(0);
            
            while(rs.next()){
            
                Vector v2 = new Vector();
                
                for(int i=1;i<a;i++){
                   v2.add(rs.getInt("ICode"));
                   //v2.add(rs.getString("ICode"));
                   
                    v2.add(rs.getString("name"));
                    
                   v2.add(rs.getInt("Quantity"));
                   //v2.add(rs.getString("Quantity"));
                   
                   
                   v2.add(rs.getInt("minimumQuantity"));
                 //  v2.add(rs.getString("minimumQuantity"));
                   
                   
                    v2.add(rs.getString("measuringunit"));
                    
                    v2.add(rs.getString("storingstate"));
                    
                    
                           
                }
                
                df.addRow(v2);
                        
            }
                
                    
                    } catch (SQLException ex) {
            Logger.getLogger(ingridient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void setIngridientCode(){
    
        try {
            pst=con.prepareStatement("select Max(ICode) from  foodingridient " );
            ResultSet rs = pst.executeQuery();
            rs.next();
           // rs.getString("Max(ICode)");
          
            if(rs == null){
                
            
                code.setText(""+rs);
                
            }
            
            else{
            //Long id = Long.parseLong(rs.getString("Max(ICode)").substring(3,rs.getString("max(ICode)").length()));
            
            //id++;
           int id =rs.getInt("Max(ICode)");
           id++;
            code.setText(""+id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ingridient.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        code = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        Aqua = new javax.swing.JTextField();
        unit = new javax.swing.JTextField();
        mqua = new javax.swing.JTextField();
        meu = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        inventory = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        his = new javax.swing.JButton();
        restock = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        demo = new javax.swing.JButton();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setForeground(new java.awt.Color(0, 153, 153));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Ingridient code");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Ingridient");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Available quantity");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Minimum quantity");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("measuring unit");

        code.setEditable(false);
        code.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeActionPerformed(evt);
            }
        });
        code.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codeKeyReleased(evt);
            }
        });

        name.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameKeyReleased(evt);
            }
        });

        Aqua.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Aqua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AquaKeyReleased(evt);
            }
        });

        unit.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        unit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                unitKeyReleased(evt);
            }
        });

        mqua.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        mqua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mquaKeyReleased(evt);
            }
        });

        meu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kg", "L", "g", "ml", "Packets", "Bottles", "None" }));
        meu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(mqua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addComponent(Aqua, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                .addComponent(code, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(147, 147, 147))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(unit, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(meu, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(Aqua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mqua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(unit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(meu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );

        inventory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        inventory.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        inventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ingridient code", "Ingridient", "Available quantity", "Minimum quantity", "Measuring unit", "Storing state"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        inventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inventoryMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(inventory);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("showlist");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 141, Short.MAX_VALUE))
        );

        delete.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        update.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel6.setText("Inventory Managment");

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setText("Employee");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 153, 153));
        jButton4.setText("Home");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 153, 153));
        jButton5.setText("Inventory");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 153, 153));
        jButton6.setText("Hall Reservation");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(0, 153, 153));
        jButton7.setText("Order");

        jButton8.setBackground(new java.awt.Color(0, 153, 153));
        jButton8.setText("Payment");

        jButton9.setBackground(new java.awt.Color(0, 153, 153));
        jButton9.setText("Travel package");

        jButton10.setBackground(new java.awt.Color(0, 153, 153));
        jButton10.setText("Menu");

        jButton11.setBackground(new java.awt.Color(0, 153, 153));
        jButton11.setText("Expenses");

        jButton12.setBackground(new java.awt.Color(0, 153, 153));
        jButton12.setText("Room reservation");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .addComponent(jButton12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(216, Short.MAX_VALUE))
        );

        his.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        his.setText("used hostory");
        his.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hisActionPerformed(evt);
            }
        });

        restock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        restock.setText("running out ingridients");
        restock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restockActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("HOTEL ARONWAY");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(600, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(458, 458, 458))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        search.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("SEARCH");

        demo.setText("DEMO");
        demo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                demoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(demo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                                .addGap(54, 54, 54)
                                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(184, 184, 184)
                                .addComponent(restock, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(his, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(572, 572, 572))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(his)
                                .addComponent(restock))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(demo)))
                .addGap(323, 323, 323))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(222, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            String icode  = code.getText();
            String ing = name.getText();
            String quan = Aqua.getText();
            String miqua = mqua.getText();
            String uni = unit.getText();
            
            
            int co  = Integer.parseInt(icode);
            int qu =Integer.parseInt(quan);
            int mq = Integer.parseInt(miqua);
           
            
            pst =con.prepareStatement("insert into foodingridient(ICode ,name,Quantity,minimumQuantity,measuringunit) values(?,?,?,?,?)");
           
            
            pst.setInt(1, co);
         
            
            pst.setString(2, ing);
            pst.setInt(3, qu);
            
            pst.setInt(4, mq);
           
            
            pst.setString(5, uni);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Ingridient added succuessfully to the system");
            
            
            code.setText("");
            name.setText("");
            Aqua.setText("");
            mqua.setText("");
            unit.setText("");
            code.requestFocus();

             load();
             setIngridientCode();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ingridient.class.getName()).log(Level.SEVERE, null, ex);
            
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codeActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

        // TODO add your handling code here:
          df = (DefaultTableModel)inventory.getModel();
                 int selected =inventory.getSelectedRow();
                 
                 int id  =Integer.parseInt(df.getValueAt(selected,0).toString());
                 
                  
            String ing = name.getText();
            String quan = Aqua.getText();
            String miqua = mqua.getText();
            String uni = unit.getText();
            
            
            
            int qu =Integer.parseInt(quan);
            int mq = Integer.parseInt(miqua);
           
            
        try {
            pst =con.prepareStatement("update foodingridient set name=?,Quantity =?,minimumQuantity =?,	measuringunit=? where ICode =? ");
            
            
         
            
            pst.setString(1, ing);
            pst.setInt(2, qu);
            
            pst.setInt(3, mq);
            pst.setString(4, uni);
            pst.setInt(5, id);
           
            
           
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Ingridient updated succuessfully");
                        

            code.setText("");
            name.setText("");
            Aqua.setText("");
            mqua.setText("");
            unit.setText("");
            code.requestFocus();

             load();
             
             
             
               
            jButton2.setEnabled(true);
             
             
        } catch (SQLException ex) {
            Logger.getLogger(ingridient.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }//GEN-LAST:event_updateActionPerformed

    private void inventoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryMouseClicked
                // TODO add your handling code here:
                
                
                 df = (DefaultTableModel)inventory.getModel();
                 int selected =inventory.getSelectedRow();
                 
                 int id  =Integer.parseInt(df.getValueAt(selected,0).toString());
                 
                   code.setText(df.getValueAt(selected,0).toString());
            name.setText(df.getValueAt(selected,1).toString());
            Aqua.setText(df.getValueAt(selected,2).toString());
            mqua.setText(df.getValueAt(selected,3).toString());
            unit.setText(df.getValueAt(selected, 4).toString());
            
            jButton2.setEnabled(false);
                 
    }//GEN-LAST:event_inventoryMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
            load();
                 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
            
        // TODO add your handling code here:
          
                 df = (DefaultTableModel)inventory.getModel();
                 int selected =inventory.getSelectedRow();
                 
                 int id  =Integer.parseInt(df.getValueAt(selected,0).toString());
                 
        try {
            
            int combox= JOptionPane.showConfirmDialog(null,"Are you sure to delete this details?","Delete Confirmation",JOptionPane.YES_NO_OPTION );
             if(combox==JOptionPane.YES_OPTION)
            pst =con.prepareStatement("delete from foodingridient where ICode=? ");
        
                 pst.setInt(1, id);
           
            
            
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Ingridient deleted succuessfully");
                        

            code.setText("");
            name.setText("");
            Aqua.setText("");
            mqua.setText("");
            unit.setText("");
            code.requestFocus();

             load();
             setIngridientCode();
             jButton2.setEnabled(true);
        } catch (SQLException ex) {
            Logger.getLogger(ingridient.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
         
            
            
           
             
             
             
        
         
    }//GEN-LAST:event_deleteActionPerformed

    private void hisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hisActionPerformed
        // TODO add your handling code here:
        used u = new used();
        u.setVisible(true);
        
    }//GEN-LAST:event_hisActionPerformed

    private void restockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restockActionPerformed
        // TODO add your handling code here:
        
        runningout r = new runningout();
        r.setVisible(true);
    }//GEN-LAST:event_restockActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        NewJFrame i = new NewJFrame();
        i.setVisible(true);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
         ingridient i = new  ingridient();
        i.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
       HallReservation h = new HallReservation();
       h.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void codeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codeKeyReleased
        // TODO add your handling code here:
        
        String pattern = "^[0-9]{0,4}$";
        Pattern pt = Pattern.compile(pattern);
        
        Matcher match = pt.matcher(code.getText());
        
        if(!match.matches()){
            
                        JOptionPane.showMessageDialog(this, "Incorrect input ,you should enter  a number  between  0 -9999 ");
                        code.getText();
        
        
        }
    }//GEN-LAST:event_codeKeyReleased

    private void nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyReleased
        // TODO add your handling code here:
        
              
        String pattern = "^[a-zA-Z ]{0,20}$";
        Pattern pt = Pattern.compile(pattern);
        
        Matcher match = pt.matcher(name.getText());
        
        if(!match.matches()){
            
                        JOptionPane.showMessageDialog(this, "Incorrect input,Cannot enter numbers");
                        name.setText("");

        
        
        
        }
    }//GEN-LAST:event_nameKeyReleased

    private void AquaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AquaKeyReleased
        // TODO add your handling code here:
        
           String pattern = "^[0-9]{0,3}$";
        Pattern pt = Pattern.compile(pattern);
        
        Matcher match = pt.matcher(Aqua.getText());
        
        if(!match.matches()){
            
                        JOptionPane.showMessageDialog(this, "Incorrect input, enter only a number  between 0 and 1000");
                        
                        Aqua.setText("");

        
        
        
        }
    }//GEN-LAST:event_AquaKeyReleased

    private void mquaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mquaKeyReleased
        // TODO add your handling code here:
        
               String pattern = "^[0-9]{0,3}$";
        Pattern pt = Pattern.compile(pattern);
        
        Matcher match = pt.matcher(mqua.getText());
        
        if(!match.matches()){
            
                        JOptionPane.showMessageDialog(this, "Incorrect input, enter only a number  between 0 and 1000");
                        mqua.setText("");

    }//GEN-LAST:event_mquaKeyReleased
    }
    private void unitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unitKeyReleased
        // TODO add your handling code here:
                  
        String pattern = "^[a-zA-Z ]{0,15}$";
        Pattern pt = Pattern.compile(pattern);
        
        Matcher match = pt.matcher(unit.getText());
        
        if(!match.matches()){
            
                        JOptionPane.showMessageDialog(this, "Incorrect input,Cannot enter numbers");
                        
                        unit.setText("");

        
        
        
        }
    }//GEN-LAST:event_unitKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        dispose();
            Home h = new  Home();
        h.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        // TODO add your handling code here:
        load2();
    }//GEN-LAST:event_searchKeyReleased

    private void meuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meuActionPerformed
        // TODO add your handling code here:
        String selectunit = meu.getSelectedItem().toString();
        unit.setText(selectunit);
        
    }//GEN-LAST:event_meuActionPerformed

    private void demoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_demoActionPerformed
        // TODO add your handling code here:
          
            name.setText("Onion");
            Aqua.setText("10");
            mqua.setText("5");
            unit.setText("Kg");
            code.requestFocus();
    }//GEN-LAST:event_demoActionPerformed
    
    
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
            java.util.logging.Logger.getLogger(ingridient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ingridient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ingridient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ingridient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ingridient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Aqua;
    private javax.swing.JTextField code;
    private javax.swing.JButton delete;
    private javax.swing.JButton demo;
    private javax.swing.JButton his;
    private javax.swing.JTable inventory;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> meu;
    private javax.swing.JTextField mqua;
    private javax.swing.JTextField name;
    private javax.swing.JButton restock;
    private javax.swing.JTextField search;
    private javax.swing.JTextField unit;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
