package esercizi.flotta;

import tracce.t20230111.ArchivioMisure;

import javax.xml.crypto.Data;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.LinkedList;

public class ThreadControlloOffline extends Thread {

    private ArchivioPosizioni archiviPosizioni;

    public ThreadControlloOffline(ArchivioPosizioni archiviPosizioni) {
        this.archiviPosizioni = archiviPosizioni;
    }

    public void run(){

        try {
            MulticastSocket socket= new MulticastSocket(Server.PORTA_OFFLINE);
            InetAddress group = InetAddress.getByName("230.0.0.1");

                while(true){
                    Thread.sleep(5000);
                    LinkedList<String> offline = archiviPosizioni.furgoniOffline();
                    String msg = offline.toString();
                    byte[] buffer = msg.getBytes();
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, Server.PORTA_OFFLINE);
                    socket.send(packet);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
