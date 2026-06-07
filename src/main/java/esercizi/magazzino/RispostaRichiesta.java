package esercizi.magazzino;

import java.io.Serializable;

public class RispostaRichiesta implements Serializable {
    private String msg;
    private boolean stato;

    public RispostaRichiesta(String msg, boolean stato) {
        this.msg = msg;
        this.stato = stato;
    }
    public String getMsg() {
        return msg;
    }
    public boolean getStato() {
        return stato;
    }

    public String toString() {
        return msg + " " + stato;
    }
}
