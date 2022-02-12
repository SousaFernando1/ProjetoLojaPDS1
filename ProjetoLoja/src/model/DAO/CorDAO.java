package model.DAO;

import java.util.List;
import model.bo.Cor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CorDAO implements InterfaceDAO<Cor>{

    @Override
    public void create(Cor objeto) {
        //Abrindo conexão
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO cor (descricaoCor) VALUES(?)";
        PreparedStatement pstm = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricaoCor());
            pstm.executeUpdate();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        //fechar a conexão
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public List<Cor> retrieve() {
        String sqlExecutar     =   " SELECT idcor, "
                                 + " descricaoCor  "
                                 + " FROM cor";
        
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        List<Cor> cores = new ArrayList<>();
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();            
            
            while(rst.next()){
                Cor cor = new Cor();
                cor.setIdCor(rst.getInt("idcor"));
                cor.setDescricaoCor(rst.getString("descricaoCor"));
                cores.add(cor);
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return cores;       
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }
    @Override
    public Cor retrieve(int codigo) {
        String sqlExecutar     =  " SELECT idcor, "
                                 + " descricaoCor  "
                                 + " FROM cor"
                                 + " WHERE cor.idcor = ?";
        
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, codigo);
            
            rst = pstm.executeQuery();  

            Cor cor = new Cor();
            while(rst.next()){
                cor.setIdCor(rst.getInt("idcor"));
                cor.setDescricaoCor(rst.getString("descricaoCor"));
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return cor; 
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
          
    }

    @Override
    public Cor retrieve(String descricao) {
        String sqlExecutar     =   " SELECT idcor, "
                                 + " descricaoCor  "
                                 + " FROM cor"
                                 + " WHERE cor.descricaoCor = ?";
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, descricao);
            rst = pstm.executeQuery();  
            Cor cor = new Cor();
            
            while(rst.next()){
                cor.setIdCor(rst.getInt("idcor"));
                cor.setDescricaoCor(rst.getString("descricaoCor"));
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);

            return cor; 
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }  
    }

    @Override
    public void update(Cor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " UPDATE cor "
                           + " SET descricaoCor   = ? "
                           + " WHERE cor.idcor = ? ";
        PreparedStatement pstm = null;
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricaoCor());
            pstm.setInt(2, objeto.getIdCor());
            pstm.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public void delete(Cor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " DELETE FROM cor WHERE cor.idcor = ? ";
        PreparedStatement ptsm = null;
        try {
            ptsm = conexao.prepareStatement(sqlExecutar);
            ptsm.setInt(1, objeto.getIdCor());
            ptsm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, ptsm);
   }
    
}
