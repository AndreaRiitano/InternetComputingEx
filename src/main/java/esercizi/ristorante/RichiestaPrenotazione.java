package esercizi.ristorante;

import java.io.Serializable;

public class RichiestaPrenotazione implements Serializable {

    private String nomeCliente;
    private int numeroPersone;

    public RichiestaPrenotazione(String nomeCliente, int numeroPersone) {
        this.nomeCliente = nomeCliente;
        this.numeroPersone = numeroPersone;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }
    public int getNumeroPersone() {
        return numeroPersone;
    }
}
