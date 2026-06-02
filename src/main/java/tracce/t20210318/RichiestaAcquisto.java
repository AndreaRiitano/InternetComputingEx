package tracce.t20210318;

import java.io.Serializable;

public class RichiestaAcquisto implements Serializable {

    private String idProdotto;
    private int quantita;
    private double prezzoMassimo;

    public RichiestaAcquisto(String idProdotto, int quantita, double prezzoMassimo) {

        this.idProdotto = idProdotto;
        this.quantita = quantita;
        this.prezzoMassimo = prezzoMassimo;
    }

    public String getIdProdotto(){
        return this.idProdotto;
    }
    
    public int getQuantita(){
        return this.quantita;
    }

    public double getPrezzoMassimo(){
        return this.prezzoMassimo;
    }
}
