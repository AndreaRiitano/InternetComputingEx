package tracce.t20210318;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ThreadRicezioneRiepilogo extends Thread{

    public void   run(){
        try {
            DatagramSocket socket = new DatagramSocket(Server.portaVendite);
            while(true) {
                byte[] buf = new byte[1024];
                DatagramPacket packet = new DatagramPacket (buf, buf.length);
                socket.receive(packet);
                String msg = new String(packet.getData(), 0, packet.getLength());
                System.out.println(msg);

            }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

