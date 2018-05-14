
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;




import entidade.Produto;
import java.util.Vector;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.ProdutoBR;

/**
 *
 * @author aluno
 */
public class frmProdutoCadastradoPesquisa extends javax.swing.JInternalFrame {
    
    private JDesktopPane principal;
    /**
     * Creates new form frmTipoAssociadoPesquisa
     */
    public frmProdutoCadastradoPesquisa() {
        initComponents();
        preencherTelaPerec();
    }
    
    public frmProdutoCadastradoPesquisa(JDesktopPane principal){
        this();
        this.principal = principal;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnFechar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblResultado = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setTitle("Pesquisa Produtos Cadastrados");

        btnFechar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        tblResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblResultadoMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblResultado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnFechar)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        try {
            frmCadastroProduto janela = new frmCadastroProduto(principal);
            principal.add(janela);
            janela.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }//GEN-LAST:event_btnFecharActionPerformed

    private void tblResultadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadoMousePressed
        try {
            int linha = tblResultado.getSelectedRow();
            String codigo = tblResultado.getValueAt(linha,0).toString();
            Produto produto = new ProdutoBR().consultar(
                                Integer.parseInt(codigo));
                        
            frmCadastroProduto janela = new frmCadastroProduto(principal, produto);
            principal.add(janela);
            janela.setVisible(true);
            this.dispose();
            
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(rootPane, e.getMessage());
                e.printStackTrace();
        }
    }//GEN-LAST:event_tblResultadoMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblResultado;
    // End of variables declaration//GEN-END:variables

    private void preencherTelaPerec() {
        try {
            
            Vector<String> cabecalho = new Vector<>();
            cabecalho.add("Código");
            cabecalho.add("Nome do Produto");
            cabecalho.add("Descrição");
            cabecalho.add("Valor Unitário");
            cabecalho.add("Categoria");
            cabecalho.add("Código de Busca");
            
            Vector detalhe = new Vector<>();
            new ProdutoBR().listar().forEach(produto -> {
                Vector<String> linha = new Vector<>();
                linha.add(produto.getId_prod()+ "");
                linha.add(produto.getNome());
                linha.add(produto.getDescricao());
                linha.add(produto.getValorUnitario()+"");
                linha.add(produto.getCategoria().getNome()+"");
                linha.add(produto.getCodigoBusca()+"");
                
                detalhe.add(linha);
            });
            tblResultado.setModel(new DefaultTableModel(detalhe, cabecalho));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    

}