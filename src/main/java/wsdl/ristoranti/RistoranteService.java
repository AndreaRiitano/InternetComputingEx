package wsdl.ristoranti;

import java.util.HashMap;
import java.util.LinkedList;

public class RistoranteService {

    private HashMap<String, HashMap<Piatto, Integer>> archivioPiatti;

    public Piatto PiattoMaxIncassoCategoria(String categoria){
        HashMap<Piatto,Double> piattiIncassi = new HashMap<Piatto,Double>();

        for(HashMap<Piatto, Integer> ordini : archivioPiatti.values()){

            for(Piatto piatto : ordini.keySet()){

                if(piatto.getCategoria().equals(categoria)){
                    int vendite = ordini.get(piatto);
                    double incasso = vendite * piatto.getPrezzo();

                    if(piattiIncassi.containsKey(piatto)){

                        double incassoPrecedente = piattiIncassi.get(piatto);

                        piattiIncassi.put(piatto, incassoPrecedente + incasso);
                    }else {

                        piattiIncassi.put(piatto, incasso);

                    }
                }

                }
            }

        Piatto piattoMax =  null;
        double venditeMax =0;
        for(Piatto piatto : piattiIncassi.keySet()){

            if(piattiIncassi.get(piatto)>venditeMax){
                venditeMax = piattiIncassi.get(piatto);
                piattoMax = piatto;
            }
        }

        return piattoMax;
    }

    public ListaPiatti TopTrePiatti(String idR){

        LinkedList<Piatto> topTre = new LinkedList<Piatto>();
        HashMap<Piatto, Integer> ristorante = null;
        if(archivioPiatti.containsKey(idR)){
            ristorante = new HashMap<>(archivioPiatti.get(idR));
            if(ristorante.size()<=3){

                for(Piatto piatto : ristorante.keySet()){
                    topTre.add(piatto);
                }
                return new ListaPiatti(topTre);
            }
        }else{

            return new ListaPiatti(topTre);
        }
        boolean tre = false;

        while(!tre) {
            Piatto top = null;
            int ordini  = 0;
            for (Piatto piatto : ristorante.keySet()) {

                if (ristorante.get(piatto) > ordini) {

                    ordini = ristorante.get(piatto);
                    top = piatto;
                }
            }
            topTre.add(top);
            ristorante.remove(top);
            if(topTre.size()==3){
                tre = true;
            }

        }

        return new ListaPiatti(topTre);
    }
}
