package tracce.t20241108;

import java.net.Socket;

public class ThreadConversione extends Thread{

    private Socket clientSocket;
    private Server server;

    public ThreadConversione(Socket clientSocket, Server server){
        this.clientSocket = clientSocket;
        this.server = server;
    }

    public void run(){
        server.gestisciRichieste(clientSocket);
    }

}
