/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.bo.Vendedor;

/**
 *
 * @author gusta
 */
public class VendedorDAO implements InterfaceDAO<Vendedor>{
    
    @Override
    public void create(Vendedor objeto) {
        //Abrindo conexão
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO vendedor (nomeVendedor, cpfVendedor, emailVendedor, foneVendedor, fone2Vendedor, percentComissaoVenda, percentComissaoRecebto, compleEnderecoVendedor, endereco_idcep) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getCpfVendedor());
            pstm.setString(3, objeto.getEmail());
            pstm.setString(4, objeto.getFoneVendedor());
            pstm.setString(5, objeto.getFone2Vendedor());
            pstm.setFloat(6, objeto.getPercentComissaoVenda());
            pstm.setFloat(7, objeto.getPercentComissaoRecebto());
            pstm.setString(8, objeto.getCompleEndereco());
            pstm.setInt(9, objeto.getEndereco_idcep().getIdCep());

            pstm.executeUpdate();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        //fechar a conexão
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public List<Vendedor> retrieve() {
        String sqlExecutar     =   " SELECT idvendedor, "
                                   + "nomeVendedor, "
				   + "cpfVendedor, "
				   + "emailVendedor, "
				   + "foneVendedor, "
				   + "fone2Vendedor, "
				   + "percentComissaoVenda, "
				   + "percentComissaoRecebto, "
                                   + "compleEnderecoVendedor, "
				   + "endereco_idcep "
				   + " FROM vendedor";
        
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        List<Vendedor> vendedores = new ArrayList<>();
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();            
            
            while(rst.next()){
                Vendedor vendedor = new Vendedor();
                vendedor.setIdvendedor(rst.getInt("idvendedor"));
                vendedor.setNome(rst.getString("nomeVendedor"));
                vendedor.setCpfVendedor(rst.getString("cpfVendedor"));
                vendedor.setEmail(rst.getString("emailVendedor"));
                vendedor.setFoneVendedor(rst.getString("foneVendedor"));
                vendedor.setFone2Vendedor(rst.getString("fone2Vendedor"));
                vendedor.setPercentComissaoVenda(rst.getFloat("percentComissaoVenda"));
                vendedor.setPercentComissaoRecebto(rst.getFloat("percentComissaoRecebto"));
                vendedor.setCompleEndereco(rst.getString("compleEnderecoVendedor"));

		System.out.println(rst.getString("endereco_idcep"));

                EnderecoDAO endereco = new EnderecoDAO();
                vendedor.setEndereco_idcep(endereco.retrieve(rst.getString("endereco_idcep")));
                
                vendedores.add(vendedor);
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return vendedores;       
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }
    @Override
    public Vendedor retrieve(int codigo) {
        String sqlExecutar     =   " SELECT idvendedor, "
                                   + "nomeVendedor, "
				   + "cpfVendedor, "
				   + "emailVendedor, "
				   + "foneVendedor, "
				   + "fone2Vendedor, "
				   + "percentComissaoVenda, "
				   + "percentComissaoRecebto, "
                                   + "compleEnderecoVendedor, "
				   + "endereco_idcep "
				   + " FROM vendedor "
                                   + "WHERE vendedor.idvendedor = ?";
        
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, codigo);
            
            rst = pstm.executeQuery();  
            Vendedor vendedor = new Vendedor();
            while(rst.next()){
                vendedor.setIdvendedor(rst.getInt("idvendedor"));
                vendedor.setNome(rst.getString("nomeVendedor"));
                vendedor.setCpfVendedor(rst.getString("cpfVendedor"));
                vendedor.setEmail(rst.getString("emailVendedor"));
                vendedor.setFoneVendedor(rst.getString("foneVendedor"));
                vendedor.setFone2Vendedor(rst.getString("fone2Vendedor"));
                vendedor.setPercentComissaoVenda(rst.getFloat("percentComissaoVenda"));
                vendedor.setPercentComissaoRecebto(rst.getFloat("percentComissaoRecebto"));
                vendedor.setCompleEndereco(rst.getString("compleEnderecoVendedor"));

		System.out.println(rst.getString("endereco_idcep"));

                EnderecoDAO endereco = new EnderecoDAO();
                vendedor.setEndereco_idcep(endereco.retrieve(rst.getString("endereco_idcep")));
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return vendedor; 
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
          
    }

    @Override
    public Vendedor retrieve(String nomeVendedor) {
        String sqlExecutar     =   " SELECT idvendedor, "
                                   + "nomeVendedor, "
				   + "cpfVendedor, "
				   + "emailVendedor, "
				   + "foneVendedor, "
				   + "fone2Vendedor, "
				   + "percentComissaoVenda, "
				   + "percentComissaoRecebto, "
                                   + "compleEnderecoVendedor, "
				   + "endereco_idcep "
				   + " FROM vendedor"
                                   + "WHERE vendedor.nomeVendedor = ?";
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, nomeVendedor);
            rst = pstm.executeQuery();  
            Vendedor vendedor = new Vendedor();
            
            while(rst.next()){
                vendedor.setIdvendedor(rst.getInt("idvendedor"));
                vendedor.setNome(rst.getString("nomeVendedor"));
                vendedor.setCpfVendedor(rst.getString("cpfVendedor"));
                vendedor.setEmail(rst.getString("emailVendedor"));
                vendedor.setFoneVendedor(rst.getString("foneVendedor"));
                vendedor.setFone2Vendedor(rst.getString("fone2Vendedor"));
                vendedor.setPercentComissaoVenda(rst.getFloat("percentComissaoVenda"));
                vendedor.setPercentComissaoRecebto(rst.getFloat("percentComissaoRecebto"));
                vendedor.setCompleEndereco(rst.getString("compleEnderecoVendedor"));

		System.out.println(rst.getString("endereco_idcep"));

                EnderecoDAO endereco = new EnderecoDAO();
                vendedor.setEndereco_idcep(endereco.retrieve(rst.getString("endereco_idcep")));
}
            ConnectionFactory.closeConnection(conexao, pstm, rst);

            return vendedor; 
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }  
    }

    @Override
    public void update(Vendedor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " UPDATE vendedor "
			     + "SET nomeVendedor = ?, "
			     + "cpfVendedor = ?, "
			     + "emailVendedor = ?, "
			     + "foneVendedor = ?, "
			     + "fone2Vendedor = ?, "
			     + "percentComissaoVenda = ?, "
                             + "percentComissaoRecebto = ?, "
                             + "compleEnderecoVendedor = ?, "
			     + "endereco_idcep = ? "
			     + "WHERE vendedor.idvendedor = ?";
        PreparedStatement pstm = null;
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getCpfVendedor());
            pstm.setString(3, objeto.getEmail());
            pstm.setString(4, objeto.getFoneVendedor());
            pstm.setString(5, objeto.getFone2Vendedor());
            pstm.setFloat(6, objeto.getPercentComissaoVenda());
            pstm.setFloat(7, objeto.getPercentComissaoRecebto());
            pstm.setString(8, objeto.getCompleEndereco());
            pstm.setInt(9, objeto.getEndereco_idcep().getIdCep());
             pstm.setInt(10, objeto.getIdvendedor());
	    pstm.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public void delete(Vendedor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " DELETE FROM vendedor WHERE vendedor.idvendedor = ? ";
        PreparedStatement ptsm = null;
        try {
            ptsm = conexao.prepareStatement(sqlExecutar);
            ptsm.setInt(1, objeto.getIdvendedor());
            ptsm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, ptsm);
   }
}
