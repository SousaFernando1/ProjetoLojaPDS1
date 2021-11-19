package bo;
public class Fornecedor extends Pessoa {
    private int idfornecedor;
    private String cnpjFornecedor;
    private String inscEstadualFornecedor;
    private Endereco endereco_idcep;

    public Fornecedor() {
    }

    public Fornecedor(int idfornecedor, String cnpjFornecedor, String inscEstadualFornecedor, Endereco endereco_idcep, String nome, String compleEndereco, String cep, String email, String status) {
        super(nome, compleEndereco, cep, email, status);
        this.idfornecedor = idfornecedor;
        this.cnpjFornecedor = cnpjFornecedor;
        this.inscEstadualFornecedor = inscEstadualFornecedor;
        this.endereco_idcep = endereco_idcep;
    }

    public int getIdfornecedor() {
        return idfornecedor;
    }

    public void setIdfornecedor(int idfornecedor) {
        this.idfornecedor = idfornecedor;
    }

    public String getCnpjFornecedor() {
        return cnpjFornecedor;
    }

    public void setCnpjFornecedor(String cnpjFornecedor) {
        this.cnpjFornecedor = cnpjFornecedor;
    }

    public String getInscEstadualFornecedor() {
        return inscEstadualFornecedor;
    }

    public void setInscEstadualFornecedor(String inscEstadualFornecedor) {
        this.inscEstadualFornecedor = inscEstadualFornecedor;
    }

    public Endereco getEndereco_idcep() {
        return endereco_idcep;
    }

    public void setEndereco_idcep(Endereco endereco_idcep) {
        this.endereco_idcep = endereco_idcep;
    }

    @Override
    public String toString() {
        return this.getCnpjFornecedor() + ", " + this.getInscEstadualFornecedor();
    }
    
    
    
}
