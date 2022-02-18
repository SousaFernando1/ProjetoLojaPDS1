package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.bo.Cliente;
import service.ClienteService;
import view.TelaBusCliente;
public class ControllerBusCliente implements ActionListener{
    
    TelaBusCliente telaBusCliente;

    public ControllerBusCliente(TelaBusCliente telaBusCliente) {
        
        this.telaBusCliente = telaBusCliente;
        
        telaBusCliente.getjButtonCarregar().addActionListener(this);
        telaBusCliente.getjButtonSair().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.telaBusCliente.getjTable1().getModel();
        
        ClienteService clienteService = new ClienteService();        
        for (Cliente clienteAtualDaLista : clienteService.buscar()) {
	    System.out.println("AQUI"+clienteAtualDaLista.getEndereco_idcep().getIdCep());
            tabela.addRow(new Object[]{ clienteAtualDaLista.getIdcliente(), 
                                        clienteAtualDaLista.getNome(),
                                        clienteAtualDaLista.getCpfCliente(),
					clienteAtualDaLista.getRgCliente(),
					clienteAtualDaLista.getDtNascCliente(),
					clienteAtualDaLista.getEmail(),
					clienteAtualDaLista.getEndereco_idcep().getIdCep(),
					clienteAtualDaLista.getFoneCliente(),

});
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaBusCliente.getjButtonCarregar()){
         ControllerCadCidade.codigo = 
         (int)this.telaBusCliente.getjTable1().getValueAt(this.telaBusCliente.getjTable1().getSelectedRow(), 0);
         this.telaBusCliente.dispose();
        }else if(e.getSource() == this.telaBusCliente.getjButtonSair()){
            this.telaBusCliente.dispose();
        }
    }
}