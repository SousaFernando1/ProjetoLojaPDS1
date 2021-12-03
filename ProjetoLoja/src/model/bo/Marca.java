package model.bo;

public class Marca {
    
    private int idMarca;
    private String descricaoMarca;

    public Marca() {
    }

    public Marca(int idMarca, String descricaoMarca) {
        this.idMarca = idMarca;
        this.descricaoMarca = descricaoMarca;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getDescricaoMarca() {
        return descricaoMarca;
    }

    public void setDescricaoMarca(String descricaoMarca) {
        this.descricaoMarca = descricaoMarca;
    }

    @Override
    public String toString() {
        return this.getIdMarca() + ", " + this.getDescricaoMarca();
    }
    
    
}
