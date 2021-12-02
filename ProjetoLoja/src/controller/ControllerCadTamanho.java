package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import view.ModeloCadastros;
import view.TelaCadTamanho;

public class ControllerCadTamanho implements ActionListener {

    TelaCadTamanho telaCadTamanho;

    public ControllerCadTamanho(TelaCadTamanho telaCadTamanho) {
        this.telaCadTamanho = telaCadTamanho;

        telaCadTamanho.getjButtonBuscar().addActionListener(this);
        telaCadTamanho.getjButtonNovo().addActionListener(this);
        telaCadTamanho.getjButtonCancelar().addActionListener(this);
        telaCadTamanho.getjButtonGravar().addActionListener(this);
        telaCadTamanho.getjButtonSair().addActionListener(this);

        ativa(true);
        ligaDesliga(false);

    }

    //Nesse método controlamos o que fazer quando uma ação acontece
    //Não foram desenvolvidas ainda as funcionalidades de persistência
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaCadTamanho.getjButtonNovo()) {
            ativa(false);
            ligaDesliga(true);
        } else if (acao.getSource() == telaCadTamanho.getjButtonCancelar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadTamanho.getjButtonGravar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadTamanho.getjButtonBuscar()) {
        } else if (acao.getSource() == telaCadTamanho.getjButtonSair()) {
	    this.telaCadTamanho.dispose();
        }
    }

    //Método para habilitar/desabilitar botões(controle de estados)
    public void ativa(boolean estado) {
        telaCadTamanho.getjButtonNovo().setEnabled(estado);
        telaCadTamanho.getjButtonCancelar().setEnabled(!estado);
        telaCadTamanho.getjButtonGravar().setEnabled(!estado);
        telaCadTamanho.getjButtonBuscar().setEnabled(estado);
        telaCadTamanho.getjButtonSair().setEnabled(estado);
    }

    //Método para Ativação/Desativação/Limpeza ds 
    //Componentes do jPanelDados
    public void ligaDesliga(boolean estado) {
        Component[] componentes = this.telaCadTamanho.getjPanelDados().getComponents();
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
