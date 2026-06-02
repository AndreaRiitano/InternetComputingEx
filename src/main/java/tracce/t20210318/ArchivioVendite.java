package tracce.t20210318;

import java.util.HashMap;

public class ArchivioVendite {

    private HashMap<String,Double> vendite = new HashMap<String,Double>();

    public synchronized void aggiungiVendite(OffertaNegozio o) {

        double tot = 0;

        if (vendite.containsKey(o.getIdNegozio())) {

            tot = vendite.get(o.getIdNegozio());
        }

        vendite.put(o.getIdNegozio(), tot + o.getPrezzoAcquisto());
    }

    public synchronized double getTotale(OffertaNegozio o) {

        if (vendite.containsKey(o.getIdNegozio())) {
            return vendite.get(o.getIdNegozio());
        }else {
            return 0.0;
        }
    }
    public synchronized double getTotale(InfoNegozio o) {

        if (vendite.containsKey(o.getIdNegozio())) {
            return vendite.get(o.getIdNegozio());
        }else {
            return 0.0;
        }
    }
}
