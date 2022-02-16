package service;

import controller.InterfaceService;
import java.util.List;
import model.DAO.FornecedorDAO;
import model.bo.Fornecedor;

public class FornecedorService implements InterfaceService<Fornecedor> {

    @Override
    public  void salvar(Fornecedor objeto) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.create(objeto);
    }

    @Override
    public List<Fornecedor> buscar() {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.retrieve();
    }

    @Override
    public Fornecedor buscar(int codigo) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.retrieve(codigo);
    }

    @Override
    public Fornecedor buscar(String descricao) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.retrieve(descricao);
    }

    @Override
    public void atualizar(Fornecedor objeto) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.update(objeto);
    }

    @Override
    public void apagar(Fornecedor objeto) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.delete(objeto);
    }

}
