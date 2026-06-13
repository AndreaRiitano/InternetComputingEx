package wsdl.gestionecorsi;

import java.io.Serializable;

public class Corso implements Serializable {

    private String docente;
    private String nomeCorso;
    private int numeroCrediti;
    private int oreEsercitazione;
    private int oreLezione;
    private String programma;

    public Corso(String docente, String nomeCorso, int numeroCrediti, int oreEsercitazione, int oreLezione, String programma){

        this.docente = docente;
        this.nomeCorso = nomeCorso;
        this.numeroCrediti = numeroCrediti;
        this.oreEsercitazione = oreEsercitazione;
        this.oreLezione = oreLezione;
        this.programma = programma;
    }

    public String getDocente(){return docente;}
    public String getNomeCorso(){return nomeCorso;}
    public int getNumeroCrediti(){return numeroCrediti;}
    public int getOreLezione(){return oreLezione;}
    public int getOreEsercitazione(){return oreEsercitazione;}
    public String getProgramma(){return programma;}

    public String toString(){
        return nomeCorso + " (" + numeroCrediti + ")";//non mi andava
    }
}
