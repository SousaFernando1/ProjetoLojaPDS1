package bo;
public class Receber {
    private int idreceber;
    private Venda venda_idvenda;
    private String dtHremissaoRec;
    private float ValEmissaoRec;
    private String dtVencimentoRec;
    private String dtPgtoRec;
    private float acrescimoRec;
    private float descontoRec;
    private float valPagoRec;
    private String statusRec;

    public Receber() {
    }

    public Receber(int idreceber, Venda venda_idvenda, String dtHremissaoRec, float ValEmissaoRec, String dtVencimentoRec, String dtPgtoRec, float acrescimoRec, float descontoRec, float valPagoRec, String statusRec) {
        this.idreceber = idreceber;
        this.venda_idvenda = venda_idvenda;
        this.dtHremissaoRec = dtHremissaoRec;
        this.ValEmissaoRec = ValEmissaoRec;
        this.dtVencimentoRec = dtVencimentoRec;
        this.dtPgtoRec = dtPgtoRec;
        this.acrescimoRec = acrescimoRec;
        this.descontoRec = descontoRec;
        this.valPagoRec = valPagoRec;
        this.statusRec = statusRec;
    }

    public int getIdreceber() {
        return idreceber;
    }

    public void setIdreceber(int idreceber) {
        this.idreceber = idreceber;
    }

    public Venda getVenda_idvenda() {
        return venda_idvenda;
    }

    public void setVenda_idvenda(Venda venda_idvenda) {
        this.venda_idvenda = venda_idvenda;
    }

    public String getDtHremissaoRec() {
        return dtHremissaoRec;
    }

    public void setDtHremissaoRec(String dtHremissaoRec) {
        this.dtHremissaoRec = dtHremissaoRec;
    }

    public float getValEmissaoRec() {
        return ValEmissaoRec;
    }

    public void setValEmissaoRec(float ValEmissaoRec) {
        this.ValEmissaoRec = ValEmissaoRec;
    }

    public String getDtVencimentoRec() {
        return dtVencimentoRec;
    }

    public void setDtVencimentoRec(String dtVencimentoRec) {
        this.dtVencimentoRec = dtVencimentoRec;
    }

    public String getDtPgtoRec() {
        return dtPgtoRec;
    }

    public void setDtPgtoRec(String dtPgtoRec) {
        this.dtPgtoRec = dtPgtoRec;
    }

    public float getAcrescimoRec() {
        return acrescimoRec;
    }

    public void setAcrescimoRec(float acrescimoRec) {
        this.acrescimoRec = acrescimoRec;
    }

    public float getDescontoRec() {
        return descontoRec;
    }

    public void setDescontoRec(float descontoRec) {
        this.descontoRec = descontoRec;
    }

    public float getValPagoRec() {
        return valPagoRec;
    }

    public void setValPagoRec(float valPagoRec) {
        this.valPagoRec = valPagoRec;
    }

    public String getStatusRec() {
        return statusRec;
    }

    public void setStatusRec(String statusRec) {
        this.statusRec = statusRec;
    }

    @Override
    public String toString() {
        return this.getDtVencimentoRec() + ", " + this.getValPagoRec();
    }
    
    
}
