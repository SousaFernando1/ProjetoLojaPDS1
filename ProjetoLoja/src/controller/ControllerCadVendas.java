package controller;

import static controller.ControllerCadCaracteristicaProduto.codigo;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.DAO.CidadeDAO;
import model.bo.Bairro;
import model.bo.CaracteristicaProduto;
import model.bo.Cidade;
import model.bo.Venda;
import service.BairroService;
import service.CaracteristicaProdutoService;
import view.ModeloCadastros;
import view.TelaBusBairro;
import view.TelaBusCaracteristicaProduto;
import view.TelaVendas;

public class ControllerCadVendas implements ActionListener {

    TelaVendas telaVendas;
    public static int codigo;

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
                    System.out.println("FUNCIONANDO");
                } else if (evt.getKeyCode() == KeyEvent.VK_F1) {
                    //Rotina para carga da busca por prdutos
                } else if (evt.getKeyCode() == KeyEvent.VK_F2) {
                } else if (evt.getKeyCode() == KeyEvent.VK_F3) {

                } else if (evt.getKeyCode() == KeyEvent.VK_F4) {

                } else if (evt.getKeyCode() == KeyEvent.VK_F5) {
                    
                }
            }
        });
    
    }        

    //Nesse método controlamos o que fazer quando uma ação acontece
    //Não foram desenvolvidas ainda as funcionalidades de persistência
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaVendas.getjButtonBuscaProduto()) {
//            ativa(false);
//            ligaDesliga(true);
	    this.telaVendas.getjTextFieldBarraProduto().setEnabled(true);
            //chamada da tela da busca
            TelaBusCaracteristicaProduto telaBusCaracteristicaProduto = new TelaBusCaracteristicaProduto(null, true);
            ControllerBusCaracteristicaProduto controllerBusCaracteristicaProduto = new ControllerBusCaracteristicaProduto(telaBusCaracteristicaProduto);
            telaBusCaracteristicaProduto.setVisible(true);
            
            CaracteristicaProduto caracteristicaProduto;
            CaracteristicaProdutoService caracteristicaProdutoService = new CaracteristicaProdutoService();
            caracteristicaProduto = caracteristicaProdutoService.buscar(codigo);

            ativa(false);

            this.telaVendas.getjTextFieldBarraProduto().setText(caracteristicaProduto.getBarraProduto());
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
