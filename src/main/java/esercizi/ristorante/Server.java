package esercizi.ristorante;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORTA_CLIENT = 5000;
    ArchivioRichieste archivio =  new ArchivioRichieste();

    public void avvia (){
        try {
            ServerSocket serverSocket = new ServerSocket(PORTA_CLIENT);

            while (true){
                Socket clientSocket = serverSocket.accept();
                new ThreadRichieste(this, clientSocket).start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void riceviRichiesta(Socket clientSocket) {
        try {
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            RichiestaPrenotazione richiesta = (RichiestaPrenotazione) in.readObject();

            String msg = archivio.aggiungiPrenotazione(richiesta);

            out.writeObject(msg);
            out.flush();
            clientSocket.close();

        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
