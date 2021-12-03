package model.bo;
public class Cor {
    
    private int idCor;
    private String descricaoCor;

    public Cor() {
    }

    public Cor(int idCor, String descricaoCor) {
        this.idCor = idCor;
        this.descricaoCor = descricaoCor;
    }

    public int getIdCor() {
        return idCor;
    }

    public void setIdCor(int idCor) {
        this.idCor = idCor;
    }

    public String getDescricaoCor() {
        return descricaoCor;
    }

    public void setDescricaoCor(String descricaoCor) {
        this.descricaoCor = descricaoCor;
    }

    @Override
    public String toString() {
        return this.getIdCor() + ", " + this.getDescricaoCor();
    }
    
    
}
