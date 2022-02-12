package service;

import controller.InterfaceService;
import java.util.List;
import model.DAO.CorDAO;
import model.bo.Cor;

public class CorService implements InterfaceService<Cor> {

    @Override
    public  void salvar(Cor objeto) {
        CorDAO corDAO = new CorDAO();
        corDAO.create(objeto);
    }

    @Override
    public List<Cor> buscar() {
        CorDAO corDAO = new CorDAO();
        return corDAO.retrieve();
    }

    @Override
    public Cor buscar(int codigo) {
        CorDAO corDAO = new CorDAO();
        return corDAO.retrieve(codigo);
    }

    @Override
    public Cor buscar(String descricao) {
        CorDAO corDAO = new CorDAO();
        return corDAO.retrieve(descricao);
    }

    @Override
    public void atualizar(Cor objeto) {
        CorDAO corDAO = new CorDAO();
        corDAO.update(objeto);
    }

    @Override
    public void apagar(Cor objeto) {
        CorDAO corDAO = new CorDAO();
        corDAO.delete(objeto);
    }

}
