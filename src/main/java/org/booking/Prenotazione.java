package org.booking;

import java.io.Serializable;

public class Prenotazione implements Serializable {

    private String idUtente;
    private String nomeBnb;
    private int nGiorni;

    public Prenotazione(String idUtente, String nomeBnb, int nGiorni) {

        this.idUtente = idUtente;
        this.nomeBnb = nomeBnb;
        this.nGiorni = nGiorni;

    }

    @Override
    public String toString() {
        return "idUtente: "+ idUtente + ", \n nomeBnb: " + nomeBnb + ", \nnGiorni: " + nGiorni;
    }

    public int  getNGiorni() {
        return nGiorni;
    }

}
