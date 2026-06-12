package tracce.t20241108;

import java.io.Serializable;

public class Conversione implements Serializable {

    private String idClient;
    private String codicePartenza;
    private String codiceDestinazione;
    private double importo;
    private double tasso;
    private double risultato;
    private long timeStamp;

    public Conversione(String idClient, String codicePartenza, String codiceDestinazione, double importo, double tasso, double risultato) {

        this.idClient = idClient;
        this.codicePartenza = codicePartenza;
        this.codiceDestinazione = codiceDestinazione;
        this.importo = importo;
        this.tasso = tasso;
        timeStamp = System.currentTimeMillis();
        this.risultato = risultato;

    }

    public String getIdClient() {
        return idClient;
    }
    public String getCodicePartenza() {
        return codicePartenza;
    }
    public String getCodiceDestinazione() {
        return codiceDestinazione;
    }
    public double getImporto() {
        return importo;
    }
    public double getTasso() {
        return tasso;
    }
    public double getRisultato() {
        return risultato;
    }
    public long getTimeStamp() {
        return timeStamp;
    }
    public String toString(){
        return "non mi va di scriverlo";
    }

}
