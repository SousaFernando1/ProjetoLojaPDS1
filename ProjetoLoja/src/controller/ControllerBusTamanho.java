package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.bo.Tamanho;
import service.TamanhoService;
import view.TelaBusTamanho;
public class ControllerBusTamanho implements ActionListener{
    
    TelaBusTamanho telaBusTamanho;

    public ControllerBusTamanho(TelaBusTamanho telaBusTamanho) {
        
        this.telaBusTamanho = telaBusTamanho;
        
        telaBusTamanho.getjButtonCarregar().addActionListener(this);
        telaBusTamanho.getjButtonSair().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.telaBusTamanho.getjTable1().getModel();
        
        TamanhoService tamanhoService = new TamanhoService();        
        for (Tamanho tamanhoAtualDaLista : tamanhoService.buscar()) {
            tabela.addRow(new Object[]{ tamanhoAtualDaLista.getIdTamanho(), 
                                        tamanhoAtualDaLista.getDescricaoTamanho()});
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaBusTamanho.getjButtonCarregar()){
         ControllerCadTamanho.codigo = 
         (int)this.telaBusTamanho.getjTable1().getValueAt(this.telaBusTamanho.getjTable1().getSelectedRow(), 0);
         this.telaBusTamanho.dispose();
        }else if(e.getSource() == this.telaBusTamanho.getjButtonSair()){
            this.telaBusTamanho.dispose();
        }
    }
}