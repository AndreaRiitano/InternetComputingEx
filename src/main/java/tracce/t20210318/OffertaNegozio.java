package tracce.t20210318;

import  java.io.Serializable;

public class OffertaNegozio implements Serializable {

    private String idNegozio;
    private double prezzoAcquisto;

    public OffertaNegozio(String idNegozio, double prezzoAcquisto) {
        this.idNegozio = idNegozio;
        this.prezzoAcquisto = prezzoAcquisto;
    }

    public String getIdNegozio() {
        return idNegozio;
    }

    public double getPrezzoAcquisto() {
        return prezzoAcquisto;
    }
}
