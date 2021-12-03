package model.bo;
public class FoneFornecedor {
    private String foneFornecedor;
    private Fornecedor fornecedor_idfornecedor;

    public FoneFornecedor() {
    }

    public FoneFornecedor(String foneFornecedor, Fornecedor fornecedor_idfornecedor) {
        this.foneFornecedor = foneFornecedor;
        this.fornecedor_idfornecedor = fornecedor_idfornecedor;
    }

    public String getFoneFornecedor() {
        return foneFornecedor;
    }

    public void setFoneFornecedor(String foneFornecedor) {
        this.foneFornecedor = foneFornecedor;
    }

    public Fornecedor getFornecedor_idfornecedor() {
        return fornecedor_idfornecedor;
    }

    public void setFornecedor_idfornecedor(Fornecedor fornecedor_idfornecedor) {
        this.fornecedor_idfornecedor = fornecedor_idfornecedor;
    }

    @Override
    public String toString() {
        return this.getFoneFornecedor();
    }
    
    
}
