package tracce.t20230111;

import java.util.HashMap;
import java.util.LinkedList;

public class ArchivioMisure {

    private HashMap<String, Misura> archivioMisure;
    private LinkedList<String> sensoriConosciuti;

    public synchronized void salvaMisura(Misura misurazione) {

        if(misurazione != null && !sensoriConosciuti.contains(misurazione.getIdSensore())) {
            sensoriConosciuti.add(misurazione.getIdSensore());

        }
        archivioMisure.put(misurazione.getIdSensore(), misurazione);
    }

    public synchronized Misura getUltimaMisuraSensore(String idSensore) {
        return archivioMisure.get(idSensore);
    }

    public synchronized LinkedList<String> getSensoriNonFunzionanti(long tempoLimite){

        LinkedList<String> risultato = new LinkedList<String>();
        long adesso = System.currentTimeMillis();

        for(int i = 0; i < sensoriConosciuti.size(); i++){

            String tempId = sensoriConosciuti.get(i);
            Misura m = archivioMisure.get(tempId);

            if(m != null && adesso - m.getTimestamp() > tempoLimite){

                risultato.add(tempId);
            }
        }
        return risultato;
    }
}
