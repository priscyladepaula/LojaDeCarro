package view;

import controller.ProdutoController;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author priscyla.poliveira
 */
public class ProdutoView extends javax.swing.JFrame {

    /**
     * Creates new form ProdutoView
     */
    private String modoTela;
    
    public ProdutoView() {
        initComponents();
        
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Cadastro de Carros");
        
        DesabilitarFormulario();
        LoadTable();
    }
    
    public void LoadTable(){
        
        //Peço ao controller resgatar os clientes do banco de dados
        ArrayList<String[]> linhasProdutos = ProdutoController.getProdutos();
        
        //Opção 1 - Crio manualmente um modelo para a tabela e defino as colunas
        DefaultTableModel tmProdutos = new DefaultTableModel();
        tmProdutos.addColumn("ID");
        tmProdutos.addColumn("ANO");
        tmProdutos.addColumn("VALOR");
        tmProdutos.addColumn("MODELO");
        tabelaProduto.setModel(tmProdutos);
        
        //Para cada cliente resgatado do banco de dados, atualizo a tabela
        for(String[] p:linhasProdutos){
            tmProdutos.addRow(p);
        }
        
        //Defino o tamanho para cada coluna
        tabelaProduto.getColumnModel().getColumn(0).setPreferredWidth(70); //ID
        tabelaProduto.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabelaProduto.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabelaProduto.getColumnModel().getColumn(3).setPreferredWidth(150);
    }
    
    public void LimparFormulario(){
        IdTxt.setText("");
        AnoTxt.setText("");
        ValorTxt.setText("");
        ModeloTxt.setText("");
    }
    
    public void DesabilitarFormulario(){
        IdTxt.setEditable(false);
        AnoTxt.setEditable(false);
        ValorTxt.setEditable(false);
        ModeloTxt.setEditable(false);
        
        SaveButton.setEnabled(false);
        CancelButton.setEnabled(false);
    }
    
    public void HabilitarFormulario(){
        AnoTxt.setEditable(true);
        ValorTxt.setEditable(true);
        ModeloTxt.setEditable(true);
        
        SaveButton.setEnabled(true);
        CancelButton.setEnabled(true);
    }
    
    private boolean ValidarFormulario() {
        
        try {
            int ano = Integer.parseInt(this.AnoTxt.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,"Digite somente inteiros para o campo ano!");
            return false;
        }
        try {
            double valor = Double.parseDouble(this.ValorTxt.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,"Somente número em double para o campo ano!");
            return false;
        }
        
        if(this.AnoTxt.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this,"Defina um ano para o produto!");
            return false;
        }
        
        if(this.ValorTxt.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this,"Defina um valor para o produto!");
            return false;
        }
        
        if(this.ModeloTxt.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this,"Defina um modelo para o produto!");
            return false;
        }
        
        return true;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        IdTxt = new javax.swing.JTextField();
        AnoTxt = new javax.swing.JTextField();
        ValorTxt = new javax.swing.JTextField();
        ModeloTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProduto = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        NewButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de carros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 11), new java.awt.Color(153, 153, 153))); // NOI18N

        jLabel1.setText("ID:");

        jLabel2.setText("ANO:");

        jLabel3.setText("MODELO:");

        jLabel4.setText("VALOR:");

        IdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdTxtActionPerformed(evt);
            }
        });

        ValorTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValorTxtActionPerformed(evt);
            }
        });

        tabelaProduto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "ID", "ANO", "VALOR", "MODELO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaProduto);

        NewButton.setText("NOVO");
        NewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewButtonActionPerformed(evt);
            }
        });

        EditButton.setText("EDITAR");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        SaveButton.setText("SALVAR");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        DeleteButton.setText("EXCLUIR");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("CANCELAR");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NewButton)
                .addGap(18, 18, 18)
                .addComponent(EditButton)
                .addGap(18, 18, 18)
                .addComponent(SaveButton)
                .addGap(18, 18, 18)
                .addComponent(DeleteButton)
                .addGap(18, 18, 18)
                .addComponent(CancelButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewButton)
                    .addComponent(EditButton)
                    .addComponent(SaveButton)
                    .addComponent(DeleteButton)
                    .addComponent(CancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(IdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ModeloTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AnoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ValorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 103, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(IdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(AnoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ValorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ModeloTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IdTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdTxtActionPerformed
        // TODO add your handling code here:
        IdTxt.setEditable(false);
    }//GEN-LAST:event_IdTxtActionPerformed

    private void ValorTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValorTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ValorTxtActionPerformed

    private void NewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewButtonActionPerformed
        // TODO add your handling code here:
        modoTela = "Criar";
        HabilitarFormulario();
        LimparFormulario();
    }//GEN-LAST:event_NewButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        // TODO add your handling code here:
        //Verifico se há linhas para poder editar
        if(tabelaProduto.getRowCount()>0){
            //Verifico se o usuário selecionou alguma linha (Primeira linha = 0)
            if(tabelaProduto.getSelectedRow()>=0){
                HabilitarFormulario();
                IdTxt.setEditable(true);
                
                //Variável acessória para identifcar se o formulário está em modo de edição ou alteração
                modoTela = "Editar";

                //Atribuo os valores que estão na linha selecionada para a tabela
                IdTxt.setText(tabelaProduto.getModel().getValueAt(tabelaProduto.getSelectedRow(), 0).toString());
                AnoTxt.setText(tabelaProduto.getModel().getValueAt(tabelaProduto.getSelectedRow(), 1).toString());
                ValorTxt.setText(tabelaProduto.getModel().getValueAt(tabelaProduto.getSelectedRow(), 2).toString());
                ModeloTxt.setText(tabelaProduto.getModel().getValueAt(tabelaProduto.getSelectedRow(), 3).toString());
            }
            else{
                JOptionPane.showMessageDialog(this,"Selecione um produto para editar!");
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Não há produto para editar!");
        }
    }//GEN-LAST:event_EditButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        // TODO add your handling code here:
        if(ValidarFormulario()){
            if(modoTela.equals("Criar")){
                //Passo ao controller a entrada do usuário e peço para salvar no banco de dados
                if(ProdutoController.Salvar(Integer.parseInt(AnoTxt.getText()), Double.parseDouble(ValorTxt.getText()), ModeloTxt.getText())){
                    //Recarrego a tabela com os dados resgatados do banco de dados
                    this.LoadTable();
                    
                    JOptionPane.showMessageDialog(null,"Produto cadastrado com sucesso!");
                    LimparFormulario();
                }else{
                    JOptionPane.showMessageDialog(null,"Falha ao cadastrar produto!");
                }

            }else{
                //Passo ao controller a entrada do usuário e peço para atualizar o banco de dados
                if(ProdutoController.Atualizar(Integer.parseInt(IdTxt.getText()), Integer.parseInt(AnoTxt.getText()), Double.parseDouble(ValorTxt.getText()), ModeloTxt.getText())){
                    //Recarrego a tabela com os dados resgatados do banco de dados
                    this.LoadTable();
                    JOptionPane.showMessageDialog(this,"Produto atualizado com sucesso!");
                }else{
                    JOptionPane.showMessageDialog(this,"Falha ao atualizar produto!");
                }
            }

            LimparFormulario();
            DesabilitarFormulario();
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        // TODO add your handling code here:
        if(tabelaProduto.getRowCount()>0){
            int numeroLinha = tabelaProduto.getSelectedRow();
            if(ProdutoController.Excluir( Integer.parseInt(tabelaProduto.getValueAt(numeroLinha,0).toString()) ) ){
                this.LoadTable();
                JOptionPane.showMessageDialog(this,"Produto excluído da base de dados");
            }else{
                JOptionPane.showMessageDialog(this,"Falha ao excluir o produto!");
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Não há produtos para excluir!");
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        // TODO add your handling code here:
        DesabilitarFormulario();
        LimparFormulario();
    }//GEN-LAST:event_CancelButtonActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ProdutoView().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AnoTxt;
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JTextField IdTxt;
    private javax.swing.JTextField ModeloTxt;
    private javax.swing.JButton NewButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField ValorTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaProduto;
    // End of variables declaration//GEN-END:variables
}
