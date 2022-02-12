package service;

import controller.InterfaceService;
import java.util.List;
import model.DAO.CondicaoPagamentoDAO;
import model.bo.CondicaoPagamento;

public class CondicaoPagamentoService implements InterfaceService<CondicaoPagamento> {

    @Override
    public  void salvar(CondicaoPagamento objeto) {
        CondicaoPagamentoDAO condicaoPagamentoDAO = new CondicaoPagamentoDAO();
        condicaoPagamentoDAO.create(objeto);
    }

    @Override
    public List<CondicaoPagamento> buscar() {
        CondicaoPagamentoDAO condicaoPagamentoDAO = new CondicaoPagamentoDAO();
        return condicaoPagamentoDAO.retrieve();
    }

    @Override
    public CondicaoPagamento buscar(int codigo) {
        CondicaoPagamentoDAO condicaoPagamentoDAO = new CondicaoPagamentoDAO();
        return condicaoPagamentoDAO.retrieve(codigo);
    }

    @Override
    public CondicaoPagamento buscar(String descricao) {
        CondicaoPagamentoDAO condicaoPagamentoDAO = new CondicaoPagamentoDAO();
        return condicaoPagamentoDAO.retrieve(descricao);
    }

    @Override
    public void atualizar(CondicaoPagamento objeto) {
        CondicaoPagamentoDAO condicaoPagamentoDAO = new CondicaoPagamentoDAO();
        condicaoPagamentoDAO.update(objeto);
    }

    @Override
    public void apagar(CondicaoPagamento objeto) {
        CondicaoPagamentoDAO condicaoPagamentoDAO = new CondicaoPagamentoDAO();
        condicaoPagamentoDAO.delete(objeto);
    }

}
