package esercizi.ristorante;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ThreadRichieste extends Thread{

    private Server server;
    private Socket clientSocket;

    public ThreadRichieste(Server server, Socket clientSocket) {
        this.server = server;
        this.clientSocket = clientSocket;
    }

    public void run(){
        try{
            server.riceviRichiesta(clientSocket);
        }catch(Exception e){

            e.printStackTrace();
        }

    }
}

