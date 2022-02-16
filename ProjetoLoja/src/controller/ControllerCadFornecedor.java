package controller;

import static controller.ControllerCadCidade.codigo;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.bo.Cidade;
import model.bo.Fornecedor;
import service.CidadeService;
import service.FornecedorService;
import view.ModeloCadastros;
import view.TelaBusCidade;
import view.TelaCadFoneFornecedor;
import view.TelaCadFornecedor;

public class ControllerCadFornecedor implements ActionListener {

    TelaCadFornecedor telaCadFornecedor;
    public static int codigo;

    public ControllerCadFornecedor(TelaCadFornecedor telaCadFornecedor) {
        this.telaCadFornecedor = telaCadFornecedor;

        telaCadFornecedor.getjButtonBuscar().addActionListener(this);
        telaCadFornecedor.getjButtonNovo().addActionListener(this);
        telaCadFornecedor.getjButtonCancelar().addActionListener(this);
        telaCadFornecedor.getjButtonGravar().addActionListener(this);
        telaCadFornecedor.getjButtonSair().addActionListener(this);

        ativa(true);
        ligaDesliga(false);

    }

    public ControllerCadFornecedor(TelaCadFoneFornecedor TelaCadFoneFornecedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Nesse método controlamos o que fazer quando uma ação acontece
    //Não foram desenvolvidas ainda as funcionalidades de persistência
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaCadFornecedor.getjButtonNovo()) {
            ativa(false);
            ligaDesliga(true);
        } else if (acao.getSource() == telaCadFornecedor.getjButtonCancelar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadFornecedor.getjButtonGravar()) {
            
            Fornecedor fornecedor = new Fornecedor();
            
            fornecedor.setRazaoSocialFornecedor(this.telaCadFornecedor.getRazaoSocial().getText());
            fornecedor.setNome(this.telaCadFornecedor.getNomeFantasia().getText());
            fornecedor.setCnpjFornecedor(this.telaCadFornecedor.getCnpj().getText());
            fornecedor.setInscEstadualFornecedor(this.telaCadFornecedor.getInscEstadual().getText());
            fornecedor.setEmail(this.telaCadFornecedor.getEmail().getText());
            fornecedor.setCompleEndereco(this.telaCadFornecedor.getCompleEndereco().getText());
            //fornecedor.setEndereco_idcep(this.telaCadFornecedor);
            
            FornecedorService fornecedorService = new FornecedorService();
            fornecedorService.salvar(fornecedor);
            
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadFornecedor.getjButtonBuscar()) {
//            codigo = 0;
//            //chamada da tela da busca
//            TelaBusCidade telaBusCidade = new TelaBusCidade(null, true);
//            ControllerBusCidade controllerBusCidade = new ControllerBusCidade(telaBusCidade);
//            telaBusCidade.setVisible(true);
//
//            if (codigo != 0) {
//                Fornecedor fornecedor;
//                FornecedorService fornecedorService = new FornecedorService();
//                fornecedor = fornecedorService.buscar(codigo);
//
//                ativa(false);
//                ligaDesliga(true);
//
//                this.telaCadFornecedor.getj().setText(cidade.getIdCidade() + "");
//                this.telaCadFornecedor.getjTFNomeCidade().setText(cidade.getDescricaoCidade());
//                this.telaCadFornecedor.getjTFUF().setText(cidade.getUfCidade());
//
//                this.telaCadCidade.getjTFIdCidade().setEnabled(false);
//            }
        } else if (acao.getSource() == telaCadFornecedor.getjButtonSair()) {
	    this.telaCadFornecedor.dispose();
        }
    }

    //Método para habilitar/desabilitar botões(controle de estados)
    public void ativa(boolean estado) {
        telaCadFornecedor.getjButtonNovo().setEnabled(estado);
        telaCadFornecedor.getjButtonCancelar().setEnabled(!estado);
        telaCadFornecedor.getjButtonGravar().setEnabled(!estado);
        telaCadFornecedor.getjButtonBuscar().setEnabled(estado);
        telaCadFornecedor.getjButtonSair().setEnabled(estado);
    }

    //Método para Ativação/Desativação/Limpeza ds 
    //Componentes do jPanelDados
    public void ligaDesliga(boolean estado) {
        Component[] componentes = this.telaCadFornecedor.getjPanelDados().getComponents();
        for (Component componenteAtual : componentes) {
            if (componenteAtual instanceof JTextField) {
                ((JTextField) componenteAtual).setText("");
                componenteAtual.setEnabled(estado);
            } else if (componenteAtual instanceof JFormattedTextField) {
                ((JFormattedTextField) componenteAtual).setText("");
                componenteAtual.setEnabled(estado);
            } else if (componenteAtual instanceof JComboBox) {
                ((JComboBox) componenteAtual).setSelectedIndex(0);
                componenteAtual.setEnabled(estado);
            }
        }
    }
}
