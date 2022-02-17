package model.DAO;

import java.util.List;
import model.bo.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EnderecoDAO implements InterfaceDAO<Endereco>{

    @Override
    public void create(Endereco objeto) {
        //Abrindo conexão
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO endereco (cepCep, cidade_idcidade, bairro_idbairro, logradouroCep) VALUES(?, ?, ?, ?)";
        PreparedStatement pstm = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getCepCep());
            pstm.setInt(2, objeto.getCidade().getIdCidade());
            pstm.setInt(3, objeto.getBairro().getIdBairro());
            pstm.setString(4, objeto.getLogradouroCep());


            pstm.executeUpdate();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        //fechar a conexão
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public List<Endereco> retrieve() {
        String sqlExecutar     =   " SELECT idcep, cepCep, "
                                 +   "bairro_idbairro, cidade_idcidade, logradouroCep"
                                 + " FROM endereco";
        
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        List<Endereco> enderecos = new ArrayList<>();
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();            
            
            while(rst.next()){
                Endereco endereco = new Endereco();
                endereco.setIdCep(rst.getInt("idcep"));
                endereco.setCepCep(rst.getString("cepCep"));              
                endereco.setLogradouroCep(rst.getString("logradouroCep"));              

		BairroDAO bairroDAO = new BairroDAO();		
		endereco.setBairro(bairroDAO.retrieve(rst.getInt("bairro_idbairro")));
                
		CidadeDAO cidadeDAO = new CidadeDAO();
		endereco.setCidade(cidadeDAO.retrieve(rst.getInt("cidade_idCidade")));

		enderecos.add(endereco);
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return enderecos;       
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

      public List<Endereco> retrieveCidade(int cidade) {

        String sqlExecutar     =   " SELECT idcep, cepCep, "
                                 +   "bairro_idbairro, cidade_idcidade, logradouroCep"
                                 + " FROM endereco WHERE endereco.cidade_idcidade = ?";
        
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        List<Endereco> enderecos = new ArrayList<>();
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, cidade);


            rst = pstm.executeQuery();            
            
            while(rst.next()){
                Endereco endereco = new Endereco();
                endereco.setIdCep(rst.getInt("idcep"));
                endereco.setCepCep(rst.getString("cepCep"));              
                endereco.setLogradouroCep(rst.getString("logradouroCep"));              

		BairroDAO bairroDAO = new BairroDAO();		
		endereco.setBairro(bairroDAO.retrieve(rst.getInt("bairro_idbairro")));
                
		CidadeDAO cidadeDAO = new CidadeDAO();
		endereco.setCidade(cidadeDAO.retrieve(rst.getInt("cidade_idCidade")));

		enderecos.add(endereco);
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return enderecos;       
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public Endereco retrieve(int codigo) {
        String sqlExecutar     =   " SELECT idcep, cepCep, "
                                 +   "bairro_idbairro, cidade_idcidade, logradouroCep"
                                 + " FROM endereco WHERE endereco.idcep = ?";
        
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, codigo);
            
            rst = pstm.executeQuery();  
            Endereco endereco = new Endereco();
            while(rst.next()){
                endereco.setIdCep(rst.getInt("idcep"));
                endereco.setCepCep(rst.getString("cepCep"));              
                endereco.setLogradouroCep(rst.getString("logradouroCep"));              

		BairroDAO bairroDAO = new BairroDAO();		
		endereco.setBairro(bairroDAO.retrieve(rst.getInt("bairro_idbairro")));
                
		CidadeDAO cidadeDAO = new CidadeDAO();
		endereco.setCidade(cidadeDAO.retrieve(rst.getInt("cidade_idCidade")));

            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return endereco; 
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
          
    }

    @Override
    public Endereco retrieve(String descricao) {
        String sqlExecutar     =  " SELECT idcep, cepCep, "
                                 +   "bairro_idbairro, cidade_idcidade, logradouroCep"
                                 + " FROM endereco WHERE endereco.cepCep = ?";
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, descricao);
            rst = pstm.executeQuery();  
            Endereco endereco = new Endereco();
            
            while(rst.next()){
		endereco.setIdCep(rst.getInt("idcep"));
                endereco.setCepCep(rst.getString("cepCep"));              
                endereco.setLogradouroCep(rst.getString("logradouroCep"));              

		BairroDAO bairroDAO = new BairroDAO();		
		endereco.setBairro(bairroDAO.retrieve(rst.getInt("bairro_idbairro")));
                
		CidadeDAO cidadeDAO = new CidadeDAO();
		endereco.setCidade(cidadeDAO.retrieve(rst.getInt("cidade_idCidade")));
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);

            return endereco; 
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }  
    }

    @Override
    public void update(Endereco objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " UPDATE endereco "
                           + " SET cepCep = ? , logradouroCep = ?,"
			   + " cidade_idcidade = ?, bairro_idbairro = ?"
                           + " WHERE endereco_idcep = ? ";
        PreparedStatement pstm = null;
        try{
	    pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getCepCep());
            pstm.setString(2, objeto.getLogradouroCep());
            pstm.setInt(3, objeto.getCidade().getIdCidade());
            pstm.setInt(4, objeto.getBairro().getIdBairro());
            pstm.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public void delete(Endereco objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " DELETE FROM endereco WHERE endereco.idcep = ? ";
        PreparedStatement ptsm = null;
        try {
            ptsm = conexao.prepareStatement(sqlExecutar);
            ptsm.setInt(1, objeto.getIdCep());
            ptsm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, ptsm);
   }
    
}
