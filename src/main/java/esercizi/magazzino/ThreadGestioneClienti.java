package esercizi.magazzino;

import java.net.Socket;

public class ThreadGestioneClienti extends Thread{

    private Socket socket;
    private Server server;

    public ThreadGestioneClienti(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
    }

    public void run() {
        try {
            server.gestisciRichiesta(socket);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
