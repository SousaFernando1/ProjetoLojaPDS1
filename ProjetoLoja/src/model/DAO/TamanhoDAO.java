package model.DAO;

import java.util.List;
import model.bo.Tamanho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TamanhoDAO implements InterfaceDAO<Tamanho>{

    @Override
    public void create(Tamanho objeto) {
        //Abrindo conexão
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO tamanho (descricaoTamanho) VALUES(?)";
        PreparedStatement pstm = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricaoTamanho());
            pstm.executeUpdate();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        //fechar a conexão
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public List<Tamanho> retrieve() {
        String sqlExecutar     =   " SELECT idtamanho, "
                                 + " descricaoTamanho  "
                                 + " FROM tamanho";
        
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        List<Tamanho> tamanhos = new ArrayList<>();
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();            
            
            while(rst.next()){
                Tamanho tamanho = new Tamanho();
                tamanho.setIdTamanho(rst.getInt("idtamanho"));
                tamanho.setDescricaoTamanho(rst.getString("descricaoTamanho"));
                tamanhos.add(tamanho);
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return tamanhos;       
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }
    @Override
    public Tamanho retrieve(int codigo) {
        String sqlExecutar     =  " SELECT idtamanho, "
                                 + " descricaoTamanho  "
                                 + " FROM tamanho"
                                 + " WHERE tamanho.idtamanho = ?";
        
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, codigo);
            
            rst = pstm.executeQuery();  

            Tamanho tamanho = new Tamanho();
            while(rst.next()){
                tamanho.setIdTamanho(rst.getInt("idtamanho"));
                tamanho.setDescricaoTamanho(rst.getString("descricaoTamanho"));
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return tamanho; 
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
          
    }

    @Override
    public Tamanho retrieve(String descricao) {
        String sqlExecutar     =   " SELECT idtamanho, "
                                 + " descricaoTamanho  "
                                 + " FROM tamanho"
                                 + " WHERE tamanho.descricaoTamanho = ?";
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, descricao);
            rst = pstm.executeQuery();  
            Tamanho tamanho = new Tamanho();
            
            while(rst.next()){
                tamanho.setIdTamanho(rst.getInt("idtamanho"));
                tamanho.setDescricaoTamanho(rst.getString("descricaoTamanho"));
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);

            return tamanho; 
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }  
    }

    @Override
    public void update(Tamanho objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " UPDATE tamanho "
                           + " SET descricaoTamanho   = ? "
                           + " WHERE tamanho.idtamanho = ? ";
        PreparedStatement pstm = null;
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricaoTamanho());
            pstm.setInt(2, objeto.getIdTamanho());
            pstm.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public void delete(Tamanho objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " DELETE FROM tamanho WHERE tamanho.idtamanho = ? ";
        PreparedStatement ptsm = null;
        try {
            ptsm = conexao.prepareStatement(sqlExecutar);
            ptsm.setInt(1, objeto.getIdTamanho());
            ptsm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, ptsm);
   }
    
}
