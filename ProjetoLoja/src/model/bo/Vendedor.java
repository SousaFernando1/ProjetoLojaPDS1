package model.bo;
public class Vendedor extends Pessoa{
    private int idvendedor;
    private String cpfVendedor;
    private String foneVendedor;
    private String fone2Vendedor;
    private float PercentComissaoVenda;
    private float percentComissaoRecebto;
    private Endereco endereco_idcep;
    private Venda venda_idvenda;

    public Vendedor() {
    }

    public Vendedor(int idvendedor, String cpfVendedor, String foneVendedor, String fone2Vendedor, float PercentComissaoVenda, float percentComissaoRecebto, Endereco endereco_idcep, Venda venda_idvenda, String nome, String compleEndereco, String cep, String email, String status) {
        super(nome, compleEndereco, cep, email, status);
        this.idvendedor = idvendedor;
        this.cpfVendedor = cpfVendedor;
        this.foneVendedor = foneVendedor;
        this.fone2Vendedor = fone2Vendedor;
        this.PercentComissaoVenda = PercentComissaoVenda;
        this.percentComissaoRecebto = percentComissaoRecebto;
        this.endereco_idcep = endereco_idcep;
        this.venda_idvenda = venda_idvenda;
    }

    public int getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(int idvendedor) {
        this.idvendedor = idvendedor;
    }

    public String getCpfVendedor() {
        return cpfVendedor;
    }

    public void setCpfVendedor(String cpfVendedor) {
        this.cpfVendedor = cpfVendedor;
    }

    public String getFoneVendedor() {
        return foneVendedor;
    }

    public void setFoneVendedor(String foneVendedor) {
        this.foneVendedor = foneVendedor;
    }

    public String getFone2Vendedor() {
        return fone2Vendedor;
    }

    public void setFone2Vendedor(String fone2Vendedor) {
        this.fone2Vendedor = fone2Vendedor;
    }

    public float getPercentComissaoVenda() {
        return PercentComissaoVenda;
    }

    public void setPercentComissaoVenda(float PercentComissaoVenda) {
        this.PercentComissaoVenda = PercentComissaoVenda;
    }

    public float getPercentComissaoRecebto() {
        return percentComissaoRecebto;
    }

    public void setPercentComissaoRecebto(float percentComissaoRecebto) {
        this.percentComissaoRecebto = percentComissaoRecebto;
    }

    public Endereco getEndereco_idcep() {
        return endereco_idcep;
    }

    public void setEndereco_idcep(Endereco endereco_idcep) {
        this.endereco_idcep = endereco_idcep;
    }

    public Venda getVenda_idvenda() {
        return venda_idvenda;
    }

    public void setVenda_idvenda(Venda venda_idvenda) {
        this.venda_idvenda = venda_idvenda;
    }

    @Override
    public String toString() {
        return this.getCpfVendedor() + ", " + this.getFoneVendedor();
    }

    
    
    
}
