package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import view.ModeloCadastros;
import view.TelaCadMarca;

public class ControllerCadMarca implements ActionListener {

    TelaCadMarca telaCadMarca;

    public ControllerCadMarca(TelaCadMarca telaCadMarca) {
        this.telaCadMarca = telaCadMarca;

        telaCadMarca.getjButtonBuscar().addActionListener(this);
        telaCadMarca.getjButtonNovo().addActionListener(this);
        telaCadMarca.getjButtonCancelar().addActionListener(this);
        telaCadMarca.getjButtonGravar().addActionListener(this);
        telaCadMarca.getjButtonSair().addActionListener(this);

        ativa(true);
        ligaDesliga(false);

    }

    //Nesse método controlamos o que fazer quando uma ação acontece
    //Não foram desenvolvidas ainda as funcionalidades de persistência
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaCadMarca.getjButtonNovo()) {
            ativa(false);
            ligaDesliga(true);
        } else if (acao.getSource() == telaCadMarca.getjButtonCancelar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadMarca.getjButtonGravar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadMarca.getjButtonBuscar()) {
        } else if (acao.getSource() == telaCadMarca.getjButtonSair()) {
	    this.telaCadMarca.dispose();
        }
    }

    //Método para habilitar/desabilitar botões(controle de estados)
    public void ativa(boolean estado) {
        telaCadMarca.getjButtonNovo().setEnabled(estado);
        telaCadMarca.getjButtonCancelar().setEnabled(!estado);
        telaCadMarca.getjButtonGravar().setEnabled(!estado);
        telaCadMarca.getjButtonBuscar().setEnabled(estado);
        telaCadMarca.getjButtonSair().setEnabled(estado);
    }

    //Método para Ativação/Desativação/Limpeza ds 
    //Componentes do jPanelDados
    public void ligaDesliga(boolean estado) {
        Component[] componentes = this.telaCadMarca.getjPanelDados().getComponents();
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
