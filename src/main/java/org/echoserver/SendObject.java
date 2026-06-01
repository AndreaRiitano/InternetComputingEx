package org.echoserver;

import java.io.*;
import java.net.*;
//GIÀ VERSIONE ADV DELL'ESERCIZIO 2
public class SendObject {
    public static void main (String args[]) {
        try {
            ServerSocket server = new ServerSocket (3575);
            Socket client = server.accept();
            ObjectOutputStream output =
                    new ObjectOutputStream (client.getOutputStream ());
            ObjectInputStream input = new ObjectInputStream (client.getInputStream ());

            output.writeObject("<Welcome>");
            Studente studente =
                    new Studente (14520,"Leonardo","da Vinci","Ingegneria Informatica");
            int matricola = (int) input.readObject();
            if (studente.getMatricola()==matricola) {
                output.writeObject(studente);
            }
            output.writeObject("<Goodbye>");
            client.close();
            server.close();
        } catch (Exception e) { System.err.println (e); }
    }
}