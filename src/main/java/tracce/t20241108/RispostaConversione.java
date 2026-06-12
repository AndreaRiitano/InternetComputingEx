package tracce.t20241108;

import java.io.Serializable;

public class RispostaConversione implements Serializable {

    private boolean stato;
    private String msg;
    private double importoConvertito;
    private double tasso;

    public RispostaConversione(boolean stato, String msg, double importoConvertito, double tasso){

        this.stato=stato;
        this.msg=msg;
        this.importoConvertito=importoConvertito;
        this.tasso=tasso;
    }

    public boolean getStato(){
        return this.stato;
    }
    public String getMsg(){
        return this.msg;
    }
    public double getImportoConvertito(){
        return this.importoConvertito;
    }
    public double getTasso(){
        return this.tasso;
    }
    public String toString(){
        return "manco qua mi andavaa";
    }
}
