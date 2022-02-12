package model.bo;

public class TipoProduto {
    
    private int idTipoProduto;
    private String descricaoTipoProduto;

    public TipoProduto() {
    }

    public TipoProduto(int idTipoProduto, String descricaoTipoProduto) {
        this.idTipoProduto = idTipoProduto;
        this.descricaoTipoProduto = descricaoTipoProduto;
    }

    public int getIdTipoProduto() {
        return idTipoProduto;
    }

    public void setIdTipoProduto(int idTipoProduto) {
        this.idTipoProduto = idTipoProduto;
    }

    public String getDescricaoTipoProduto() {
        return descricaoTipoProduto;
    }

    public void setDescricaoTipoProduto(String descricaoTipoProduto) {
        this.descricaoTipoProduto = descricaoTipoProduto;
    }

    @Override
    public String toString() {
        return this.getIdTipoProduto() + ", " + this.getDescricaoTipoProduto();
    }
    
    
}
