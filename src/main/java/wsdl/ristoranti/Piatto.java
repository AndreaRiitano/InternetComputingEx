package wsdl.ristoranti;

import java.io.Serializable;

public class Piatto implements Serializable {

    private String codice;
    private String nome;
    private String categoria;
    private double prezzo;

    public Piatto(String codice, String nome, String categoria, double prezzo){
        this.prezzo = prezzo;
        this.nome = nome;
        this.categoria = categoria;
        this.codice = codice;
    }

    public String getCodice(){
        return codice;
    }
    public String getNome(){
        return nome;
    }
    public String getCategoria(){
        return categoria;
    }
    public double getPrezzo(){
        return prezzo;
    }
}
