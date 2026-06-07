package esercizi.flotta;

import java.io.Serializable;

public class PosizioneGPS implements Serializable {

    private String idFurgone;
    private double latitudine;
    private double longitudine;
    private long timeStamp;

    public PosizioneGPS(String idFurgone, double latitudine, double longitudine){

        this.idFurgone = idFurgone;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
        this.timeStamp = System.currentTimeMillis();
    }

    public String getIdFurgone() {
        return idFurgone;
    }

    public double getLatitudine() {
        return latitudine;
    }
    public double getLongitudine() {
        return longitudine;
    }
    public long getTimeStamp() {
        return timeStamp;
    }
}
