package model.bo;

public class Bairro {
    
    private int idBairro;
    private String descricaoBairro;
    private int cidadeMae;

    public Bairro() {
    }

    public Bairro(int idBairro, String descricaoBairro, int cidadeMae) {
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

    public int getCidadeMae() {
	return cidadeMae;
    }

    public void setCidadeMae(int cidadeMae) {
	this.cidadeMae = cidadeMae;
    }





    @Override
    public String toString() {
        return this.getIdBairro() + ", " + this.getDescricaoBairro() + ", " + this.getCidadeMae();
    }
    
    
}
