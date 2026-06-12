package tracce.t20241108;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ThreadRicezioneMulti extends Thread {

    public void run(){

        try{
            MulticastSocket socket = new MulticastSocket(Server.PORTA_MULTI);
            InetAddress group = InetAddress.getByName("239.255.0.1");
            socket.joinGroup(group);

            while(true){
                byte[] buffer = new byte[1024];
                DatagramPacket risposta = new DatagramPacket(buffer, buffer.length);
                socket.receive(risposta);
                String msg = new String(risposta.getData());
                System.out.println(msg);

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
