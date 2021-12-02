package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import view.ModeloCadastros;
import view.TelaCadFornecedor;

public class ControllerCadFornecedor implements ActionListener {

    TelaCadFornecedor telaCadFornecedor;

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
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadFornecedor.getjButtonBuscar()) {
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
