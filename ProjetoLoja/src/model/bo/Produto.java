package model.bo;
public class Produto {
    private int idproduto;
    private float valProduto;
//    private String descricaoProduto;
//    private Marca marca_idmarca;
//    private TipoProduto tipoProduto_idtipoProduto;
//    private Tamanho tamanho_idtamanho;

    private String descricaoProduto;
    private int marca_idmarca;
    private int tipoProduto_idtipoProduto;
    private int tamanho_idtamanho;


    public Produto() {
    }

    public Produto(int idproduto, String descricaoProduto, float valProduto, int marca_idmarca, int tipoProduto_idtipoProduto, int tamanho_idtamanho) {
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

    public int getMarca_idmarca() {
        return marca_idmarca;
    }

    public void setMarca_idmarca(int marca_idmarca) {
        this.marca_idmarca = marca_idmarca;
    }

    public int getTipoProduto_idtipoProduto() {
        return tipoProduto_idtipoProduto;
    }

    public void setTipoProduto_idtipoProduto(int tipoProduto_idtipoProduto) {
        this.tipoProduto_idtipoProduto = tipoProduto_idtipoProduto;
    }

    public int getTamanho_idtamanho() {
        return tamanho_idtamanho;
    }

    public void setTamanho_idtamanho(int tamanho_idtamanho) {
        this.tamanho_idtamanho = tamanho_idtamanho;
    }

    @Override
    public String toString() {
        return this.getDescricaoProduto();
    }
    
    
}
