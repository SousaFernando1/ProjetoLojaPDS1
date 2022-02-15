package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.bo.Marca;
import service.MarcaService;
import view.TelaBusMarca;
public class ControllerBusMarca implements ActionListener{
    
    TelaBusMarca telaBusMarca;

    public ControllerBusMarca(TelaBusMarca telaBusMarca) {
        
        this.telaBusMarca = telaBusMarca;
        
        telaBusMarca.getjButtonCarregar().addActionListener(this);
        telaBusMarca.getjButtonSair().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.telaBusMarca.getjTable1().getModel();
        
        MarcaService marcaService = new MarcaService();        
        for (Marca marcaAtualDaLista : marcaService.buscar()) {
            tabela.addRow(new Object[]{ marcaAtualDaLista.getIdMarca(), 
                                        marcaAtualDaLista.getDescricaoMarca()});
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaBusMarca.getjButtonCarregar()){
         ControllerCadMarca.codigo = 
         (int)this.telaBusMarca.getjTable1().getValueAt(this.telaBusMarca.getjTable1().getSelectedRow(), 0);
         this.telaBusMarca.dispose();
        }else if(e.getSource() == this.telaBusMarca.getjButtonSair()){
            this.telaBusMarca.dispose();
        }
    }
}