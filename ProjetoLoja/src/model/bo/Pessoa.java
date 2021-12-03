package model.bo;
public abstract class Pessoa {
    private String nome;
    private String compleEndereco;
    private String cep;
    private String email;
    private String status;

    public Pessoa() {
    }

    public Pessoa(String nome, String compleEndereco, String cep, String email, String status) {
        this.nome = nome;
        this.compleEndereco = compleEndereco;
        this.cep = cep;
        this.email = email;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCompleEndereco() {
        return compleEndereco;
    }

    public void setCompleEndereco(String compleEndereco) {
        this.compleEndereco = compleEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.getNome() + ", " + this.getEmail();
    }
    
    
}
