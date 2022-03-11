package controller;

import static controller.ControllerCadCaracteristicaProduto.codigo;
import static controller.ControllerCadCondicaoPagamento.codigo;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.DAO.CidadeDAO;
import model.DAO.ClienteDAO;
import model.DAO.VendaDAO;
import model.bo.Bairro;
import model.bo.CaracteristicaProduto;
import model.bo.Cidade;
import model.bo.CondicaoPagamento;
import model.bo.Produto;
import model.bo.Venda;
import service.BairroService;
import service.CaracteristicaProdutoService;
import service.ClienteService;
import service.CondicaoPagamentoService;
import service.ProdutoService;
import service.VendedorService;
import view.ModeloCadastros;
import view.TelaBusBairro;
import view.TelaBusCaracteristicaProduto;
import view.TelaBusCondicaoPagamento;
import view.TelaVendas;

public class ControllerCadVendas implements ActionListener {

    TelaVendas telaVendas;
    public static int codigo;
    public static int counter;
    public static float total;


    public ControllerCadVendas(TelaVendas telaVendas) {
        this.telaVendas = telaVendas;

	telaVendas.getjButtonBuscaProduto().setEnabled(true);
//        telaVendas.getjButtonBuscar.addActionListener(this);
//        telaVendas.getjButtonNovo().addActionListener(this);
//        telaVendas.getjButtonCancelar().addActionListener(this);
//        telaVendas.getjButtonGravar().addActionListener(this);
        telaVendas.getjButtonBuscaProduto().addActionListener(this);
	

//        ativa(true);
//        ligaDesliga(false);

	 
	 

    this.telaVendas.getjTextFieldBarraProduto().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
		AddTable(telaVendas.getjTextFieldBarraProduto().getText());
		telaVendas.getjTextFieldBarraProduto().setText("");

                } else if (evt.getKeyCode() == KeyEvent.VK_F1) {
                    abrePesquisaProduto(); 
                } else if (evt.getKeyCode() == KeyEvent.VK_F2) {
		    telaVendas.dispose();
		    
		    TelaVendas telaVenda = new TelaVendas(null, true);
		    ControllerCadVendas controllerCadVendas = new ControllerCadVendas(telaVenda);
		    telaVenda.setVisible(true);
                } else if (evt.getKeyCode() == KeyEvent.VK_F3) {
		    telaVendas.dispose();

                } else if (evt.getKeyCode() == KeyEvent.VK_F4) {

		 codigo = 0;
            //chamada da tela da busca
            TelaBusCondicaoPagamento telaBusCondicaoPagamento = new TelaBusCondicaoPagamento(null, true);
            ControllerBusCondicaoPagamento controllerBusCondicaoPagamento = new ControllerBusCondicaoPagamento(telaBusCondicaoPagamento);
            telaBusCondicaoPagamento.setVisible(true);

            if (codigo != 0) {
                CondicaoPagamento condicaoPagamento = new CondicaoPagamento();
                CondicaoPagamentoService condicaoPagamentoService = new CondicaoPagamentoService();
                condicaoPagamento = condicaoPagamentoService.buscar(codigo);
		
		ClienteService clienteService = new ClienteService();
		VendedorService vendedorService = new VendedorService();

//                ativa(false);	


//		System.out.println("ID CLIENTE: "+clienteService.buscar(1).getIdcliente());

		int um = 1;
		Venda venda = new Venda();
		venda.setCliente_idcliente(clienteService.buscar(um));
		venda.setVendedor_idvendedor(vendedorService.buscar(um));
		venda.setCondicaoPagamento_idcondicaoPagamento(condicaoPagamento);
		venda.setDtVenda("2022-03-12");
		venda.setHrVenda("19");
		venda.setValDescontoVenda(0);
		venda.setSerieVenda("teste");
		venda.setValTotalVenda(total);

		VendaDAO vendaDAO = new VendaDAO();

		vendaDAO.create(venda);
		telaVendas.dispose();
}    	    



                } else if (evt.getKeyCode() == KeyEvent.VK_F5) {
					    
		    DefaultTableModel tabela = (DefaultTableModel) telaVendas.getjTable1().getModel();
		    int lastRow = tabela.getRowCount();
		    total -= (float)telaVendas.getjTable1().getValueAt(lastRow -1 ,4);
		    telaVendas.getjLabelTotal().setText(total + "");

		    tabela.removeRow(tabela.getRowCount() - 1);
                }
            }
        });
    
    }        

    //Nesse método controlamos o que fazer quando uma ação acontece
    //Não foram desenvolvidas ainda as funcionalidades de persistência

    public void AddTable(String codBarra) {
	 counter = 0;
	 CaracteristicaProdutoService caracteristicaProdutoService = new CaracteristicaProdutoService();
	 CaracteristicaProduto caracteristicaProduto = new CaracteristicaProduto();
	 
	 caracteristicaProduto = caracteristicaProdutoService.buscar(codBarra);
	 
	    counter++;
            DefaultTableModel tabela = (DefaultTableModel) this.telaVendas.getjTable1().getModel();
            tabela.addRow(new Object[]{ counter,
					caracteristicaProduto.getProduto_idproduto().getIdproduto(),
                                        caracteristicaProduto.getProduto_idproduto().getDescricaoProduto(),
                                        1,
					caracteristicaProduto.getProduto_idproduto().getValProduto(),
					caracteristicaProduto.getProduto_idproduto().getValProduto()});
        
					total += caracteristicaProduto.getProduto_idproduto().getValProduto();
					this.telaVendas.getjLabelTotal().setText(total + "");

}

    
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaVendas.getjButtonBuscaProduto()) {
            abrePesquisaProduto(); 

        } 

   

        






//else if (acao.getSource() == telaVendas.getjButtonCancelar()) {
//            ativa(true);
//            ligaDesliga(false);
//        } else if (acao.getSource() == telaVendas.getjButtonGravar()) {
////            Bairro bairro = new Bairro();
//	    Venda venda = new Venda();
//
//	    String tempString;
//            tempString = this.telaVendas.getjComboBox1().getSelectedItem().toString();
//
//	    
//            venda.setIdvenda(this.telaVendas.);
//  
//            BairroService bairroService = new BairroService();
//            if (this.telaVendas.getjTFIdCidade().getText().trim().equalsIgnoreCase("")) {
//                bairroService.salvar(bairro);
//            } else {
//                cidade.setIdCidade(Integer.parseInt(this.telaVendas.getjTFIdCidade().getText()));
//                System.out.println("teste");
//                bairroService.atualizar(bairro);
//            }
//
//            ativa(true);
//            ligaDesliga(false);
//        } else if (acao.getSource() == telaVendas.getjButtonBuscar()) {
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
//                this.telaVendas.getjTFIdCidade().setText(bairro.getIdBairro()+ "");
//                this.telaVendas.getjTFNomeBairro().setText(bairro.getDescricaoBairro());
////                this.telaVendas.getjTFUF().setText(cidade.getUfCidade());
//		this.telaVendas.getjComboBox1().setSelectedItem(bairro.getCidadeMae());
//
//                this.telaVendas.getjTFIdCidade().setEnabled(false);
//            }
//        } else if (acao.getSource() == telaVendas.getjButtonSair()) {
//	    this.telaVendas.dispose();
//        }
    }
    
     public void abrePesquisaProduto() {
         this.telaVendas.getjTextFieldBarraProduto().setEnabled(true);
            //chamada da tela da busca
            TelaBusCaracteristicaProduto telaBusCaracteristicaProduto = new TelaBusCaracteristicaProduto(null, true);
            ControllerBusCaracteristicaProduto controllerBusCaracteristicaProduto = new ControllerBusCaracteristicaProduto(telaBusCaracteristicaProduto);
            telaBusCaracteristicaProduto.setVisible(true);
            
            CaracteristicaProduto caracteristicaProduto;
            CaracteristicaProdutoService caracteristicaProdutoService = new CaracteristicaProdutoService();
	    System.out.println(codigo);
	    if (codigo != 0){
	    caracteristicaProduto = caracteristicaProdutoService.buscar(codigo);
	    AddTable(caracteristicaProduto.getBarraProduto());
	    
}

            ativa(false);

            this.telaVendas.getjTextFieldBarraProduto().setText("");
    }
     
    public void insereProduto() {
        
    }

    //Método para habilitar/desabilitar botões(controle de estados)
    public void ativa(boolean estado) {
        telaVendas.getjButtonBuscaAluno().setEnabled(estado);
//        telaVendas.getjButtonCancelar().setEnabled(!estado);
//        telaVendas.getjButtonGravar().setEnabled(!estado);
//        telaVendas.getjButtonBuscar().setEnabled(estado);
//        telaVendas.getjButtonSair().setEnabled(estado);
    }

    //Método para Ativação/Desativação/Limpeza ds 
    //Componentes do jPanelDados
//    public void ligaDesliga(boolean estado) {
//        Component[] componentes = this.telaVendas.getjTable1().getComponents();
//        for (Component componenteAtual : componentes) {
//            if (componenteAtual instanceof JTextField) {
//                ((JTextField) componenteAtual).setText("");
//                componenteAtual.setEnabled(estado);
//            } else if (componenteAtual instanceof JFormattedTextField) {
//                ((JFormattedTextField) componenteAtual).setText("");
//                componenteAtual.setEnabled(estado);
//            } else if (componenteAtual instanceof JComboBox) {
//                ((JComboBox) componenteAtual).setSelectedIndex(0);
//                componenteAtual.setEnabled(estado);
//            }
//        }
//    }
}
