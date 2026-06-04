package tracce.t20230111;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

    private String hostServer;

    public Client(String hostServer) {
        this.hostServer = hostServer;
    }

    public Misura richiediMisura(String idSensore){

        try {

            Socket socket = new Socket(hostServer, Server.PORTA_CLIENT);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            out.writeObject(idSensore);
            out.flush();
            socket.close();
            Misura misura = (Misura) in.readObject();

            return misura;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }
}
