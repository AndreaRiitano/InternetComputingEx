package esercizi.flotta;

import java.io.Serializable;

public class RispostaPosizione implements Serializable {

    private boolean stato;
    private String msg;

    public RispostaPosizione(boolean stato, String msg){
        this.stato = stato;
        this.msg = msg;
    }
    public boolean getStato() {
        return stato;
    }
    public String getMsg() {
        return msg;
    }
    public String toString(){
        return stato + " " +  msg;
    }
}
