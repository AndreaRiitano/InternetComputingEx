package tracce.t20241108;

import java.util.LinkedList;

public class ArchivioConversioni {

    private LinkedList<Conversione> archivio = new LinkedList<Conversione>();

    public synchronized void addConversione(Conversione conversione){
        archivio.add(conversione);
    }
    public synchronized LinkedList<Conversione> dopoTot(long tempo){
        LinkedList<Conversione> risposta = new LinkedList<Conversione>();

        for(Conversione conversione: archivio){
            if(conversione.getTimeStamp()>tempo){
                risposta.add(conversione);
            }
        }
        return risposta;
    }
}
