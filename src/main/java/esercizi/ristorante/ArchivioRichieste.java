package esercizi.ristorante;

import java.util.LinkedList;

public class ArchivioRichieste {

    private int numeroPosti = 50;
    private LinkedList<RichiestaPrenotazione> archivioRichieste = new LinkedList<RichiestaPrenotazione>();

    public synchronized int getNumeroPosti() {
        return numeroPosti;
    }

    public synchronized void riduciPosti(int n) {
        this.numeroPosti -= n;
    }

    public synchronized String aggiungiPrenotazione(RichiestaPrenotazione p) {

        if(p != null){

            if(getNumeroPosti() - p.getNumeroPersone()  >= 0){
                archivioRichieste.add(p);
                riduciPosti(p.getNumeroPersone());
                return "Prenotazione effettuata con successo";
            }else
                return "Posti non disponibili";

        }else {
            return "Richiesta non valida";
        }
    }
}
