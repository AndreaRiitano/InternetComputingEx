package tracce.t20210318;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

    public static final String hostname = "shop.dimes";
    public static final int portaCliente = 1111;
    public static final int portaNegozio = 2222;
    public static final int portaVendite = 3333;
    public static final long giorno = 24*60*60*1000;

    private LinkedList<InfoNegozio> negozi = new LinkedList<InfoNegozio>();
    private ArchivioVendite  archivioVendite = new ArchivioVendite();

    public Server(){
        negozi.add(new InfoNegozio("Negozio1", "localhost"));
    }

    public void avvia() throws IOException{
            new ThreadRiepilogoVendite(negozi, archivioVendite);
            ServerSocket serverSocket = new ServerSocket(portaCliente);

            while (true){
                Socket clientSocket = serverSocket.accept();
                new ThreadRichiestaClient(clientSocket, this);
            }

        }

    public void gestisciRichiestaClient(Socket clientSocket){

        try{
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());

            RichiestaAcquisto richiesta = (RichiestaAcquisto) in.readObject();
            OffertaNegozio migliore = null;

            for(int i = 0; i < negozi.size(); i++){

                InfoNegozio negozio = negozi.get(i);
                OffertaNegozio offerta = richiediOffertaAlNegozio(negozio, richiesta);
                if(offerta !=null && offerta.getPrezzoAcquisto() <= richiesta.getPrezzoMassimo()){

                    if(offerta.getPrezzoAcquisto() < migliore.getPrezzoAcquisto()){

                        migliore = offerta;
                        out.writeObject(migliore);
                    }else{

                        out.writeObject("nessuna offerta");
                    }
                    out.flush();
                    clientSocket.close();
                }
            }

            if(migliore != null){

                archivioVendite.aggiungiVendite(migliore);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private OffertaNegozio richiediOffertaAlNegozio(InfoNegozio info, RichiestaAcquisto richiesta){

        try {

            Socket socket = new Socket(info.getHost(), portaNegozio);
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(richiesta);
            out.flush();
            Object risposta = in.readObject();
            socket.close();

            if(risposta instanceof OffertaNegozio){

                return (OffertaNegozio) risposta;

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
