package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import view.ModeloCadastros;
import view.TelaCadCondicaoPagamento;
import view.TelaCadFoneFornecedor;
import view.TelaCadFornecedor;

public class ControllerCadFoneFornecedor implements ActionListener {

    TelaCadFoneFornecedor telaCadFoneFornecedor;

    public ControllerCadFoneFornecedor(TelaCadFoneFornecedor telaCadFoneFornecedor) {
        this.telaCadFoneFornecedor = telaCadFoneFornecedor;

        telaCadFoneFornecedor.getjButtonBuscar().addActionListener(this);
        telaCadFoneFornecedor.getjButtonNovo().addActionListener(this);
        telaCadFoneFornecedor.getjButtonCancelar().addActionListener(this);
        telaCadFoneFornecedor.getjButtonGravar().addActionListener(this);
        telaCadFoneFornecedor.getjButtonSair().addActionListener(this);

        ativa(true);
        ligaDesliga(false);

    }

    //Nesse método controlamos o que fazer quando uma ação acontece
    //Não foram desenvolvidas ainda as funcionalidades de persistência
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaCadFoneFornecedor.getjButtonNovo()) {
            ativa(false);
            ligaDesliga(true);
        } else if (acao.getSource() == telaCadFoneFornecedor.getjButtonCancelar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadFoneFornecedor.getjButtonGravar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadFoneFornecedor.getjButtonBuscar()) {
        } else if (acao.getSource() == telaCadFoneFornecedor.getjButtonSair()) {
	    this.telaCadFoneFornecedor.dispose();
        }
    }

    //Método para habilitar/desabilitar botões(controle de estados)
    public void ativa(boolean estado) {
        telaCadFoneFornecedor.getjButtonNovo().setEnabled(estado);
        telaCadFoneFornecedor.getjButtonCancelar().setEnabled(!estado);
        telaCadFoneFornecedor.getjButtonGravar().setEnabled(!estado);
        telaCadFoneFornecedor.getjButtonBuscar().setEnabled(estado);
        telaCadFoneFornecedor.getjButtonSair().setEnabled(estado);
    }

    //Método para Ativação/Desativação/Limpeza ds 
    //Componentes do jPanelDados
    public void ligaDesliga(boolean estado) {
        Component[] componentes = this.telaCadFoneFornecedor.getjPanelDados().getComponents();
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
