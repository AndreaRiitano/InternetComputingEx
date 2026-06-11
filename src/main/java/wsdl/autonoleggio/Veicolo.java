package wsdl.autonoleggio;

import java.io.Serializable;

public class Veicolo implements Serializable {

    private String targa;
    private String marca;
    private String modello;
    private double costoGiornaliero;

    public Veicolo(String targa, String marca, String modello, double costoGiornaliero) {
        this.targa = targa;
        this.marca = marca;
        this.modello = modello;
        this.costoGiornaliero = costoGiornaliero;
    }

    public String getTarga() {
        return targa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public double getCostoGiornaliero() {
        return costoGiornaliero;
    }
}
