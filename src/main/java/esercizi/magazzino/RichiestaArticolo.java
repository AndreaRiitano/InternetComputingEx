package esercizi.magazzino;

import java.io.Serializable;

public class RichiestaArticolo implements Serializable {

    private String idNegozio;
    private String articolo;
    private int quantita;

    public RichiestaArticolo(String idNegozio, String articolo, int quanita) {

        this.idNegozio = idNegozio;
        this.articolo = articolo;
        this.quantita = quanita;
    }

    public String getIdNegozio() {
        return idNegozio;
    }
    public String getArticolo() {
        return articolo;
    }
    public int getQuanita() {
        return quantita;
    }

    public String toString() {
        return idNegozio + articolo + quantita;
    }
}
