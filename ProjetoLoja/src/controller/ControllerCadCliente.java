package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.bo.Cliente;
import service.ClienteService;
import view.ModeloCadastros;
import view.TelaCadCliente;

public class ControllerCadCliente implements ActionListener {

    TelaCadCliente telaCadCliente;

    public ControllerCadCliente(TelaCadCliente telaCadCliente) {
        this.telaCadCliente = telaCadCliente;

        telaCadCliente.getjButtonBuscar().addActionListener(this);
        telaCadCliente.getjButtonNovo().addActionListener(this);
        telaCadCliente.getjButtonCancelar().addActionListener(this);
        telaCadCliente.getjButtonGravar().addActionListener(this);
        telaCadCliente.getjButtonSair().addActionListener(this);

        ativa(true);
        ligaDesliga(false);

    }

    //Nesse método controlamos o que fazer quando uma ação acontece
    //Não foram desenvolvidas ainda as funcionalidades de persistência
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaCadCliente.getjButtonNovo()) {
            ativa(false);
            ligaDesliga(true);
        } else if (acao.getSource() == telaCadCliente.getjButtonCancelar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadCliente.getjButtonGravar()) {

            Cliente cliente = new Cliente();


//            cidade.setUfCidade(this.telaCadCidade.getjTFUF().getText());

	    cliente.setNome(this.telaCadCliente.getNome().getText());
	    cliente.setDtNascCliente(this.telaCadCliente.getDtNascimento().getText());	    
	    cliente.setEmail(this.telaCadCliente.getEmail().getText());
	    cliente.setCpfCliente(this.telaCadCliente.getCpf().getText());
	    cliente.setRgCliente(this.telaCadCliente.getRg().getText());
	    cliente.setCompleEndereco(this.telaCadCliente.getCompEndereco().getText());
	    cliente.setFoneCliente(this.telaCadCliente.getFone().getText());

            ClienteService clienteService = new ClienteService();
            clienteService.salvar(cliente);

            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadCliente.getjButtonBuscar()) {
        } else if (acao.getSource() == telaCadCliente.getjButtonSair()) {
	    this.telaCadCliente.dispose();
        }
    }

    //Método para habilitar/desabilitar botões(controle de estados)
    public void ativa(boolean estado) {
        telaCadCliente.getjButtonNovo().setEnabled(estado);
        telaCadCliente.getjButtonCancelar().setEnabled(!estado);
        telaCadCliente.getjButtonGravar().setEnabled(!estado);
        telaCadCliente.getjButtonBuscar().setEnabled(estado);
        telaCadCliente.getjButtonSair().setEnabled(estado);
    }

    //Método para Ativação/Desativação/Limpeza ds 
    //Componentes do jPanelDados
    public void ligaDesliga(boolean estado) {
        Component[] componentes = this.telaCadCliente.getjPanelDados().getComponents();
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
