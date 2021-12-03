package model.bo;
public class CondicaoPagamento {
    private int idcondicaoPagamento;
    private String descricaoCondicaoPagamento;
    private int numDiasAtePrimeiraParcela;
    private int numDiasEntreParcelas;

    public CondicaoPagamento() {
    }

    public CondicaoPagamento(int idcondicaoPagamento, String descricaoCondicaoPagamento, int numDiasAtePrimeiraParcela, int numDiasEntreParcelas) {
        this.idcondicaoPagamento = idcondicaoPagamento;
        this.descricaoCondicaoPagamento = descricaoCondicaoPagamento;
        this.numDiasAtePrimeiraParcela = numDiasAtePrimeiraParcela;
        this.numDiasEntreParcelas = numDiasEntreParcelas;
    }

    public int getIdcondicaoPagamento() {
        return idcondicaoPagamento;
    }

    public void setIdcondicaoPagamento(int idcondicaoPagamento) {
        this.idcondicaoPagamento = idcondicaoPagamento;
    }

    public String getDescricaoCondicaoPagamento() {
        return descricaoCondicaoPagamento;
    }

    public void setDescricaoCondicaoPagamento(String descricaoCondicaoPagamento) {
        this.descricaoCondicaoPagamento = descricaoCondicaoPagamento;
    }

    public int getNumDiasAtePrimeiraParcela() {
        return numDiasAtePrimeiraParcela;
    }

    public void setNumDiasAtePrimeiraParcela(int numDiasAtePrimeiraParcela) {
        this.numDiasAtePrimeiraParcela = numDiasAtePrimeiraParcela;
    }

    public int getNumDiasEntreParcelas() {
        return numDiasEntreParcelas;
    }

    public void setNumDiasEntreParcelas(int numDiasEntreParcelas) {
        this.numDiasEntreParcelas = numDiasEntreParcelas;
    }

    @Override
    public String toString() {
        return this.getDescricaoCondicaoPagamento();
    }
    
    
}
