package org.mutlicasttime;
import java.net.*;
import java.io.*;

public class MulticastTimeClient {

    void main ()throws IOException{

        MulticastSocket socket = new MulticastSocket(3575);
        InetAddress group = InetAddress.getByName("230.0.0.1");
        socket.joinGroup(group);

        DatagramPacket packet;

        for(int i=0; i<100; i++){
            byte[] buf = new byte[1024];
            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            String message = new String(packet.getData());
            System.out.println(message);
        }
        socket.leaveGroup(group);
        socket.close();

    }
}
