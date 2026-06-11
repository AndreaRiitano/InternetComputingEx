package wsdl.autonoleggio;

import java.util.HashMap;
import java.util.LinkedList;

public class NoleggioService {

    private HashMap<String,HashMap<Veicolo,Integer>> venditeFiliale;

    public Veicolo veicoloMaxIncasso(String marca){

        HashMap<Veicolo, Double> incassiGlobali = new HashMap<Veicolo, Double>();

        for(HashMap<Veicolo,Integer> vendite : venditeFiliale.values()){


            for(Veicolo veicolo : vendite.keySet()){

                if(veicolo.getMarca().equals(marca)){

                    int giorni = vendite.get(veicolo);
                    double incassoCorrente = giorni * veicolo.getCostoGiornaliero();

                    if(incassiGlobali.containsKey(veicolo)){

                        double incassoPrecedente = incassiGlobali.get(veicolo);
                        incassiGlobali.put(veicolo, incassoCorrente + incassoPrecedente);
                    }else{

                        incassiGlobali.put(veicolo, incassoCorrente);
                    }

                }
            }
        }
        Veicolo veicoloTop = null;
        double incassoMax = 0;

        for(Veicolo veicolo : incassiGlobali.keySet()){

            if(incassiGlobali.get(veicolo) > incassoMax){

                veicoloTop = veicolo;
                incassoMax = incassiGlobali.get(veicolo);
            }

        }
        return veicoloTop;
    }


    public ListaVeicolo topDueVeicoli(String idF){
        
        if (!venditeFiliale.containsKey(idF)) {
            return new ListaVeicolo(new LinkedList<Veicolo>());
        }
        LinkedList<Veicolo> topDue = new LinkedList<Veicolo>();
        HashMap<Veicolo, Integer> temp = new HashMap<Veicolo,Integer>(venditeFiliale.get(idF));
        int giorniTop = 0;
        Veicolo veicoloTop = null;
        int cont = 0;
        if(temp.size()>=2) {
            while (cont < 2) {

                for (Veicolo veicolo : temp.keySet()) {

                    if (temp.get(veicolo) > giorniTop) {

                        veicoloTop = veicolo;
                        giorniTop = temp.get(veicolo);
                    }
                }

                topDue.add(veicoloTop);
                temp.remove(veicoloTop);
                cont++;
                veicoloTop = null;
                giorniTop = 0;

            }
        }else{
            for(Veicolo veicolo : temp.keySet()){
                topDue.add(veicolo);
            }
        }
        ListaVeicolo risultato = new ListaVeicolo(topDue);
        return risultato;
    }

}
