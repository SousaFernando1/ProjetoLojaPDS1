package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import view.ModeloCadastros;
import view.TelaCadBairro;

public class ControllerCadBairro implements ActionListener {

    TelaCadBairro telaCadBairro;

    public ControllerCadBairro(TelaCadBairro telaCadBairro) {
        this.telaCadBairro = telaCadBairro;

        telaCadBairro.getjButtonBuscar().addActionListener(this);
        telaCadBairro.getjButtonNovo().addActionListener(this);
        telaCadBairro.getjButtonCancelar().addActionListener(this);
        telaCadBairro.getjButtonGravar().addActionListener(this);
        telaCadBairro.getjButtonSair().addActionListener(this);

        ativa(true);
        ligaDesliga(false);

    }

    //Nesse método controlamos o que fazer quando uma ação acontece
    //Não foram desenvolvidas ainda as funcionalidades de persistência
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaCadBairro.getjButtonNovo()) {
            ativa(false);
            ligaDesliga(true);
        } else if (acao.getSource() == telaCadBairro.getjButtonCancelar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadBairro.getjButtonGravar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadBairro.getjButtonBuscar()) {
        } else if (acao.getSource() == telaCadBairro.getjButtonSair()) {
	    this.telaCadBairro.dispose();
        }
    }

    //Método para habilitar/desabilitar botões(controle de estados)
    public void ativa(boolean estado) {
        telaCadBairro.getjButtonNovo().setEnabled(estado);
        telaCadBairro.getjButtonCancelar().setEnabled(!estado);
        telaCadBairro.getjButtonGravar().setEnabled(!estado);
        telaCadBairro.getjButtonBuscar().setEnabled(estado);
        telaCadBairro.getjButtonSair().setEnabled(estado);
    }

    //Método para Ativação/Desativação/Limpeza ds 
    //Componentes do jPanelDados
    public void ligaDesliga(boolean estado) {
        Component[] componentes = this.telaCadBairro.getjPanelDados().getComponents();
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
