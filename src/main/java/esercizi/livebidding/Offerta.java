package esercizi.livebidding;

import java.io.Serializable;

public class Offerta implements Serializable {

    private String idUtente;
    private String idOfferta;
    private String articolo;
    private double importo;
    private long timeStamp;

    public Offerta(String idUtente, String idOfferta, String articolo, double importo) {
        this.idUtente = idUtente;
        this.idOfferta = idOfferta;
        this.articolo = articolo;
        this.importo = importo;
        this.timeStamp = System.currentTimeMillis();

    }

    public String getIdUtente() {
        return idUtente;
    }
    public String getIdOfferta() {
        return idOfferta;
    }
    public String getArticolo() {
        return articolo;
    }
    public double getImporto() {
        return importo;
    }
    public long getTimeStamp() {
        return timeStamp;
    }
    public void setIdUtente(String idUtente) {
        this.idUtente = idUtente;
    }

    public String toString(){
        return idUtente + " " + idOfferta + " " + articolo;
    }
}
