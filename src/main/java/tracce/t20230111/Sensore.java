package tracce.t20230111;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class Sensore {

    private String idSensore;
    private String hostServer;

    public Sensore(String idSensore, String hostServer) {

        this.idSensore = idSensore;
        this.hostServer = hostServer;
    }

    public void inviaMisura(double valore){
        try {
            Misura misura = new Misura(idSensore, valore, System.currentTimeMillis());
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteStream);
            out.writeObject(misura);
            out.flush();

            byte[] dati = byteStream.toByteArray();
            DatagramPacket packet = new DatagramPacket(dati, dati.length,
                    InetAddress.getByName(hostServer), Server.PORTA_SENSORE);
            DatagramSocket socket = new DatagramSocket();
            socket.send(packet);
            socket.close();

        }catch (Exception e){
            System.err.println("Error in invia misura.");
        }
    }

    public void invioPeriodico(){

        Random rand = new Random();

        while(true){

            double valore = rand.nextDouble()*40 + 10;
            inviaMisura(valore);
            try {
                Thread.sleep(5*60*1000);
            }catch (Exception e){

                System.err.println("Error in invio periodico.");
            }
        }

    }


}
