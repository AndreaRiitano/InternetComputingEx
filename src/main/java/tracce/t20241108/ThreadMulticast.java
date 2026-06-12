package tracce.t20241108;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.LinkedList;

public class ThreadMulticast extends Thread{

    private ArchivioConversioni archivio;

    public ThreadMulticast(ArchivioConversioni archivio){
        this.archivio = archivio;
    }

    public void run(){
        try {
            Thread.sleep(Server.QUINDICI);
            MulticastSocket multicastSocket = new MulticastSocket(Server.PORTA_MULTI);
            InetAddress group = InetAddress.getByName("239.255.0.1");
            long limite = System.currentTimeMillis()-Server.QUINDICI;
            LinkedList<Conversione> periodo = new LinkedList<Conversione>(archivio.dopoTot(limite));

            double tassoMedio = 0;
            int numeroConversioni=periodo.size();

            double tassoTot=0;

            for(Conversione conversione: periodo){
                tassoTot += conversione.getTasso();
            }
            tassoMedio = tassoTot/numeroConversioni;

            String msg = tassoMedio+" "+ numeroConversioni;
            byte[] buf = msg.getBytes();
            DatagramPacket risposta = new DatagramPacket(buf, buf.length, group, Server.PORTA_MULTI);
            multicastSocket.send(risposta);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
