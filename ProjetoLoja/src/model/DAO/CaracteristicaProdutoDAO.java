package model.DAO;

import java.util.List;
import model.bo.CaracteristicaProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CaracteristicaProdutoDAO implements InterfaceDAO<CaracteristicaProduto>{

    

    @Override
    public void create(CaracteristicaProduto objeto) {
        //Abrindo conexão
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO caracteristicaProduto (produto_idproduto, cor_idcor, tamanhoProduto, barraProduto, qtdEstoqueProduto) VALUES(?, ?, ?, ?, ?)";
        PreparedStatement pstm = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, objeto.getProduto_idproduto().getIdproduto());
            pstm.setInt(2, objeto.getCor_idcor().getIdCor());
            pstm.setString(3, objeto.getTamanhoProduto());
            pstm.setString(4, objeto.getBarraProduto());
	    pstm.setFloat(5, objeto.getQtdEstoqueProduto());

            pstm.executeUpdate();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        //fechar a conexão
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public List<CaracteristicaProduto> retrieve() {
        String sqlExecutar     =   " SELECT idCaracterisitcaProduto, produto_idproduto, cor_idcor, tamanhoProduto, barraProduto, qtdEstoqueProduto"
                                 + " FROM caracteristicaProduto";
        
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        List<CaracteristicaProduto> caracteristicaProdutos = new ArrayList<>();
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();            
            
            while(rst.next()){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		CorDAO corDAO = new CorDAO();

                CaracteristicaProduto caracteristicaProduto = new CaracteristicaProduto();
                caracteristicaProduto.setIdCaracteristicaProduto(rst.getInt("idCaracterisitcaProduto"));
                caracteristicaProduto.setBarraProduto(rst.getString("barraProduto"));                                 
                caracteristicaProduto.setTamanhoProduto(rst.getString("tamanhoProduto"));
		caracteristicaProduto.setProduto_idproduto(produtoDAO.retrieve(rst.getInt("produto_idproduto")));   
		caracteristicaProduto.setCor_idcor(corDAO.retrieve(rst.getInt("cor_idcor")));
                caracteristicaProdutos.add(caracteristicaProduto);
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return caracteristicaProdutos;       
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

//    public List<CaracteristicaProduto> retrieveDesc(int cidadeMae) {
//
//        String sqlExecutar     =   " SELECT idbairro, "
//                                 + " descricaoBairro,"
//				 + " cidadeMae"
//                                 + " FROM bairro"
//				 + " WHERE bairro.cidadeMae = ?";
//        
//        Connection conexao     = ConnectionFactory.getConnection();
//        PreparedStatement pstm = null;
//        ResultSet rst          = null;
//        List<Bairro> bairros = new ArrayList<>();
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setInt(1, cidadeMae);
//	    rst = pstm.executeQuery();  
//
//            while(rst.next()){
//                Bairro bairro = new Bairro();
//                bairro.setIdBairro(rst.getInt("idbairro"));
//                bairro.setDescricaoBairro(rst.getString("descricaoBairro"));                
//		bairro.setCidadeMae(rst.getInt("cidadeMae"));
//                bairros.add(bairro);
//            }
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//	    System.out.println("TESTEEEEE: " + cidadeMae);
//
//            return bairros;       
//        } catch(Exception ex){
//            ex.printStackTrace();
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return null;
//        }
//    }


    @Override
    public CaracteristicaProduto retrieve(int codigo) {
        String sqlExecutar     =   " SELECT idCaracterisitcaProduto, produto_idproduto, cor_idcor, tamanhoProduto, barraProduto, qtdEstoqueProduto"
                                 + " FROM caracteristicaProduto"
                                 + " WHERE caracteristicaProduto.idCaracterisitcaProduto = ?";
        
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, codigo);
            
            rst = pstm.executeQuery();  
            CaracteristicaProduto caracteristicaProduto = new CaracteristicaProduto();
            while(rst.next()){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		CorDAO corDAO = new CorDAO();
                caracteristicaProduto.setIdCaracteristicaProduto(rst.getInt("idCaracterisitcaProduto"));
                caracteristicaProduto.setBarraProduto(rst.getString("barraProduto"));                                 
                caracteristicaProduto.setTamanhoProduto(rst.getString("tamanhoProduto"));
		caracteristicaProduto.setProduto_idproduto(produtoDAO.retrieve(rst.getInt("produto_idproduto")));   
		caracteristicaProduto.setCor_idcor(corDAO.retrieve(rst.getInt("cor_idcor")));
		caracteristicaProduto.setQtdEstoqueProduto(rst.getInt("qtdEstoqueProduto"));
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return caracteristicaProduto; 
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
          
    }

    @Override
    public CaracteristicaProduto retrieve(String codBarra) {
        String sqlExecutar     =   " SELECT idCaracterisitcaProduto, produto_idproduto, cor_idcor, tamanhoProduto, barraProduto, qtdEstoqueProduto"
                                 + " FROM caracteristicaProduto"
                                 + " WHERE caracteristicaProduto.barraProduto = ?";
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, codBarra);
            rst = pstm.executeQuery();  
            CaracteristicaProduto caracteristicaProduto = new CaracteristicaProduto();
            
            while(rst.next()){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		CorDAO corDAO = new CorDAO();
                caracteristicaProduto.setIdCaracteristicaProduto(rst.getInt("idCaracterisitcaProduto"));
                caracteristicaProduto.setBarraProduto(rst.getString("barraProduto"));                                 
                caracteristicaProduto.setTamanhoProduto(rst.getString("tamanhoProduto"));
		caracteristicaProduto.setProduto_idproduto(produtoDAO.retrieve(rst.getInt("produto_idproduto"))); 
		caracteristicaProduto.setCor_idcor(corDAO.retrieve(rst.getInt("cor_idcor")));
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);

            return caracteristicaProduto; 
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }  
    }

    @Override
    public void update(CaracteristicaProduto objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " UPDATE caracteristicaProduto "
                           + " SET produto_idProduto = ? ,"
			   + " cor_idcor = ?,"
			   + " tamanhoProduto = ?,"
			   + " BarraProduto = ?,"
			   + " qtdEstoqueProduto = ?"
                           + " WHERE caracteristicaProduto.idCaracterisitcaProduto = ?";

        PreparedStatement pstm = null;
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
	    pstm.setInt(1, objeto.getProduto_idproduto().getIdproduto());
            pstm.setInt(2, objeto.getCor_idcor().getIdCor());
            pstm.setString(3, objeto.getTamanhoProduto());
            pstm.setString(4, objeto.getBarraProduto());
	    pstm.setFloat(5, objeto.getQtdEstoqueProduto());
	    pstm.setInt(6, objeto.getIdCaracteristicaProduto());

            pstm.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public void delete(CaracteristicaProduto objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " DELETE FROM caracteristicaProduto WHERE caracteristicaProduto.idCaracterisitcaProduto = ? ";
        PreparedStatement ptsm = null;
        try {
            ptsm = conexao.prepareStatement(sqlExecutar);
            ptsm.setInt(1, objeto.getIdCaracteristicaProduto());
            ptsm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, ptsm);
   }
    
}
