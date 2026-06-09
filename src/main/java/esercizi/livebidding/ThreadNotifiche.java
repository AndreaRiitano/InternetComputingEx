package esercizi.livebidding;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.util.HashMap;

public class ThreadNotifiche extends Thread{

    private ArchivioOfferte archivio;

    public ThreadNotifiche(ArchivioOfferte archivio) {
        this.archivio = archivio;
    }

    public void run() {

        try{

            MulticastSocket socket = new MulticastSocket(Server.PORTA_NOTIFICHE);
            InetAddress group = InetAddress.getByName("229.1.1.1");
            while(true) {
                Thread.sleep(5000);
                HashMap<String, Offerta> offerteVincenti = archivio.offerteVincenti();
                String msg = offerteVincenti.toString();
                byte[] buf = msg.getBytes();
                DatagramPacket risposta = new DatagramPacket(buf, buf.length, group, Server.PORTA_NOTIFICHE);
                socket.send(risposta);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
