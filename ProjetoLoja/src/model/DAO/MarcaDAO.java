package model.DAO;

import java.util.List;
import model.bo.Marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MarcaDAO implements InterfaceDAO<Marca>{

    @Override
    public void create(Marca objeto) {
        //Abrindo conexão
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO marca (descricaoMarca) VALUES(?)";
        PreparedStatement pstm = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricaoMarca());
            pstm.executeUpdate();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        //fechar a conexão
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public List<Marca> retrieve() {
        String sqlExecutar     =   " SELECT idmarca, "
                                 + " descricaoMarca  "
                                 + " FROM marca";
        
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        List<Marca> marcas = new ArrayList<>();
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();            
            
            while(rst.next()){
                Marca marca = new Marca();
                marca.setIdMarca(rst.getInt("idmarca"));
                marca.setDescricaoMarca(rst.getString("descricaoMarca"));
                marcas.add(marca);
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return marcas;       
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }
    @Override
    public Marca retrieve(int codigo) {
        String sqlExecutar     =  " SELECT idmarca, "
                                 + " descricaoMarca  "
                                 + " FROM marca"
                                 + " WHERE marca.idmarca = ?";
        
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, codigo);
            
            rst = pstm.executeQuery();  

            Marca marca = new Marca();
            while(rst.next()){
                marca.setIdMarca(rst.getInt("idmarca"));
                marca.setDescricaoMarca(rst.getString("descricaoMarca"));
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return marca; 
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
          
    }

    @Override
    public Marca retrieve(String descricao) {
        String sqlExecutar     =   " SELECT idmarca, "
                                 + " descricaoMarca  "
                                 + " FROM marca"
                                 + " WHERE marca.descricaoMarca = ?";
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, descricao);
            rst = pstm.executeQuery();  
            Marca marca = new Marca();
            
            while(rst.next()){
                marca.setIdMarca(rst.getInt("idmarca"));
                marca.setDescricaoMarca(rst.getString("descricaoMarca"));
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);

            return marca; 
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }  
    }

    @Override
    public void update(Marca objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " UPDATE marca "
                           + " SET descricaoMarca   = ? "
                           + " WHERE marca.idmarca = ? ";
        PreparedStatement pstm = null;
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricaoMarca());
            pstm.setInt(2, objeto.getIdMarca());
            pstm.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public void delete(Marca objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " DELETE FROM marca WHERE marca.idmarca= ? ";
        PreparedStatement ptsm = null;
        try {
            ptsm = conexao.prepareStatement(sqlExecutar);
            ptsm.setInt(1, objeto.getIdMarca());
            ptsm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, ptsm);
   }
    
}
