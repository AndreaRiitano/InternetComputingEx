package tracce.t20241108;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

    private String idClient;
    private String hostname;

    public Client(String idClient, String hostname) {
        this.idClient = idClient;
        this.hostname = hostname;
    }

    public void inviaRichiesta(String valutaDa, String valutaA, double importo){

        try{
            Socket socket = new Socket(hostname, Server.PORTA_CLIENT);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            String msg = idClient + ";" + valutaDa + ";" + valutaA + ";" + importo;
            out.writeObject(msg);
            out.flush();

            RispostaConversione risposta = (RispostaConversione) in.readObject();
            System.out.println("Risposta: " + risposta.toString());

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void avviaRicezioneMulti(){
        new ThreadRicezioneMulti().start();
    }
}
