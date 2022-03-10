package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.bo.CondicaoPagamento;
import service.CondicaoPagamentoService;
import view.ModeloCadastros;
import view.TelaCadCondicaoPagamento;
import view.TelaCadFornecedor;

public class ControllerCadCondicaoPagamento implements ActionListener {

    TelaCadCondicaoPagamento telaCadCondicaoPagamento;

    public ControllerCadCondicaoPagamento(TelaCadCondicaoPagamento telaCadCondicaoPagamento) {
        this.telaCadCondicaoPagamento = telaCadCondicaoPagamento;

        telaCadCondicaoPagamento.getjButtonBuscar().addActionListener(this);
        telaCadCondicaoPagamento.getjButtonNovo().addActionListener(this);
        telaCadCondicaoPagamento.getjButtonCancelar().addActionListener(this);
        telaCadCondicaoPagamento.getjButtonGravar().addActionListener(this);
        telaCadCondicaoPagamento.getjButtonSair().addActionListener(this);

        ativa(true);
        ligaDesliga(false);

    }

    //Nesse método controlamos o que fazer quando uma ação acontece
    //Não foram desenvolvidas ainda as funcionalidades de persistência
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaCadCondicaoPagamento.getjButtonNovo()) {
            ativa(false);
            ligaDesliga(true);
	    this.telaCadCondicaoPagamento.getjTFIdCondicaoPagamento().setEnabled(false);
        } else if (acao.getSource() == telaCadCondicaoPagamento.getjButtonCancelar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadCondicaoPagamento.getjButtonGravar()) {


	    CondicaoPagamento condicaoPagamento = new CondicaoPagamento();
            
            condicaoPagamento.setDescricaoCondicaoPagamento(this.telaCadCondicaoPagamento.getjTFDescricaoCondicaoPagamento().getText());  
	    condicaoPagamento.setNumDiasAtePrimeiraParcela(Integer.parseInt(this.telaCadCondicaoPagamento.getjTFDiasPrimeiraParcelaCondicaoPagamento().getText()));
	    condicaoPagamento.setNumDiasEntreParcelas(Integer.parseInt(this.telaCadCondicaoPagamento.getjTFDiasEntreParcelasCondicaoPagamento().getText()));


            CondicaoPagamentoService condicaoPagamentoService = new CondicaoPagamentoService();
            if (this.telaCadCondicaoPagamento.getjTFIdCondicaoPagamento().getText().trim().equalsIgnoreCase("")) {
                condicaoPagamentoService.salvar(condicaoPagamento);
            } else {
                condicaoPagamento.setIdcondicaoPagamento(Integer.parseInt(this.telaCadCondicaoPagamento.getjTFIdCondicaoPagamento().getText()));
                condicaoPagamentoService.atualizar(condicaoPagamento);
            }

            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadCondicaoPagamento.getjButtonBuscar()) {
        } else if (acao.getSource() == telaCadCondicaoPagamento.getjButtonSair()) {
	    this.telaCadCondicaoPagamento.dispose();
        }
    }

    //Método para habilitar/desabilitar botões(controle de estados)
    public void ativa(boolean estado) {
        telaCadCondicaoPagamento.getjButtonNovo().setEnabled(estado);
        telaCadCondicaoPagamento.getjButtonCancelar().setEnabled(!estado);
        telaCadCondicaoPagamento.getjButtonGravar().setEnabled(!estado);
        telaCadCondicaoPagamento.getjButtonBuscar().setEnabled(estado);
        telaCadCondicaoPagamento.getjButtonSair().setEnabled(estado);
    }

    //Método para Ativação/Desativação/Limpeza ds 
    //Componentes do jPanelDados
    public void ligaDesliga(boolean estado) {
        Component[] componentes = this.telaCadCondicaoPagamento.getjPanelDados().getComponents();
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
