package esercizi.livebidding;

import java.io.Serializable;

public class RispostaOfferta implements Serializable {

    private boolean stato;
    private String msg;

    public RispostaOfferta(boolean stato, String msg) {
        this.stato = stato;
        this.msg = msg;
    }
    public boolean getStato() {
        return stato;
    }
    public String getMsg() {

        return msg;
    }
    public String toString() {
        return "RispostaOfferta(" + stato + ", " + msg + ")";
    }
}
