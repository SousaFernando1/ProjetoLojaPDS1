package model.DAO;

import java.util.List;
import model.bo.FoneFornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FoneFornecedorDAO implements InterfaceDAO<FoneFornecedor>{

    @Override
    public void create(FoneFornecedor objeto) {
        //Abrindo conexão
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO foneFornecedor (foneFornecedor) VALUES(?)";
        PreparedStatement pstm = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getFoneFornecedor());
            pstm.executeUpdate();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        //fechar a conexão
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public List<FoneFornecedor> retrieve() {
        String sqlExecutar     =   " SELECT foneFornecedor"
                                 + " FROM foneFornecedor";
        
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        List<FoneFornecedor> fones = new ArrayList<>();
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();            
            
            while(rst.next()){
                FoneFornecedor foneFornecedor = new FoneFornecedor();
                foneFornecedor.setFoneFornecedor(rst.getString("foneFornecedor"));
                fones.add(foneFornecedor);
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return fones;       
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }
    @Override
    public FoneFornecedor retrieve(int codigo) {
        String sqlExecutar     =  " SELECT foneFornecedor,"
				 + " fornecedor_idfornecedor"
                                 + " FROM foneFornecedor"
                                 + " WHERE foneFornecedor.foneFornecedor = ?";
        
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, codigo);
            
            rst = pstm.executeQuery();  

            FoneFornecedor foneFornecedor = new FoneFornecedor();
            while(rst.next()){
                foneFornecedor.setFoneFornecedor(rst.getString("foneFornecedor"));
//                foneFornecedor.setFornecedor_idFornecedor(rst.getObject("fornecedor_idfornecedor"));
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return foneFornecedor; 
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
          
    }

    @Override
    public FoneFornecedor retrieve(String descricao) {
        String sqlExecutar     =   " SELECT foneFornecedor, "
				 + "fornecedor_idfornecedor"
                                 + " FROM foneFornecedor"
                                 + " WHERE foneFornecedor.foneFornecedor = ?";
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, descricao);
            rst = pstm.executeQuery();  
            FoneFornecedor foneFornecedor = new FoneFornecedor();
            
            while(rst.next()){
                foneFornecedor.setFoneFornecedor(rst.getString("foneFornecedor"));
//                foneFornecedor.setFornecedor_idfornecedor(rst.getString("fornecedor_idfornecedor"));
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);

            return foneFornecedor; 
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }  
    }

    @Override
    public void update(FoneFornecedor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " UPDATE foneFornecedor "
                           + " SET foneFornecedor   = ?,"
			   + " fornecedor_idfornecedor = ?"
                           + " WHERE foneFornecedor = ? ";
        PreparedStatement pstm = null;
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getFoneFornecedor());
            pstm.setObject(2, objeto.getFornecedor_idfornecedor());
            pstm.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public void delete(FoneFornecedor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " DELETE FROM foneFornecedor WHERE foneFornecedor.foneFornecedor = ? ";
        PreparedStatement ptsm = null;
        try {
            ptsm = conexao.prepareStatement(sqlExecutar);
            ptsm.setString(1, objeto.getFoneFornecedor());
            ptsm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, ptsm);
   }
    
}
