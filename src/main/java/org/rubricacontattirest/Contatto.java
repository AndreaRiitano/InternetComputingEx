package org.rubricacontattirest;

import org.json.JSONObject;
import java.io.Serializable;

public class Contatto implements Serializable {

    private int id;
    private String nome;
    private String cognome;
    private String indirizzo;
    private String telefono;

    public Contatto() {}

    public Contatto(String line){

        JSONObject json = new JSONObject(line);
        this.id = json.getInt("id");
        this.nome = json.getString("name");
        this.cognome = json.getString("surname");
        this.indirizzo = json.getString("address");
        this.telefono = json.getString("phone");

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return new JSONObject(this).toString();
    }
}
