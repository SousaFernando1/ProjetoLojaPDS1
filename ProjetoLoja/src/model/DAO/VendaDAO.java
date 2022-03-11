package model.DAO;

import java.util.List;
import model.bo.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class VendaDAO {

    public void create(Venda objeto) {
        //Abrindo conexão
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO venda (serieVenda, dtVenda, hrVenda, valDescontoVenda, valTotalVenda, cliente_idcliente, condicaoPagamento_idcondicaoPagamento, vendedor_idvendedor, diaVencimentoParcela) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getSerieVenda());
            pstm.setString(2, objeto.getDtVenda());
            pstm.setString(3, objeto.getHrVenda());
            pstm.setFloat(4, objeto.getValDescontoVenda());
            pstm.setFloat(5, objeto.getValTotalVenda());
            pstm.setInt(6, objeto.getCliente_idcliente().getIdcliente());
            pstm.setInt(7, objeto.getCondicaoPagamento_idcondicaoPagamento().getIdcondicaoPagamento());
            pstm.setInt(8, objeto.getVendedor_idvendedor().getIdvendedor());
            pstm.setInt(9, objeto.getDiaVencimentoParcela());



            pstm.executeUpdate();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        //fechar a conexão
        ConnectionFactory.closeConnection(conexao, pstm);
    }



   

   

    
}
