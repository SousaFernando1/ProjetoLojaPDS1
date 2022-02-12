package model.bo;

public class Bairro {
    
    private int idBairro;
    private String descricaoBairro;
    private String cidadeMae;

    public Bairro() {
    }

    public Bairro(int idBairro, String descricaoBairro, String cidadeMae) {
        this.idBairro = idBairro;
        this.descricaoBairro = descricaoBairro;        
	this.cidadeMae = cidadeMae;

    }

    public int getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(int idBairro) {
        this.idBairro = idBairro;
    }

    public String getDescricaoBairro() {
        return descricaoBairro;
    }

    public void setDescricaoBairro(String descricaoBairro) {
        this.descricaoBairro = descricaoBairro;
    }

    public String getCidadeMae() {
	return cidadeMae;
    }

    public void setCidadeMae(String cidadeMae) {
	this.cidadeMae = cidadeMae;
    }





    @Override
    public String toString() {
        return this.getIdBairro() + ", " + this.getDescricaoBairro() + ", " + this.getCidadeMae();
    }
    
    
}
