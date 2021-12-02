/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ControllerCadCidade;
import controller.ControllerCadBairro;
import controller.ControllerCadCliente;
import controller.ControllerCadCor;
import controller.ControllerCadFornecedor;
import controller.ControllerCadMarca;
import controller.ControllerCadProduto;
import controller.ControllerCadTamanho;
import controller.ControllerCadVendedor;


/**
 *
 * @author sharkcode
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
	initComponents();
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
        jMenuBar1 = new javax.swing.JMenuBar();
        Cadastros = new javax.swing.JMenu();
        Cidade = new javax.swing.JMenuItem();
        Bairro = new javax.swing.JMenuItem();
        Cliente = new javax.swing.JMenuItem();
        Vendedor = new javax.swing.JMenuItem();
        Fornecedor = new javax.swing.JMenuItem();
        Produto = new javax.swing.JMenuItem();
        Marca = new javax.swing.JMenuItem();
        Cor = new javax.swing.JMenuItem();
        Tamanho = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );

        Cadastros.setText("Cadastros");

        Cidade.setText("Cidade");
        Cidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CidadeActionPerformed(evt);
            }
        });
        Cadastros.add(Cidade);

        Bairro.setText("Bairro");
        Bairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BairroActionPerformed(evt);
            }
        });
        Cadastros.add(Bairro);

        Cliente.setText("Cliente");
        Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteActionPerformed(evt);
            }
        });
        Cadastros.add(Cliente);

        Vendedor.setText("Vendedor");
        Vendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VendedorActionPerformed(evt);
            }
        });
        Cadastros.add(Vendedor);

        Fornecedor.setText("Fornecedor");
        Fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FornecedorActionPerformed(evt);
            }
        });
        Cadastros.add(Fornecedor);

        Produto.setText("Produto");
        Produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdutoActionPerformed(evt);
            }
        });
        Cadastros.add(Produto);

        Marca.setText("Marca");
        Marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MarcaActionPerformed(evt);
            }
        });
        Cadastros.add(Marca);

        Cor.setText("Cor");
        Cor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CorActionPerformed(evt);
            }
        });
        Cadastros.add(Cor);

        Tamanho.setText("Tamanho");
        Tamanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TamanhoActionPerformed(evt);
            }
        });
        Cadastros.add(Tamanho);

        jMenuBar1.add(Cadastros);

        jMenu2.setText("Relatórios");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CidadeActionPerformed
        
        TelaCadCidade telaCadCidade = new TelaCadCidade();
        ControllerCadCidade controllerCadCidade = new ControllerCadCidade(telaCadCidade);
        telaCadCidade.setVisible(true);
        

    }//GEN-LAST:event_CidadeActionPerformed

    private void FornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FornecedorActionPerformed
        TelaCadFornecedor telaCadFornecedor = new TelaCadFornecedor();
        ControllerCadFornecedor controllerCadFornecedor = new ControllerCadFornecedor(telaCadFornecedor);
        telaCadFornecedor.setVisible(true);
    }//GEN-LAST:event_FornecedorActionPerformed

    private void CorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CorActionPerformed
        TelaCadCor telaCadCor = new TelaCadCor();
        ControllerCadCor controllerCadCor = new ControllerCadCor(telaCadCor);
        telaCadCor.setVisible(true);
    }//GEN-LAST:event_CorActionPerformed

    private void TamanhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TamanhoActionPerformed
        TelaCadTamanho telaCadTamanho = new TelaCadTamanho();
        ControllerCadTamanho controllerCadTamanho = new ControllerCadTamanho(telaCadTamanho);
        telaCadTamanho.setVisible(true);
    }//GEN-LAST:event_TamanhoActionPerformed

    private void BairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BairroActionPerformed
        TelaCadBairro telaCadBairro = new TelaCadBairro();
        ControllerCadBairro controllerCadBairro = new ControllerCadBairro(telaCadBairro);
        telaCadBairro.setVisible(true);
    }//GEN-LAST:event_BairroActionPerformed

    private void ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteActionPerformed
        TelaCadCliente telaCadCliente = new TelaCadCliente();
        ControllerCadCliente controllerCadCliente = new ControllerCadCliente(telaCadCliente);
        telaCadCliente.setVisible(true);
    }//GEN-LAST:event_ClienteActionPerformed

    private void VendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VendedorActionPerformed
        TelaCadVendedor telaCadVendedor = new TelaCadVendedor();
        ControllerCadVendedor controllerCadVendedor = new ControllerCadVendedor(telaCadVendedor);
        telaCadVendedor.setVisible(true);
    }//GEN-LAST:event_VendedorActionPerformed

    private void ProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdutoActionPerformed
        TelaCadProduto TelaCadProduto = new TelaCadProduto();
        ControllerCadProduto controllerCadProduto = new ControllerCadProduto(TelaCadProduto);
        TelaCadProduto.setVisible(true);
    }//GEN-LAST:event_ProdutoActionPerformed

    private void MarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MarcaActionPerformed
        TelaCadMarca TelaCadMarca = new TelaCadMarca();
        ControllerCadMarca controllerCadMarca = new ControllerCadMarca(TelaCadMarca);
        TelaCadMarca.setVisible(true);
    }//GEN-LAST:event_MarcaActionPerformed


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
	    java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		new MenuPrincipal().setVisible(true);
	    }
	});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Bairro;
    private javax.swing.JMenu Cadastros;
    private javax.swing.JMenuItem Cidade;
    private javax.swing.JMenuItem Cliente;
    private javax.swing.JMenuItem Cor;
    private javax.swing.JMenuItem Fornecedor;
    private javax.swing.JMenuItem Marca;
    private javax.swing.JMenuItem Produto;
    private javax.swing.JMenuItem Tamanho;
    private javax.swing.JMenuItem Vendedor;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}