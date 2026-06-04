package tracce.t20230111;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ThreadRicevitoreMisure extends Thread{

    private ArchivioMisure archivioMisure;

    public ThreadRicevitoreMisure(ArchivioMisure ar){
        archivioMisure=ar;
    }

    public void run(){

        try{

            DatagramSocket socket=new DatagramSocket(Server.PORTA_SENSORE);

            while(true){

                byte[] buffer=new byte[9000];
                DatagramPacket packet=new DatagramPacket(buffer,buffer.length);
                socket.receive(packet);
                ByteArrayInputStream bais=new ByteArrayInputStream(packet.getData(), 0,packet.getLength());
                ObjectInputStream in = new ObjectInputStream(bais);
                Misura m = (Misura)in.readObject();
                archivioMisure.salvaMisura(m);
            }


        }catch (Exception e){


        }
    }
}
