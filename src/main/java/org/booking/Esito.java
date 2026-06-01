package org.booking;

import java.io.Serializable;

public class Esito implements Serializable {

    private boolean confermato;
    private String messaggio;

    public Esito(boolean confermato, String messaggio) {
        this.confermato = confermato;
        this.messaggio = messaggio;
    }

    @Override
    public String toString() {
        return "Esito: "+ messaggio;
    }

}
