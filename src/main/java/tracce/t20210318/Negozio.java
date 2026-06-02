package tracce.t20210318;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;

public class Negozio {

    private String idNegozio;
    private HashMap<String, Double> listino = new HashMap<String, Double>();

    public Negozio(String idNegozio){
        this.idNegozio = idNegozio;
    }

    public void avvia() throws Exception {

        new ThreadRicezioneRiepilogo().run();
    }

    public synchronized void aggiungiProdotto(String idProdotto, double prezzoUnitario) {

        listino.put(idProdotto, prezzoUnitario);
    }

    public synchronized OffertaNegozio calcolaOfferta(RichiestaAcquisto richiesta){

        if(!listino.containsKey(idNegozio)){
            return null;
        }
        double prezzoUnitario = listino.get(richiesta.getIdProdotto());
        double totale = prezzoUnitario* richiesta.getQuantita();
        return new OffertaNegozio(idNegozio, totale);
    }

    public void gesticiRichiesta(Socket socket){

        try{
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

            RichiestaAcquisto richiesta = (RichiestaAcquisto) in.readObject();
            OffertaNegozio offerta = calcolaOfferta(richiesta);

            if(offerta != null){

                out.writeObject(offerta);
            }else{

                out.writeObject("prodotto non disponibile");
            }

            out.flush();
            socket.close();
        }catch(Exception e){


        }
    }
}
