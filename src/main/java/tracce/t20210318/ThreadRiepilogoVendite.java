package tracce.t20210318;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.LinkedList;

public class ThreadRiepilogoVendite {
    private LinkedList<InfoNegozio> negozi;
    private ArchivioVendite archivioVendite;

    public ThreadRiepilogoVendite(LinkedList<InfoNegozio> negozi, ArchivioVendite archivioVendite){

        this.negozi = negozi;
        this.archivioVendite = archivioVendite;
    }

    public void run(){

        try{
            while (true){
                Thread.sleep(Server.giorno);
                DatagramSocket udp = new DatagramSocket();

                for(int i = 0; i < negozi.size(); i++){

                    double totale = archivioVendite.getTotale(negozi.get(i));
                    String msg = negozi.get(i).toString() + " "  + totale;
                    byte[] buf = msg.getBytes();
                    DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(negozi.get(i).getHost()), Server.portaVendite);
                    udp.send(packet);
                }
                udp.close();
            }

        }catch (Exception e){


        }
    }
}
