package esercizi.livebidding;

import java.util.HashMap;
import java.util.LinkedList;

public class ArchivioOfferte {

    private HashMap<String,LinkedList<Offerta>> archivioOfferte = new HashMap<String,LinkedList<Offerta>>();
    private LinkedList<Offerta> offerteRicevute = new LinkedList<Offerta>();

    public synchronized RispostaOfferta aggiungiOfferta(Offerta offerta) {
            if(offerta == null) {
                return new RispostaOfferta(false, "Offerta nulla");
            }
            else {

                if (archivioOfferte.containsKey(offerta.getArticolo())) {

                    double ultimaOfferta = archivioOfferte.get(offerta.getArticolo()).getLast().getImporto();

                    if (offerta.getImporto() >= ultimaOfferta + ultimaOfferta * 0.05) {
                        archivioOfferte.get(offerta.getArticolo()).add(offerta);
                        return new RispostaOfferta(true, "Offerta accettata");
                    }else {

                        return new RispostaOfferta(false, "Offerta rifiutata");
                    }

                }
            }
            return new RispostaOfferta(false, "Offerta non in asta");
    }

    public synchronized HashMap<String, Offerta> offerteVincenti(){
        HashMap<String, Offerta> offerteVincenti = new HashMap<String, Offerta>();

        for(String key : archivioOfferte.keySet()) {
            Offerta offertaVincente = archivioOfferte.get(key).getLast();

            offerteVincenti.put(key, offertaVincente);

        }
        return offerteVincenti;
    }
}
