package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.DAO.CidadeDAO;
import model.DAO.EnderecoDAO;
import model.bo.Cidade;
import model.bo.Endereco;
import model.bo.Fornecedor;
import model.bo.Vendedor;
import service.FornecedorService;
import service.VendedorService;
import view.ModeloCadastros;
import view.TelaBusCidade;
import view.TelaBusVendedor;
import view.TelaCadVendedor;

public class ControllerCadVendedor implements ActionListener {

    TelaCadVendedor telaCadVendedor;
    public static int codigo;

    public ControllerCadVendedor(TelaCadVendedor telaCadVendedor) {
        this.telaCadVendedor = telaCadVendedor;
        

        telaCadVendedor.getjButtonBuscar().addActionListener(this);
        telaCadVendedor.getjButtonNovo().addActionListener(this);
        telaCadVendedor.getjButtonCancelar().addActionListener(this);
        telaCadVendedor.getjButtonGravar().addActionListener(this);
        telaCadVendedor.getjButtonSair().addActionListener(this);
        telaCadVendedor.getjComboBoxCidade().addActionListener(this);
        
        ativa(true);
        ligaDesliga(false);

    }

    //Nesse método controlamos o que fazer quando uma ação acontece
    //Não foram desenvolvidas ainda as funcionalidades de persistência
    @Override
    public void actionPerformed(ActionEvent acao) {
        if(acao.getSource() == telaCadVendedor.getjComboBoxCidade()){
	    EnderecoDAO enderecoDAO = new EnderecoDAO();
	    CidadeDAO cidadeDAO = new CidadeDAO();
	    
	    Cidade tempCidade = cidadeDAO.retrieve(telaCadVendedor.getjComboBoxCidade().getSelectedItem().toString());


          List<Endereco> list = enderecoDAO.retrieveCidade(tempCidade.getIdCidade());
	  telaCadVendedor.getjComboBoxCEP().removeAllItems();
          for(Endereco item: list){
	    telaCadVendedor.getjComboBoxCEP().addItem(item.getCepCep());
          }
	  }
        if (acao.getSource() == telaCadVendedor.getjButtonNovo()) {
            ativa(false);
            ligaDesliga(true);
	    this.telaCadVendedor.getjTFIdVendedor().setEnabled(false);

        } else if (acao.getSource() == telaCadVendedor.getjButtonCancelar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadVendedor.getjButtonGravar()) {
            
            Vendedor vendedor = new Vendedor();
	    
	    EnderecoDAO enderecoDAO = new EnderecoDAO();
            
            vendedor.setNome(this.telaCadVendedor.getNome().getText());
            vendedor.setCpfVendedor(this.telaCadVendedor.getCpf().getText());
            vendedor.setEmail(this.telaCadVendedor.getEmail().getText());
            vendedor.setFoneVendedor(this.telaCadVendedor.getFone().getText());
            vendedor.setPercentComissaoVenda(Float.parseFloat(this.telaCadVendedor.getPercComissaoVenda().getText()));
            vendedor.setPercentComissaoVenda(Float.parseFloat(this.telaCadVendedor.getPercComissaoRecebto().getText()));
            vendedor.setCompleEndereco(this.telaCadVendedor.getCompleEndereco().getText());
            vendedor.setEndereco_idcep(enderecoDAO.retrieve(this.telaCadVendedor.getjComboBoxCEP().getSelectedItem().toString()));
            
            VendedorService vendedorService = new VendedorService();
            if (this.telaCadVendedor.getjTFIdVendedor().getText().trim().equalsIgnoreCase("")) {
                vendedorService.salvar(vendedor);
            } else {
                vendedor.setIdvendedor(Integer.parseInt(this.telaCadVendedor.getjTFIdVendedor().getText()));
                vendedorService.atualizar(vendedor);
            }
            
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadVendedor.getjButtonBuscar()) {
            codigo = 0;
            //chamada da tela da busca
            TelaBusVendedor telaBusVendedor = new TelaBusVendedor(null, true);
            ControllerBusVendedor controllerBusVendedor = new ControllerBusVendedor(telaBusVendedor);
            telaBusVendedor.setVisible(true);
            System.out.println(codigo);

            if (codigo != 0) {
                Vendedor vendedor;
                VendedorService vendedorService = new VendedorService();
                vendedor = vendedorService.buscar(codigo);

                ativa(false);
                ligaDesliga(true);

                this.telaCadVendedor.getjTFIdVendedor().setText(vendedor.getIdvendedor()+ "");
                this.telaCadVendedor.getNome().setText(vendedor.getNome());
                this.telaCadVendedor.getCpf().setText(vendedor.getCpfVendedor());
                this.telaCadVendedor.getEmail().setText(vendedor.getEmail());
                this.telaCadVendedor.getFone().setText(vendedor.getFoneVendedor());
                this.telaCadVendedor.getCompleEndereco().setText(vendedor.getCompleEndereco());
                this.telaCadVendedor.getjComboBoxCEP().setSelectedItem(vendedor.getEndereco_idcep());
                
                this.telaCadVendedor.getjTFIdVendedor().setEnabled(false);
            }
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
