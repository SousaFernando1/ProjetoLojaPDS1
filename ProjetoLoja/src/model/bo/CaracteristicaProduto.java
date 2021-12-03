package model.bo;
public class CaracteristicaProduto {
    private int idCaracteristicaProduto;
    private Produto produto_idproduto;
    private Cor cor_idcor;
    private String tamanhoProduto;
    private String barraProduto;
    private float qtdEstoqueProduto;

    public CaracteristicaProduto() {
    }

    public CaracteristicaProduto(int idCaracteristicaProduto, Produto produto_idproduto, Cor cor_idcor, String tamanhoProduto, String barraProduto, float qtdEstoqueProduto) {
        this.idCaracteristicaProduto = idCaracteristicaProduto;
        this.produto_idproduto = produto_idproduto;
        this.cor_idcor = cor_idcor;
        this.tamanhoProduto = tamanhoProduto;
        this.barraProduto = barraProduto;
        this.qtdEstoqueProduto = qtdEstoqueProduto;
    }

    public int getIdCaracteristicaProduto() {
        return idCaracteristicaProduto;
    }

    public void setIdCaracteristicaProduto(int idCaracteristicaProduto) {
        this.idCaracteristicaProduto = idCaracteristicaProduto;
    }

    public Produto getProduto_idproduto() {
        return produto_idproduto;
    }

    public void setProduto_idproduto(Produto produto_idproduto) {
        this.produto_idproduto = produto_idproduto;
    }

    public Cor getCor_idcor() {
        return cor_idcor;
    }

    public void setCor_idcor(Cor cor_idcor) {
        this.cor_idcor = cor_idcor;
    }

    public String getTamanhoProduto() {
        return tamanhoProduto;
    }

    public void setTamanhoProduto(String tamanhoProduto) {
        this.tamanhoProduto = tamanhoProduto;
    }

    public String getBarraProduto() {
        return barraProduto;
    }

    public void setBarraProduto(String barraProduto) {
        this.barraProduto = barraProduto;
    }

    public float getQtdEstoqueProduto() {
        return qtdEstoqueProduto;
    }

    public void setQtdEstoqueProduto(float qtdEstoqueProduto) {
        this.qtdEstoqueProduto = qtdEstoqueProduto;
    }

    @Override
    public String toString() {
        return this.barraProduto;
    }
    
    
}
