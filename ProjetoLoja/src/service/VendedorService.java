package service;

import controller.InterfaceService;
import java.util.List;
import model.DAO.VendedorDAO;
import model.bo.Vendedor;

public class VendedorService implements InterfaceService<Vendedor> {

    @Override
    public  void salvar(Vendedor objeto) {
        VendedorDAO vendedorDAO = new VendedorDAO();
        vendedorDAO.create(objeto);
    }

    @Override
    public List<Vendedor> buscar() {
        VendedorDAO vendedorDAO = new VendedorDAO();
        return vendedorDAO.retrieve();
    }

    @Override
    public Vendedor buscar(int codigo) {
        VendedorDAO vendedorDAO = new VendedorDAO();
        return vendedorDAO.retrieve(codigo);
    }

    @Override
    public Vendedor buscar(String descricao) {
        VendedorDAO vendedorDAO = new VendedorDAO();
        return vendedorDAO.retrieve(descricao);
    }

    @Override
    public void atualizar(Vendedor objeto) {
        VendedorDAO vendedorDAO = new VendedorDAO();
        vendedorDAO.update(objeto);
    }

    @Override
    public void apagar(Vendedor objeto) {
        VendedorDAO vendedorDAO = new VendedorDAO();
        vendedorDAO.delete(objeto);
    }

}
