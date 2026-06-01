package org.echoserver;

import java.net.*;
import java.io.*;
import java.util.Objects;

public class EchoClient {
    public static void main(String args[]) {
        try {
            Socket s = new Socket("localhost", 8189);
            //LEGGERE DAL SERVER
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            //SCRIVERE AL SERVER
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            // 3. Canale per LEGGERE dalla TASTIERA (System.in)
            // Usiamo la stessa logica a matrioska: InputStream -> Reader -> BufferedReader
            BufferedReader consoleIn = new BufferedReader(
                    new InputStreamReader(System.in)
            );
            System.out.println("Server dice: " + in.readLine());
            String userInput="";
            while(!Objects.equals(userInput, "EXIT")){
                userInput = consoleIn.readLine();

                out.println(userInput);

                String serverResponse = in.readLine();
                System.out.println("Server: " + serverResponse);

            }


        } catch (IOException e) {
            System.out.println(e);
        }

        System.out.println("fine");
    }
}
