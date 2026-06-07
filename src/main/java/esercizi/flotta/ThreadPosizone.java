package esercizi.flotta;

import java.net.Socket;

public class ThreadPosizone extends Thread{

    private Socket socket;
    private Server server;

    public ThreadPosizone(Socket socket, Server server){
        this.socket = socket;
        this.server = server;
    }

    public void run(){

        try {
            server.addPosizione(socket);
        }catch (Exception e){

        }
    }
}
