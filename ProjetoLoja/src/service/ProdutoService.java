package service;

import controller.InterfaceService;
import java.util.List;
import model.DAO.ProdutoDAO;
import model.bo.Produto;

public class ProdutoService implements InterfaceService<Produto> {

    @Override
    public  void salvar(Produto objeto) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.create(objeto);
    }

    @Override
    public List<Produto> buscar() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.retrieve();
    }

    @Override
    public Produto buscar(int codigo) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.retrieve(codigo);
    }

    @Override
    public Produto buscar(String descricao) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.retrieve(descricao);
    }

    @Override
    public void atualizar(Produto objeto) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.update(objeto);
    }

    @Override
    public void apagar(Produto objeto) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.delete(objeto);
    }

}
