package model.DAO;

import java.util.List;
import model.bo.CondicaoPagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CondicaoPagamentoDAO implements InterfaceDAO<CondicaoPagamento>{

    @Override
    public void create(CondicaoPagamento objeto) {
        //Abrindo conexão
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO condicaoPagamento (descricaoCondicaoPagamento, numDiasAtePrimeiraParcela, numDiasEntreParcelas) VALUES(?, ?, ?)";
        PreparedStatement pstm = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricaoCondicaoPagamento());            
	    pstm.setInt(2, objeto.getNumDiasAtePrimeiraParcela());
            pstm.setInt(3, objeto.getNumDiasEntreParcelas());

            pstm.executeUpdate();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        //fechar a conexão
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public List<CondicaoPagamento> retrieve() {
        String sqlExecutar     =   " SELECT idcondicaoPagamento, "
                                 + " descricaoCondicaoPagamento,"
				 + " numDiasAtePrimeiraParcela,"
				 + " numDiasEntreParcelas"
                                 + " FROM condicaoPagamento";
        
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        List<CondicaoPagamento> condicoes = new ArrayList<>();
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();            
            
            while(rst.next()){
                CondicaoPagamento condicaoPagamento = new CondicaoPagamento();
                condicaoPagamento.setIdcondicaoPagamento(rst.getInt("idcondicaoPagamento"));
                condicaoPagamento.setDescricaoCondicaoPagamento(rst.getString("descricaoCondicaoPagamento"));
                condicaoPagamento.setNumDiasAtePrimeiraParcela(rst.getInt("NumDiasAtePrimeiraParcela"));
                condicaoPagamento.setNumDiasEntreParcelas(rst.getInt("NumDiasEntreParcelas"));
                condicoes.add(condicaoPagamento);
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return condicoes;       
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }
    @Override
    public CondicaoPagamento retrieve(int codigo) {
        String sqlExecutar     =  " SELECT idcondicaoPagamento, "
                                 + " descricaoCondicaoPagamento,  "
				 + " numDiasAtePrimeiraParcela,"
				 + " numDiasEntreParcelas"
                                 + " FROM condicaoPagamento"
                                 + " WHERE condicaoPagamento.idcondicaoPagamento = ?";
        
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, codigo);
            
            rst = pstm.executeQuery();  

            CondicaoPagamento condicaoPagamento = new CondicaoPagamento();
            while(rst.next()){
                condicaoPagamento.setIdcondicaoPagamento(rst.getInt("idcondicaoPagamento"));
                condicaoPagamento.setDescricaoCondicaoPagamento(rst.getString("descricaoCondicaoPagamento"));
		condicaoPagamento.setNumDiasAtePrimeiraParcela(rst.getInt("NumDiasAtePrimeiraParcela"));
                condicaoPagamento.setNumDiasEntreParcelas(rst.getInt("NumDiasEntreParcelas"));
	     }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return condicaoPagamento; 
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
          
    }

    @Override
    public CondicaoPagamento retrieve(String descricao) {
        String sqlExecutar     =   " SELECT idcondicaoPagamento, "
                                 + " descricaoCondicaoPagamento,  "
				 + " numDiasAtePrimeiraParcela,"
				 + " numDiasEntreParcelas"
                                 + " FROM condicaoPagamento"
                                 + " WHERE condicaoPagamento.descricaoCondicaoPagamento = ?";
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, descricao);
            rst = pstm.executeQuery();  
            CondicaoPagamento condicaoPagamento= new CondicaoPagamento();
            
            while(rst.next()){
                condicaoPagamento.setIdcondicaoPagamento(rst.getInt("idcondicaoPagamento"));
                condicaoPagamento.setDescricaoCondicaoPagamento(rst.getString("descricaoCondicaoPagamento"));
		condicaoPagamento.setNumDiasAtePrimeiraParcela(rst.getInt("NumDiasAtePrimeiraParcela"));
                condicaoPagamento.setNumDiasEntreParcelas(rst.getInt("NumDiasEntreParcelas"));
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);

            return condicaoPagamento; 
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }  
    }

    @Override
    public void update(CondicaoPagamento objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " UPDATE condicaoPagamento "
                           + " SET descricaoCndicaoPagamento   = ? "
			   + " numDiasAtePrimeiraParcela = ?,"
			   + " numDiasEntreParcelas = ?"
                           + " FROM condicaoPagamento = ? "
                           + " WHERE condicaoPagamento.idcondicaoPagamento = ? ";
        PreparedStatement pstm = null;
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, objeto.getIdcondicaoPagamento());            
            pstm.setString(2, objeto.getDescricaoCondicaoPagamento());            
	    pstm.setInt(3, objeto.getNumDiasAtePrimeiraParcela());
            pstm.setInt(4, objeto.getNumDiasEntreParcelas());
            pstm.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public void delete(CondicaoPagamento objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " DELETE FROM condicaoPagamento WHERE condicaoPagamento.idcondicaoPagamento = ? ";
        PreparedStatement ptsm = null;
        try {
            ptsm = conexao.prepareStatement(sqlExecutar);
            ptsm.setInt(1, objeto.getIdcondicaoPagamento());
            ptsm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, ptsm);
   }
    
}
