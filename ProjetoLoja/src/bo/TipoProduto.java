package bo;

public class TipoProduto {
    
    private int idTipoProduto;
    private String descripcaoTipoProduto;

    public TipoProduto() {
    }

    public TipoProduto(int idTipoProduto, String descripcaoTipoProduto) {
        this.idTipoProduto = idTipoProduto;
        this.descripcaoTipoProduto = descripcaoTipoProduto;
    }

    public int getIdTipoProduto() {
        return idTipoProduto;
    }

    public void setIdTipoProduto(int idTipoProduto) {
        this.idTipoProduto = idTipoProduto;
    }

    public String getDescripcaoTipoProduto() {
        return descripcaoTipoProduto;
    }

    public void setDescripcaoTipoProduto(String descripcaoTipoProduto) {
        this.descripcaoTipoProduto = descripcaoTipoProduto;
    }

    @Override
    public String toString() {
        return this.getIdTipoProduto() + ", " + this.getDescripcaoTipoProduto();
    }
    
    
}
