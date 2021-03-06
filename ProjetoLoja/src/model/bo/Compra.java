package model.bo;
public class Compra {
    private int idcompra;
    private Fornecedor fornecedor_idfornecedor;
    private CondicaoPagamento condicaoPagamento_idcondicaoPagamento;
    private int numNFCompra;
    private String serieNFCompra;
    private String dtHRCompra;
    private float descontoCompra;
    private float valorTotalCompra;

    public Compra() {
    }

    public Compra(int idcompra, Fornecedor fornecedor_idfornecedor, CondicaoPagamento condicaoPagamento_idcondicaoPagamento, int numNFCompra, String serieNFCompra, String dtHRCompra, float descontoCompra, float valorTotalCompra) {
        this.idcompra = idcompra;
        this.fornecedor_idfornecedor = fornecedor_idfornecedor;
        this.condicaoPagamento_idcondicaoPagamento = condicaoPagamento_idcondicaoPagamento;
        this.numNFCompra = numNFCompra;
        this.serieNFCompra = serieNFCompra;
        this.dtHRCompra = dtHRCompra;
        this.descontoCompra = descontoCompra;
        this.valorTotalCompra = valorTotalCompra;
    }

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public Fornecedor getFornecedor_idfornecedor() {
        return fornecedor_idfornecedor;
    }

    public void setFornecedor_idfornecedor(Fornecedor fornecedor_idfornecedor) {
        this.fornecedor_idfornecedor = fornecedor_idfornecedor;
    }

    public CondicaoPagamento getCondicaoPagamento_idcondicaoPagamento() {
        return condicaoPagamento_idcondicaoPagamento;
    }

    public void setCondicaoPagamento_idcondicaoPagamento(CondicaoPagamento condicaoPagamento_idcondicaoPagamento) {
        this.condicaoPagamento_idcondicaoPagamento = condicaoPagamento_idcondicaoPagamento;
    }

    public int getNumNFCompra() {
        return numNFCompra;
    }

    public void setNumNFCompra(int numNFCompra) {
        this.numNFCompra = numNFCompra;
    }

    public String getSerieNFCompra() {
        return serieNFCompra;
    }

    public void setSerieNFCompra(String serieNFCompra) {
        this.serieNFCompra = serieNFCompra;
    }

    public String getDtHRCompra() {
        return dtHRCompra;
    }

    public void setDtHRCompra(String dtHRCompra) {
        this.dtHRCompra = dtHRCompra;
    }

    public float getDescontoCompra() {
        return descontoCompra;
    }

    public void setDescontoCompra(float descontoCompra) {
        this.descontoCompra = descontoCompra;
    }

    public float getValorTotalCompra() {
        return valorTotalCompra;
    }

    public void setValorTotalCompra(float valorTotalCompra) {
        this.valorTotalCompra = valorTotalCompra;
    }

    @Override
    public String toString() {
        return this.getNumNFCompra() + ", " + this.getSerieNFCompra();
    }
    
    
}
