package tracce.t20240317;

import java.io.Serializable;

public class StatoSensore implements Serializable {

    private String idSensore;
    private int numeroProgressivo;
    private double temperaturaAria;
    private double umiditaSuolo;
    private long timeStamp;

    public StatoSensore(String idSensore, double temperaturaAria, double umiditaSuolo) {

        this.idSensore = idSensore;
        this.temperaturaAria = temperaturaAria;
        this.umiditaSuolo = umiditaSuolo;
    }

    public String getIdSensore() {
        return idSensore;
    }

    public double getTemperaturaAria() {
        return temperaturaAria;
    }

    public double getUmiditaSuolo() {
        return umiditaSuolo;
    }

    public int getNumeroProgressivo() {
        return numeroProgressivo;
    }
    public long getTimeStamp() {
        return timeStamp;
    }

    public void setNumeroProgressivo(int numeroProgressivo) {
        this.numeroProgressivo = numeroProgressivo;
    }

    
}
