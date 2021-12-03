package model.bo;
public class Produto {
    private int idproduto;
    private String descricaoProduto;
    private float valProduto;
    private Marca marca_idmarca;
    private TipoProduto tipoProduto_idtipoProduto;
    private Tamanho tamanho_idtamanho;

    public Produto() {
    }

    public Produto(int idproduto, String descricaoProduto, float valProduto, Marca marca_idmarca, TipoProduto tipoProduto_idtipoProduto, Tamanho tamanho_idtamanho) {
        this.idproduto = idproduto;
        this.descricaoProduto = descricaoProduto;
        this.valProduto = valProduto;
        this.marca_idmarca = marca_idmarca;
        this.tipoProduto_idtipoProduto = tipoProduto_idtipoProduto;
        this.tamanho_idtamanho = tamanho_idtamanho;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public float getValProduto() {
        return valProduto;
    }

    public void setValProduto(float valProduto) {
        this.valProduto = valProduto;
    }

    public Marca getMarca_idmarca() {
        return marca_idmarca;
    }

    public void setMarca_idmarca(Marca marca_idmarca) {
        this.marca_idmarca = marca_idmarca;
    }

    public TipoProduto getTipoProduto_idtipoProduto() {
        return tipoProduto_idtipoProduto;
    }

    public void setTipoProduto_idtipoProduto(TipoProduto tipoProduto_idtipoProduto) {
        this.tipoProduto_idtipoProduto = tipoProduto_idtipoProduto;
    }

    public Tamanho getTamanho_idtamanho() {
        return tamanho_idtamanho;
    }

    public void setTamanho_idtamanho(Tamanho tamanho_idtamanho) {
        this.tamanho_idtamanho = tamanho_idtamanho;
    }

    @Override
    public String toString() {
        return this.getDescricaoProduto();
    }
    
    
}
