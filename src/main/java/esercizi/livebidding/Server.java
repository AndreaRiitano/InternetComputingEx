package esercizi.livebidding;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final int PORTA_NOTIFICHE = 5555;
    public static final int PORTA_CLIENT = 4444;
    private ContatoreRichieste contatoreRichieste = new ContatoreRichieste(3);
    private ArchivioOfferte archivio = new ArchivioOfferte();

    public void avvia(){
        try {
            ServerSocket socket = new ServerSocket(PORTA_CLIENT);
            new ThreadNotifiche(archivio).start();
            while (true){
                Socket client = socket.accept();
                new ThreadOfferte(client, this).start();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void gestisciOfferte(Socket clientSocket){

        try {
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            Offerta offerta = (Offerta) in.readObject();
            if (contatoreRichieste.entra()) {
                try {
                    RispostaOfferta risposta = archivio.aggiungiOfferta(offerta);
                    out.writeObject(risposta);
                }finally {contatoreRichieste.esci();}

            }else{
                RispostaOfferta risposta = new RispostaOfferta(false, "Server sovraccaricato");
                out.writeObject(risposta);
            }
            out.flush();
            clientSocket.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
