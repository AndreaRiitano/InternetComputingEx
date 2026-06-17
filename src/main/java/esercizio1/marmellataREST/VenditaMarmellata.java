package esercizio1.marmellataREST;

public class VenditaMarmellata {

    private int idAzienda;
    private String tipoMarmellata;
    private double importo;

    public VenditaMarmellata(int idAzienda, String tipoMarmellata, double importo) {
        this.idAzienda = idAzienda;
        this.tipoMarmellata = tipoMarmellata;
        this.importo = importo;
    }

    public int getIdAzienda() {
        return idAzienda;
    }
    public void setIdAzienda(int idAzienda) {
        this.idAzienda = idAzienda;
    }
    public String getTipoMarmellata() {
        return tipoMarmellata;
    }
    public void setTipoMarmellata(String tipoMarmellata) {
        this.tipoMarmellata = tipoMarmellata;
    }
    public double getImporto() {
        return importo;
    }
    public void setImporto(double importo) {
        this.importo = importo;
    }
    
}
