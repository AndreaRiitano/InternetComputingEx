package tracce.t20210318;

import java.io.IOException;

public class MainNegozio {
    public static void main(String[] args) throws Exception {

        Negozio negozio = new Negozio("Negozio1");
        negozio.aggiungiProdotto("Smartphone", 60);
        negozio.avvia();
    }
}
