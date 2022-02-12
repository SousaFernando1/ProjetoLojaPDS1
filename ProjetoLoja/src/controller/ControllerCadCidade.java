package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.bo.Cidade;
import service.CidadeService;
import view.ModeloCadastros;
import view.TelaCadCidade;

public class ControllerCadCidade implements ActionListener {

    TelaCadCidade telaCadCidade;

    public ControllerCadCidade(TelaCadCidade telaCadCidade) {
        this.telaCadCidade = telaCadCidade;

        telaCadCidade.getjButtonBuscar().addActionListener(this);
        telaCadCidade.getjButtonNovo().addActionListener(this);
        telaCadCidade.getjButtonCancelar().addActionListener(this);
        telaCadCidade.getjButtonGravar().addActionListener(this);
        telaCadCidade.getjButtonSair().addActionListener(this);

        ativa(true);
        ligaDesliga(false);

    }

    //Nesse método controlamos o que fazer quando uma ação acontece
    //Não foram desenvolvidas ainda as funcionalidades de persistência
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaCadCidade.getjButtonNovo()) {
            ativa(false);
            ligaDesliga(true);
        } else if (acao.getSource() == telaCadCidade.getjButtonCancelar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadCidade.getjButtonGravar()) {
            
            Cidade cidade = new Cidade();
            
            cidade.setDescricaoCidade(this.telaCadCidade.getjTFNomeCidade().getText());
            cidade.setUfCidade(this.telaCadCidade.getjTFUF().getText());
            
            CidadeService cidService = new CidadeService();
            cidService.salvar(cidade);
            
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadCidade.getjButtonBuscar()) {
        } else if (acao.getSource() == telaCadCidade.getjButtonSair()) {
	    this.telaCadCidade.dispose();
        }
    }

    //Método para habilitar/desabilitar botões(controle de estados)
    public void ativa(boolean estado) {
        telaCadCidade.getjButtonNovo().setEnabled(estado);
        telaCadCidade.getjButtonCancelar().setEnabled(!estado);
        telaCadCidade.getjButtonGravar().setEnabled(!estado);
        telaCadCidade.getjButtonBuscar().setEnabled(estado);
        telaCadCidade.getjButtonSair().setEnabled(estado);
    }

    //Método para Ativação/Desativação/Limpeza ds 
    //Componentes do jPanelDados
    public void ligaDesliga(boolean estado) {
        Component[] componentes = this.telaCadCidade.getjPanelDados().getComponents();
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
