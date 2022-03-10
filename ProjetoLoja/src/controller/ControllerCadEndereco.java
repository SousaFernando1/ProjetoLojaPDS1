package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.DAO.BairroDAO;
import model.DAO.CidadeDAO;
import model.bo.Bairro;
import model.bo.Cidade;
import model.bo.Endereco;
import service.BairroService;
import service.EnderecoService;
import view.ModeloCadastros;
import view.TelaBusBairro;
import view.TelaCadBairro;
import view.TelaCadEndereco;

public class ControllerCadEndereco implements ActionListener {

    TelaCadEndereco telaCadEndereco;
    public static int codigo;

    public ControllerCadEndereco(TelaCadEndereco telaCadEndereco) {
        this.telaCadEndereco = telaCadEndereco;


        telaCadEndereco.getjButtonBuscar().addActionListener(this);
        telaCadEndereco.getjButtonNovo().addActionListener(this);
        telaCadEndereco.getjButtonCancelar().addActionListener(this);
        telaCadEndereco.getjButtonGravar().addActionListener(this);
        telaCadEndereco.getjButtonSair().addActionListener(this);
        telaCadEndereco.getjComboBoxCidade().addActionListener(this);

        ativa(true);
        ligaDesliga(false);

    
    }        

    //Nesse método controlamos o que fazer quando uma ação acontece
    //Não foram desenvolvidas ainda as funcionalidades de persistência
    @Override
    public void actionPerformed(ActionEvent acao) {
		if(acao.getSource() == telaCadEndereco.getjComboBoxCidade()){
	  BairroDAO bairroDAO = new BairroDAO();
	    CidadeDAO cidadeDAO = new CidadeDAO();

	    Cidade tempCidade = cidadeDAO.retrieve(telaCadEndereco.getjComboBoxCidade().getSelectedItem().toString());


          List<Bairro> list = bairroDAO.retrieveDesc(tempCidade.getIdCidade());
	  telaCadEndereco.getjComboBoxBairro().removeAllItems();
          for(Bairro item: list){
	    telaCadEndereco.getjComboBoxBairro().addItem(item.getDescricaoBairro());
          }

//	    System.out.println(telaCadCliente.getjComboBoxCidade().getSelectedItem().toString());
	}
        if (acao.getSource() == telaCadEndereco.getjButtonNovo()) {
            ativa(false);
            ligaDesliga(true);
	    this.telaCadEndereco.getjTFIdCidade().setEnabled(false);
        } else if (acao.getSource() == telaCadEndereco.getjButtonCancelar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadEndereco.getjButtonGravar()) {
            Endereco endereco = new Endereco();

//            cidade.setUfCidade(this.telaCadCidade.getjTFUF().getText());

	    endereco.setCepCep(this.telaCadEndereco.getjTFCEP().getText());
	    endereco.setLogradouroCep(this.telaCadEndereco.getjTFLogradouro().getText());

	    Bairro bairro = new Bairro();


	    String tempString, tempString2;

            tempString = this.telaCadEndereco.getjComboBoxBairro().getSelectedItem().toString();
	    BairroDAO bairroDAO = new BairroDAO();
	    endereco.setBairro(bairroDAO.retrieve(tempString));


	    tempString2 = this.telaCadEndereco.getjComboBoxCidade().getSelectedItem().toString();
	    CidadeDAO cidadeDAO = new CidadeDAO();
	    endereco.setCidade(cidadeDAO.retrieve(tempString2));

            EnderecoService enderecoService = new EnderecoService();
           
            if (this.telaCadEndereco.getjTFIdCidade().getText().trim().equalsIgnoreCase("")) {
                enderecoService.salvar(endereco);
            } else {
                endereco.setIdCep(Integer.parseInt(this.telaCadEndereco.getjTFIdCidade().getText()));
                enderecoService.atualizar(endereco);
            }

            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadEndereco.getjButtonBuscar()) {
//	    codigo = 0;
//            //chamada da tela da busca
//            TelaBusBairro telaBusBairro = new TelaBusBairro(null, true);
//            ControllerBusBairro controllerBusBairro = new ControllerBusBairro(telaBusBairro);
//            telaBusBairro.setVisible(true);
//
//            if (codigo != 0) {
//                Bairro bairro;
//                BairroService bairroService = new BairroService();
//                bairro = bairroService.buscar(codigo);
//
//                ativa(false);
//                ligaDesliga(true);
//
//                this.telaCadBairro.getjTFIdCidade().setText(bairro.getIdBairro()+ "");
//                this.telaCadBairro.getjTFNomeBairro().setText(bairro.getDescricaoBairro());
////                this.telaCadBairro.getjTFUF().setText(cidade.getUfCidade());
//		this.telaCadBairro.getjComboBox1().setSelectedItem(bairro.getCidadeMae());
//
//                this.telaCadBairro.getjTFIdCidade().setEnabled(false);
//            }
        } else if (acao.getSource() == telaCadEndereco.getjButtonSair()) {
	    this.telaCadEndereco.dispose();
        }
    }

    //Método para habilitar/desabilitar botões(controle de estados)
    public void ativa(boolean estado) {
        telaCadEndereco.getjButtonNovo().setEnabled(estado);
        telaCadEndereco.getjButtonCancelar().setEnabled(!estado);
        telaCadEndereco.getjButtonGravar().setEnabled(!estado);
        telaCadEndereco.getjButtonBuscar().setEnabled(estado);
        telaCadEndereco.getjButtonSair().setEnabled(estado);
    }

    //Método para Ativação/Desativação/Limpeza ds 
    //Componentes do jPanelDados
    public void ligaDesliga(boolean estado) {
        Component[] componentes = this.telaCadEndereco.getjPanelDados().getComponents();
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
