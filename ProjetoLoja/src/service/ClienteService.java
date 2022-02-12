package service;

import controller.InterfaceService;
import java.util.List;
import model.DAO.ClienteDAO;
import model.bo.Cliente;

public class ClienteService implements InterfaceService<Cliente> {

    @Override
    public  void salvar(Cliente objeto) {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.create(objeto);
    }

    @Override
    public List<Cliente> buscar() {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.retrieve();
    }

    @Override
    public Cliente buscar(int codigo) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.retrieve(codigo);
    }

    @Override
    public Cliente buscar(String descricao) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.retrieve(descricao);
    }

    @Override
    public void atualizar(Cliente objeto) {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.update(objeto);
    }

    @Override
    public void apagar(Cliente objeto) {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.delete(objeto);
    }

}
