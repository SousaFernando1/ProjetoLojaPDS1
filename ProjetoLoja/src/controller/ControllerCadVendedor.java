package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import view.ModeloCadastros;
import view.TelaCadVendedor;

public class ControllerCadVendedor implements ActionListener {

    TelaCadVendedor telaCadVendedor;

    public ControllerCadVendedor(TelaCadVendedor telaCadVendedor) {
        this.telaCadVendedor = telaCadVendedor;

        telaCadVendedor.getjButtonBuscar().addActionListener(this);
        telaCadVendedor.getjButtonNovo().addActionListener(this);
        telaCadVendedor.getjButtonCancelar().addActionListener(this);
        telaCadVendedor.getjButtonGravar().addActionListener(this);
        telaCadVendedor.getjButtonSair().addActionListener(this);

        ativa(true);
        ligaDesliga(false);

    }

    //Nesse método controlamos o que fazer quando uma ação acontece
    //Não foram desenvolvidas ainda as funcionalidades de persistência
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaCadVendedor.getjButtonNovo()) {
            ativa(false);
            ligaDesliga(true);
        } else if (acao.getSource() == telaCadVendedor.getjButtonCancelar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadVendedor.getjButtonGravar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadVendedor.getjButtonBuscar()) {
        } else if (acao.getSource() == telaCadVendedor.getjButtonSair()) {
	    this.telaCadVendedor.dispose();
        }
    }

    //Método para habilitar/desabilitar botões(controle de estados)
    public void ativa(boolean estado) {
        telaCadVendedor.getjButtonNovo().setEnabled(estado);
        telaCadVendedor.getjButtonCancelar().setEnabled(!estado);
        telaCadVendedor.getjButtonGravar().setEnabled(!estado);
        telaCadVendedor.getjButtonBuscar().setEnabled(estado);
        telaCadVendedor.getjButtonSair().setEnabled(estado);
    }

    //Método para Ativação/Desativação/Limpeza ds 
    //Componentes do jPanelDados
    public void ligaDesliga(boolean estado) {
        Component[] componentes = this.telaCadVendedor.getjPanelDados().getComponents();
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
