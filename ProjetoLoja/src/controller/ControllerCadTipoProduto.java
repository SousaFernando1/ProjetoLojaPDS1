package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.bo.TipoProduto;
import service.TipoProdutoService;
import view.ModeloCadastros;
import view.TelaCadCondicaoPagamento;
import view.TelaCadFornecedor;
import view.TelaCadTipoProduto;

public class ControllerCadTipoProduto implements ActionListener {

    TelaCadTipoProduto telaCadTipoProduto;

    public ControllerCadTipoProduto(TelaCadTipoProduto telaCadTipoProduto) {
        this.telaCadTipoProduto = telaCadTipoProduto;

        telaCadTipoProduto.getjButtonBuscar().addActionListener(this);
        telaCadTipoProduto.getjButtonNovo().addActionListener(this);
        telaCadTipoProduto.getjButtonCancelar().addActionListener(this);
        telaCadTipoProduto.getjButtonGravar().addActionListener(this);
        telaCadTipoProduto.getjButtonSair().addActionListener(this);

        ativa(true);
        ligaDesliga(false);

    }

    //Nesse método controlamos o que fazer quando uma ação acontece
    //Não foram desenvolvidas ainda as funcionalidades de persistência
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaCadTipoProduto.getjButtonNovo()) {
            ativa(false);
            ligaDesliga(true);
        } else if (acao.getSource() == telaCadTipoProduto.getjButtonCancelar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadTipoProduto.getjButtonGravar()) {
	    TipoProduto tipoProduto = new TipoProduto();
            
            tipoProduto.setDescricaoTipoProduto(this.telaCadTipoProduto.getjTFDescricaoTipoProduto().getText());  


            TipoProdutoService tipoProdutoService = new TipoProdutoService();
            tipoProdutoService.salvar(tipoProduto);


            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadTipoProduto.getjButtonBuscar()) {
        } else if (acao.getSource() == telaCadTipoProduto.getjButtonSair()) {
	    this.telaCadTipoProduto.dispose();
        }
    }

    //Método para habilitar/desabilitar botões(controle de estados)
    public void ativa(boolean estado) {
        telaCadTipoProduto.getjButtonNovo().setEnabled(estado);
        telaCadTipoProduto.getjButtonCancelar().setEnabled(!estado);
        telaCadTipoProduto.getjButtonGravar().setEnabled(!estado);
        telaCadTipoProduto.getjButtonBuscar().setEnabled(estado);
        telaCadTipoProduto.getjButtonSair().setEnabled(estado);
    }

    //Método para Ativação/Desativação/Limpeza ds 
    //Componentes do jPanelDados
    public void ligaDesliga(boolean estado) {
        Component[] componentes = this.telaCadTipoProduto.getjPanelDados().getComponents();
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
