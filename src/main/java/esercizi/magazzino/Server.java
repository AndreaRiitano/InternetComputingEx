package esercizi.magazzino;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ArchivioMagazzino archivio = new ArchivioMagazzino();

    public static final int PORTA_CLIENT = 8888;

    public void avvia(){

        try{
            ServerSocket socket = new ServerSocket(PORTA_CLIENT);

            while (true){
                Socket clientSocket = socket.accept();
                new ThreadGestioneClienti(clientSocket, this).start();
            }



        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public void gestisciRichiesta(Socket clientSocket) {
        try {
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());

            RichiestaArticolo richiesta = (RichiestaArticolo) in.readObject();
            RispostaRichiesta risposta;
            if(richiesta != null) {
                if(archivio.processaRichiesta(richiesta)){

                     risposta = new RispostaRichiesta("Richiesta accettata", true);

                }else {

                     risposta = new RispostaRichiesta("Richiesta rifiutata", false);

                }

            }else{
                 risposta = new RispostaRichiesta("Richiesta non valida", false);

            }
            out.writeObject(risposta);
            out.flush();
            clientSocket.close();

        }catch (Exception e){
            e.printStackTrace();

        }
    }

}
