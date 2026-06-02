package tracce.t20210318;

import java.net.Socket;

public class ThreadRichiestaClient extends Thread {
    private Socket clientSocket;
    private Server server;

    public ThreadRichiestaClient (Socket clientSocket, Server server) {
        this.clientSocket = clientSocket;
        this.server = server;
    }

    public void run(){
        server.gestisciRichiestaClient(clientSocket);
    }
}
