package esercizi.flotta;

import java.util.HashMap;
import java.util.LinkedList;

public class ArchivioPosizioni {

    private HashMap<String, PosizioneGPS> archiviPosizioni = new HashMap<String,PosizioneGPS>();


    public synchronized void aggiornaPosizione(PosizioneGPS posizione){

        if(posizione == null){
            System.out.println("Errore aggiorna posizione.");
            return;
        }else {
            archiviPosizioni.put(posizione.getIdFurgone(), posizione);
        }
    }

    public synchronized LinkedList<String> furgoniOffline(){

        LinkedList<String> offline = new LinkedList<String>();
        for(PosizioneGPS posTemp : archiviPosizioni.values()){

            if(System.currentTimeMillis() - posTemp.getTimeStamp()  > 10000){

                offline.add(posTemp.getIdFurgone());

            }
        }

        return offline;
    }
}


