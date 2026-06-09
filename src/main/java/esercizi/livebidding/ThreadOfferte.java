package esercizi.livebidding;

import java.io.IOException;
import java.net.Socket;

public class ThreadOfferte extends Thread {

    private Socket clientSocket;
    private Server server;

    public ThreadOfferte(Socket clientSocket, Server server) {
        this.clientSocket = clientSocket;
        this.server = server;
    }

    public void run() {
        try {
            server.gestisciOfferte(clientSocket);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
