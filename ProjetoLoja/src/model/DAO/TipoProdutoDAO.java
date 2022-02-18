package model.DAO;

import java.util.List;
import model.bo.TipoProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TipoProdutoDAO implements InterfaceDAO<TipoProduto>{

    @Override
    public void create(TipoProduto objeto) {
        //Abrindo conexão
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO tipoProduto (descricaoTipoProduto) VALUES(?) ";
        PreparedStatement pstm = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricaoTipoProduto());
            pstm.executeUpdate();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        //fechar a conexão
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public List<TipoProduto> retrieve() {
        String sqlExecutar     =   " SELECT idtipoProduto, "
                                 + " descricaoTipoProduto"
                                 + " FROM tipoProduto";
        
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        List<TipoProduto> tipos = new ArrayList<>();
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();            
            
            while(rst.next()){
                TipoProduto tipoProduto = new TipoProduto();
                tipoProduto.setIdTipoProduto(rst.getInt("idtipoProduto"));
                tipoProduto.setDescricaoTipoProduto(rst.getString("descricaoTipoProduto"));                
                tipos.add(tipoProduto);
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return tipos;       
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }
    @Override
    public TipoProduto retrieve(int codigo) {
        String sqlExecutar     =   " SELECT idtipoProduto, "
                                 + " descricaoTipoProduto"
                                 + " FROM tipoProduto "
                                 + " WHERE tipoProduto.idtipoProduto= ?";
        
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, codigo);
            
            rst = pstm.executeQuery();  
            TipoProduto tipoProduto = new TipoProduto();
            while(rst.next()){
                tipoProduto.setIdTipoProduto(rst.getInt("idtipoProduto"));
                tipoProduto.setDescricaoTipoProduto(rst.getString("descricaoTipoProduto"));
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return tipoProduto; 
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
          
    }

    @Override
    public TipoProduto retrieve(String descricao) {
        String sqlExecutar     =   " SELECT idtipoProduto, descricaoTipoProduto"
                                 + " FROM tipoProduto"
                                 + " WHERE tipoProduto.descricaoTipoProduto= ?";
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, descricao);
            rst = pstm.executeQuery();  
            TipoProduto tipoProduto = new TipoProduto();
            
            while(rst.next()){
                tipoProduto.setIdTipoProduto(rst.getInt("idtipoProduto"));
                tipoProduto.setDescricaoTipoProduto(rst.getString("descricaoTipoProduto"));
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);

            return tipoProduto; 
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }  
    }

    @Override
    public void update(TipoProduto objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " UPDATE tipoProduto "
                           + " SET descricaoTipoProduto = ? "
                           + " WHERE tipoProduto.idtipoProduto = ? ";
        PreparedStatement pstm = null;
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricaoTipoProduto());
            pstm.setInt(2, objeto.getIdTipoProduto());
            pstm.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public void delete(TipoProduto objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " DELETE FROM tipoProduto WHERE tipoProduto.idtipoProduto= ? ";
        PreparedStatement ptsm = null;
        try {
            ptsm = conexao.prepareStatement(sqlExecutar);
            ptsm.setInt(1, objeto.getIdTipoProduto());
            ptsm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, ptsm);
   }
    
}
