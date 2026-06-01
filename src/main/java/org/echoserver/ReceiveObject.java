package org.echoserver;

import java.io.*;
import java.net.*;

public class ReceiveObject {
    public static void main (String args[]) {
        try {
            Socket socket = new Socket ("localhost",3575);
            ObjectInputStream input =
                    new ObjectInputStream (socket.getInputStream ());
            BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
            System.out.println("inserire matricola");
            ObjectOutputStream output = new ObjectOutputStream (socket.getOutputStream ());
            int matricola =  Integer.parseInt(br.readLine());
            String beginMessage = (String)input.readObject();
            System.out.println (beginMessage);
            output.writeObject(matricola);
            Object rispostaServer = input.readObject();

            if (rispostaServer instanceof Studente) {
                Studente studente = (Studente)rispostaServer;
                System.out.print (studente.getMatricola()+" - ");
                System.out.print (studente.getNome()+" "+studente.getCognome()+" - ");
                System.out.print (studente.getCorsoDiLaurea()+"\n");

            }else {

                System.out.println ("errore");
            }
            String endMessage = (String)input.readObject();
            System.out.println (endMessage);
            socket.close();
        } catch (Exception e) { System.err.println (e);
        }
    }
}