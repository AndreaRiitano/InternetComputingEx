package tracce.t20241108;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Random;

public class Server {

    public final static int PORTA_CLIENT= 2222;
    public final static int PORTA_MULTI=5000;
    public final static int QUINDICI = 15*60*1000;
    private ContatoreRichieste contatoreRichieste= new ContatoreRichieste(10);
    private ArchivioConversioni archivio;
    private LinkedList<String> idValidi;
    private LinkedList<String> codiciValidi;
    private Random random = new Random();


    public void avvia(){
        try {
            ServerSocket serverSocket = new ServerSocket(PORTA_CLIENT);
            new ThreadMulticast(archivio).start();

            while (true){
                Socket clientSocket = serverSocket.accept();
                new ThreadConversione(clientSocket, this).start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void gestisciRichieste(Socket socket){

        try{
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            String msg = (String) in.readObject();
            String[] partiMsg = msg.split(";");

            if(partiMsg.length !=4){
                RispostaConversione risposta = new RispostaConversione(false, "Errore formato richiesta non valido", -1, -1);
                out.writeObject(risposta);
                out.flush();
                socket.close();
                return;
            }

            String id = partiMsg[0];
            String codiceDa = partiMsg[1];
            String codiceA = partiMsg[2];
            double importo = Double.parseDouble(partiMsg[3]);

            if(!contatoreRichieste.entra()){

                RispostaConversione risposta = new RispostaConversione(false, "-1", -1, -1);
                out.writeObject(risposta);
                out.flush();
                socket.close();
            }

            if(idValidi.contains(id) && codiciValidi.contains(codiceDa) && codiciValidi.contains(codiceA)){

                try{
                    double tasso = 0.1 + random.nextDouble() + (5 - 0.1);
                    double risultato = importo * tasso;
                    Conversione esito = new Conversione(id, codiceDa, codiceA, importo, tasso, risultato);
                    archivio.addConversione(esito);
                    RispostaConversione risposta = new RispostaConversione(true, "andata bene", importo, tasso);
                    out.writeObject(risposta);
                    out.flush();
                    socket.close();


                }finally {
                    contatoreRichieste.esci();
                }

            }else {
                RispostaConversione risposta = new RispostaConversione(false, "Id o valuta non validi", -1, -1);
                out.writeObject(risposta);
                out.flush();
                socket.close();
            }
            socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
