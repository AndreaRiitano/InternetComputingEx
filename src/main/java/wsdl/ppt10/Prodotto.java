package wsdl.ppt10;

import java.io.Serializable;

public class Prodotto implements Serializable {

    private String codice;
    private String nome;
    private String produttore;
    private double prezzo;

    public Prodotto(String codice, String nome, String produttore, double prezzo){

        this.codice = codice;
        this.nome = nome;
        this.produttore = produttore;
        this.prezzo = prezzo;
    }

    public String getCodice() {return codice;}
    public String getNome() {return nome;}
    public String getProduttore() {return produttore;}
    public double getPrezzo() {return prezzo;}
    
}
