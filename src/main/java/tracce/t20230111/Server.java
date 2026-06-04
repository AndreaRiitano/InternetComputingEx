package tracce.t20230111;

import java.io.IOException;
import java.net.*;

public class Server {

    public final static int PORTA_CLIENT = 3000;
    public final static int PORTA_SENSORE =  4000;
    public final static int PORTA_TIMEOUT = 5000;
    public final static String GRUPPO_MULTI = "230.0.0.1";
    public final static long  DIECIMIN = 10*60*1000;

    private ArchivioMisure archivio = new ArchivioMisure();

    public void avvia() throws Exception{
        new ThreadRicevitoreMisure(archivio).start();
        new ThreadControlloSensori(archivio).start();

        ServerSocket ss = new ServerSocket(PORTA_CLIENT);
        while(true){
            Socket socketClient = ss.accept();
            new ThreadClient(socketClient, archivio).start();
        }

    }
}
