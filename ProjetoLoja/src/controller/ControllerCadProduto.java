package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import view.ModeloCadastros;
import view.TelaCadProduto;

public class ControllerCadProduto implements ActionListener {

    TelaCadProduto telaCadProduto;

    public ControllerCadProduto(TelaCadProduto telaCadProduto) {
        this.telaCadProduto = telaCadProduto;

        telaCadProduto.getjButtonBuscar().addActionListener(this);
        telaCadProduto.getjButtonNovo().addActionListener(this);
        telaCadProduto.getjButtonCancelar().addActionListener(this);
        telaCadProduto.getjButtonGravar().addActionListener(this);
        telaCadProduto.getjButtonSair().addActionListener(this);

        ativa(true);
        ligaDesliga(false);

    }

    //Nesse método controlamos o que fazer quando uma ação acontece
    //Não foram desenvolvidas ainda as funcionalidades de persistência
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaCadProduto.getjButtonNovo()) {
            ativa(false);
            ligaDesliga(true);
        } else if (acao.getSource() == telaCadProduto.getjButtonCancelar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadProduto.getjButtonGravar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadProduto.getjButtonBuscar()) {
        } else if (acao.getSource() == telaCadProduto.getjButtonSair()) {
	    this.telaCadProduto.dispose();
        }
    }

    //Método para habilitar/desabilitar botões(controle de estados)
    public void ativa(boolean estado) {
        telaCadProduto.getjButtonNovo().setEnabled(estado);
        telaCadProduto.getjButtonCancelar().setEnabled(!estado);
        telaCadProduto.getjButtonGravar().setEnabled(!estado);
        telaCadProduto.getjButtonBuscar().setEnabled(estado);
        telaCadProduto.getjButtonSair().setEnabled(estado);
    }

    //Método para Ativação/Desativação/Limpeza ds 
    //Componentes do jPanelDados
    public void ligaDesliga(boolean estado) {
        Component[] componentes = this.telaCadProduto.getjPanelDados().getComponents();
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
