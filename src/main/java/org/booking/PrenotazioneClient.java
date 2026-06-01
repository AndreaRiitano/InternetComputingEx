package org.booking;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class PrenotazioneClient {

    public static void main(String[] args) {

        final int port = 8000;
        final String host = "127.0.0.1";

        try {
            Socket socket = new Socket(host, port);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Prenotazione p = new Prenotazione("122", "casa", 4);

            oos.writeObject(p);

            Esito risposta = (Esito) ois.readObject();
            System.out.println(risposta.toString());
        }catch (Exception e){}


    }
}
