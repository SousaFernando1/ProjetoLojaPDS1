package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.bo.Cor;
import service.CorService;
import view.ModeloCadastros;
import view.TelaCadCor;

public class ControllerCadCor implements ActionListener {

    TelaCadCor telaCadCor;

    public ControllerCadCor(TelaCadCor telaCadCor) {
        this.telaCadCor = telaCadCor;

        telaCadCor.getjButtonBuscar().addActionListener(this);
        telaCadCor.getjButtonNovo().addActionListener(this);
        telaCadCor.getjButtonCancelar().addActionListener(this);
        telaCadCor.getjButtonGravar().addActionListener(this);
        telaCadCor.getjButtonSair().addActionListener(this);

        ativa(true);
        ligaDesliga(false);

    }

    //Nesse método controlamos o que fazer quando uma ação acontece
    //Não foram desenvolvidas ainda as funcionalidades de persistência
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaCadCor.getjButtonNovo()) {
            ativa(false);
            ligaDesliga(true);
        } else if (acao.getSource() == telaCadCor.getjButtonCancelar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadCor.getjButtonGravar()) {
	    Cor cor = new Cor();
            
            cor.setDescricaoCor(this.telaCadCor.getDescricaoCor().getText());  


            CorService corService = new CorService();
            corService.salvar(cor);

            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadCor.getjButtonBuscar()) {
        } else if (acao.getSource() == telaCadCor.getjButtonSair()) {
	    this.telaCadCor.dispose();
        }
    }

    //Método para habilitar/desabilitar botões(controle de estados)
    public void ativa(boolean estado) {
        telaCadCor.getjButtonNovo().setEnabled(estado);
        telaCadCor.getjButtonCancelar().setEnabled(!estado);
        telaCadCor.getjButtonGravar().setEnabled(!estado);
        telaCadCor.getjButtonBuscar().setEnabled(estado);
        telaCadCor.getjButtonSair().setEnabled(estado);
    }

    //Método para Ativação/Desativação/Limpeza ds 
    //Componentes do jPanelDados
    public void ligaDesliga(boolean estado) {
        Component[] componentes = this.telaCadCor.getjPanelDados().getComponents();
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
