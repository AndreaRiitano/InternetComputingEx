package wsdl.autonoleggio;

import java.io.Serializable;
import java.util.LinkedList;

public class ListaVeicolo implements Serializable {

    private LinkedList<Veicolo> listaVeicolo;

    public ListaVeicolo(LinkedList<Veicolo> listaVeicolo) {
        this.listaVeicolo = listaVeicolo;
    }

    public LinkedList<Veicolo> getListaVeicolo(){

        return this.listaVeicolo;
    }
}
