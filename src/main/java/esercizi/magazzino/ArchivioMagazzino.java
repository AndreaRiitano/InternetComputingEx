package esercizi.magazzino;

import java.util.HashMap;
import java.util.LinkedList;

public class ArchivioMagazzino {

    HashMap<String, Integer> archivio = new HashMap<String, Integer>();
    LinkedList<RichiestaArticolo> richieste = new LinkedList<RichiestaArticolo>();

    public synchronized boolean processaRichiesta(RichiestaArticolo richiesta) {

            if(archivio.containsKey(richiesta.getArticolo()) && archivio.get(richiesta.getArticolo()) - richiesta.getQuanita() >= 0   ){
                int nuovaQuanita = archivio.get(richiesta.getArticolo())- richiesta.getQuanita();
                archivio.put(richiesta.getArticolo(), nuovaQuanita);
                richieste.add(richiesta);
                return true;
            }else {
                return false;
            }
    }
}
