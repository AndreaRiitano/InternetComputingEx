package wsdl.gestionecorsi;

import java.util.HashMap;

public class GestioneCorsi {

    private HashMap<String, Corso> corsi = new HashMap<String, Corso>();

    public void addCorso(Corso corso){
        String nomeCorso = corso.getNomeCorso();
        corsi.put(nomeCorso, corso);
    }

    public Corso getCorso(String nomeCorso){
        Corso corso = null;
        if(corsi.containsKey(nomeCorso)){

            corso = corsi.get(nomeCorso);

        }
        return corso;
    }



}
