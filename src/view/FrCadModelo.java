/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Modelo;
import model.ModeloDao;

/**
 *
 * @author Computador
 */
public final class FrCadModelo extends javax.swing.JFrame {

    public FrCadModelo()throws SQLException {
        initComponents();
        controlarTela(1);
        setLocationRelativeTo(null);
        showTable();
    }
 public void showTable() throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) tbmodelo.getModel();
        modelo.setNumRows(0);
        ModeloDao mdao = new ModeloDao();
        for (Modelo m : mdao.read()) {
            modelo.addRow(new Object[]{
                m.getId(),
                m.getModelo(),
                m.getMarca(),
                m.getAno(),
    
            });
        }
    }
 
    public void showTableForName(String nome) throws SQLException{
    DefaultTableModel modelo = (DefaultTableModel)tbmodelo.getModel();
    modelo.setNumRows(0);
    ModeloDao mdao = new ModeloDao();
    for(Modelo m: mdao.readPesq(nome)){
    modelo.addRow(new Object[]{
    m.getId(), 
    m.getModelo(),
    m.getMarca(),
    m.getAno(),          
    });
    }
    }
 
 
 
 
 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbusuarios = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtiD = new javax.swing.JTextField();
        txtmodelo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtano = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btsalvar = new javax.swing.JButton();
        btalterar = new javax.swing.JButton();
        btexcluir = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtmarca = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbmodelo = new javax.swing.JTable();
        txtpesquisa = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btpesquisa = new javax.swing.JButton();
        btnovo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jButton4.setBackground(new java.awt.Color(102, 255, 51));
        jButton4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton4.setText("EXCLUIR");

        tbusuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "NOME", "E-MAIL", "SENHA", "TIPO"
            }
        ));
        tbusuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbusuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbusuarios);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modelo");

        jPanel1.setBackground(new java.awt.Color(255, 204, 255));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("ID");

        txtiD.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtiD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtiDActionPerformed(evt);
            }
        });

        txtmodelo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtmodelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmodeloActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Modelo");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Marca");

        txtano.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtanoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Ano");

        btsalvar.setBackground(new java.awt.Color(102, 255, 51));
        btsalvar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btsalvar.setText("SALVAR");
        btsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsalvarActionPerformed(evt);
            }
        });

        btalterar.setBackground(new java.awt.Color(51, 255, 255));
        btalterar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btalterar.setText("ALTERAR");
        btalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btalterarActionPerformed(evt);
            }
        });

        btexcluir.setBackground(new java.awt.Color(255, 51, 51));
        btexcluir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btexcluir.setText("EXCLUIR");
        btexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btexcluirActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(51, 51, 51));
        jButton5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton5.setText("LIMPAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txtmarca.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtmarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmarcaActionPerformed(evt);
            }
        });

        tbmodelo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "ID", "MODELO", "MARCA", "ANO"
            }
        ));
        tbmodelo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbmodeloMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbmodelo);

        txtpesquisa.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtpesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpesquisaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Marca");

        btpesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/lupa.png"))); // NOI18N
        btpesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btpesquisaActionPerformed(evt);
            }
        });

        btnovo.setBackground(new java.awt.Color(0, 0, 204));
        btnovo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnovo.setText("novo");
        btnovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtano, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtiD, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btpesquisa))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(btsalvar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btalterar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btexcluir)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnovo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtmarca, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtiD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btsalvar)
                    .addComponent(btalterar)
                    .addComponent(btexcluir)
                    .addComponent(jButton5)
                    .addComponent(btnovo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btpesquisa))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Cadastro do modelo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void limparCampos(){
            txtiD.setText(null);
            txtmodelo.setText(null);
            txtmarca.setText(null);
            txtano.setText(null);
                        
  } 
   public void controlarTela(int op) {
        if (op == 1) { //quando inicializado o formulario pela primeira vez
            txtiD.setEnabled(false);
            txtmodelo.setEnabled(false);
            txtmarca.setEnabled(false);
            txtano.setEnabled(false);
            
           

            btsalvar.setEnabled(false);
            btexcluir.setEnabled(false);
            btalterar.setEnabled(false);
            btnovo.setEnabled(true);
            
        }else if(op==2){ //quando clicado o botão novo
            txtiD.setEnabled(false);
            txtmodelo.setEnabled(true);
            txtmarca.setEnabled(true);
            txtano.setEnabled(true);
            
           
           
            btsalvar.setEnabled(true);
            btexcluir.setEnabled(false);
            btalterar.setEnabled(false);
            btnovo.setEnabled(false);
            txtmodelo.requestFocus();
            limparCampos();
            
        }else if(op==3){
             
            txtmodelo.setEnabled(true);
            txtmarca.setEnabled(true);
            txtano.setEnabled(true);
            
           
           
            btsalvar.setEnabled(false);
            btexcluir.setEnabled(true);
            btalterar.setEnabled(true);
            btnovo.setEnabled(true);
            
        }

    } 
     private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Modelo m = new Modelo();
        m.setModelo(txtmodelo.getText());
        m.setMarca(txtmarca.getText());
        m.setAno(Integer.parseInt(txtano.getText()));     
        

        try {
            ModeloDao mdao = new ModeloDao();
            mdao.create(m);
            showTable();
            controlarTela(1);
            limparCampos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
        }
     }
    private void tbusuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbusuariosMouseClicked
        txtiD.setEnabled(true);
        txtmodelo.setEnabled(true);
        txtmarca.setEnabled(true);
        txtano.setEnabled(true);
      
        
        
        if(tbmodelo.getSelectedRow()!= -1){
            
            txtiD.setText(tbmodelo.getValueAt(tbmodelo.getSelectedRow(), 0)
                .toString());
            txtmodelo.setText(tbmodelo.getValueAt(tbmodelo.getSelectedRow(), 1)
                .toString());
              txtmarca.setText(tbmodelo.getValueAt(tbmodelo.getSelectedRow(), 2)
                .toString());
            txtano.setText(tbmodelo.getValueAt(tbmodelo.getSelectedRow(), 3)
                .toString());
          
             

            btsalvar.setEnabled(false);
            btalterar.setEnabled(true);
            btexcluir.setEnabled(true);
        }

    }//GEN-LAST:event_tbusuariosMouseClicked

    private void btnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnovoActionPerformed
        controlarTela(2);
    }//GEN-LAST:event_btnovoActionPerformed

    private void btpesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btpesquisaActionPerformed

        try {
            showTableForName(txtpesquisa.getText());
        } catch (SQLException ex) {
            Logger.getLogger(FrcadUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btpesquisaActionPerformed

    private void txtpesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpesquisaActionPerformed

    private void tbmodeloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbmodeloMouseClicked
        if(tbmodelo.getSelectedRow()!= -1){
            txtiD.setText(tbmodelo .getValueAt(tbmodelo.getSelectedRow(), 0)
                .toString());
            txtmodelo.setText(tbmodelo.getValueAt(tbmodelo.getSelectedRow(), 1)
                .toString());
            txtmarca.setText(tbmodelo.getValueAt(tbmodelo.getSelectedRow(), 2)
                .toString());
            txtano.setText(tbmodelo.getValueAt(tbmodelo.getSelectedRow(), 3)
                .toString());
            
          

            btsalvar.setEnabled(false);
            btalterar.setEnabled(true);
            btexcluir.setEnabled(true);
        }
    }//GEN-LAST:event_tbmodeloMouseClicked

    private void txtmarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmarcaActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btexcluirActionPerformed
        Modelo m = new Modelo();
        m.setId(Integer.parseInt(txtiD.getText()));
        ModeloDao mdao;
        try {
            mdao = new ModeloDao();
            mdao.delete(m);
            showTable();
            controlarTela(1);
            limparCampos();
        } catch (SQLException ex) {
            Logger.getLogger(FrCadUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btexcluirActionPerformed

    private void btalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btalterarActionPerformed
        Modelo m = new Modelo();
        m.setId(Integer.parseInt(txtiD.getText()));
        m.setModelo(txtmodelo.getText());
        m.setMarca(txtmarca.getText());
        m.setAno(Integer.parseInt(txtano.getText()));
       

        ModeloDao mdao;
        try {
            mdao = new ModeloDao();
            mdao.update(m);
            showTable();
            controlarTela(1);
        } catch (SQLException ex) {
            Logger.getLogger(FrcadUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btalterarActionPerformed

    private void btsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsalvarActionPerformed
        Modelo m = new Modelo();
        m.setModelo(txtmodelo.getText());
        m.setMarca(txtmarca.getText());
        m.setAno(Integer.parseInt(txtano.getText()));

        try {
            ModeloDao mdao = new ModeloDao();
            mdao.create(m);
            showTable();
            controlarTela(1);
            limparCampos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
        }
    }//GEN-LAST:event_btsalvarActionPerformed

    private void txtanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtanoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtanoActionPerformed

    private void txtmodeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmodeloActionPerformed

    }//GEN-LAST:event_txtmodeloActionPerformed

    private void txtiDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtiDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtiDActionPerformed

 
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
            java.util.logging.Logger.getLogger(FrCadModelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrCadModelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrCadModelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrCadModelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrCadModelo().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrCadModelo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btalterar;
    private javax.swing.JButton btexcluir;
    private javax.swing.JButton btnovo;
    private javax.swing.JButton btpesquisa;
    private javax.swing.JButton btsalvar;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbmodelo;
    private javax.swing.JTable tbusuarios;
    private javax.swing.JTextField txtano;
    private javax.swing.JTextField txtiD;
    private javax.swing.JTextField txtmarca;
    private javax.swing.JTextField txtmodelo;
    private javax.swing.JTextField txtpesquisa;
    // End of variables declaration//GEN-END:variables


    private static class FrCadUsuario {

        public FrCadUsuario() {
        }
    }
}
   
  
