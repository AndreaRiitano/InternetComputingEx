package org.mutlicasttime;

import java.net.*;
import java.io.*;
import java.util.*;


public class MulticastTimeServer {

     void main(){

         MulticastSocket socket = null;

         try{
            socket = new MulticastSocket(3575);
            int n=0;
            while (n<100){

            byte[] buf = new byte[1024];
            String dString = new Date().toString();
            buf = dString.getBytes();
            InetAddress group = InetAddress.getByName("230.0.0.1");

            DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 3575);

            socket.send(packet);
            System.out.println("E' stato condiviso in multicast: "+dString);
            Thread.sleep(1000);
            n++;
            }

            socket.close();
         }catch (IOException  | IllegalArgumentException | InterruptedException e){
             e.printStackTrace();
             socket.close();
         }




     }
}
