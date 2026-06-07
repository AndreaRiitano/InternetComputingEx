package esercizi.flotta;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final int PORTA_CLIENT = 8000;
    public static final int PORTA_OFFLINE= 9000;

    private ArchivioPosizioni archivio = new ArchivioPosizioni();


    public void avvia(){
        try {
            new ThreadControlloOffline(archivio).start();
            ServerSocket serverSocket = new ServerSocket(PORTA_CLIENT);

            while(true){
                Socket clientSocket = serverSocket.accept();
                new ThreadPosizone(clientSocket, this).start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addPosizione(Socket socket){

        try{
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

            PosizioneGPS posizione = (PosizioneGPS) in.readObject();
            if(posizione == null){

                RispostaPosizione risposta = new RispostaPosizione(false, "Posizione non valida");
                out.writeObject(risposta);
                out.flush();
                socket.close();
            }else{

                archivio.aggiornaPosizione(posizione);
                RispostaPosizione risposta = new RispostaPosizione(true, "Posizione aggiornata");
                out.writeObject(risposta);
                out.flush();
                socket.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
