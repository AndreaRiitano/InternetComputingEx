package tracce.t20230111;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.LinkedList;

public class ThreadControlloSensori extends Thread{

    private ArchivioMisure archivio;

    public ThreadControlloSensori(ArchivioMisure archivio){
        this.archivio = archivio;
    }

    public void run(){

        try{
            MulticastSocket socket = new MulticastSocket();
            InetAddress group = InetAddress.getByName(Server.GRUPPO_MULTI);
            while (true){
                Thread.sleep(60000);
                LinkedList<String> guasti = archivio.getSensoriNonFunzionanti(Server.DIECIMIN);
                String messaggio = guasti.toString();
                byte[] buf = messaggio.getBytes();
                DatagramPacket packet = new DatagramPacket(buf, buf.length, group, Server.PORTA_TIMEOUT);
                socket.send(packet);
                socket.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
