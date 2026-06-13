package wsdl.ppt10;

import java.io.Serializable;
import java.util.LinkedList;

public class ListaProdotti implements Serializable {

    private LinkedList<Prodotto> prodotti;

    public ListaProdotti(LinkedList<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }

    public LinkedList<Prodotto> getProdotti() {return prodotti;}
}
