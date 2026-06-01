package org.booking;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class PrenotazioniServer {
    public static void main(String[] args) {
       final int port = 8000;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            Prenotazione  prenotazione = (Prenotazione) ois.readObject();
            System.out.println(prenotazione.toString());

            Esito risposta;
            //prova giusto per dire se la prenotazione supera i 3 giorni rifiuta
            if (prenotazione.getNGiorni()<=3){

                risposta = new Esito(true, "prenotazione confermata");
            }else {

                risposta = new Esito(false, "prenotazione rifiutata");
            }

            oos.writeObject(risposta);
            System.out.println("Riposta inviata");
            serverSocket.close();
            clientSocket.close();
            System.out.println("FINE");



        }catch (Exception e){}

    }

}
