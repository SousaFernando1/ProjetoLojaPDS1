package bo;


public class Tamanho {
    
    private int idTamanho;
    private String descricaoTamanho;

    public Tamanho() {
    }

    public Tamanho(int idTamanho, String descricaoTamanho) {
        this.idTamanho = idTamanho;
        this.descricaoTamanho = descricaoTamanho;
    }

    public int getIdTamanho() {
        return idTamanho;
    }

    public void setIdTamanho(int idTamanho) {
        this.idTamanho = idTamanho;
    }

    public String getDescricaoTamanho() {
        return descricaoTamanho;
    }

    public void setDescricaoTamanho(String descricaoTamanho) {
        this.descricaoTamanho = descricaoTamanho;
    }

    @Override
    public String toString() {
        return this.getIdTamanho() + ", " + this.getDescricaoTamanho();
    }
    
    
}
