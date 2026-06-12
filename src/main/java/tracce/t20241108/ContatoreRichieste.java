package tracce.t20241108;

public class ContatoreRichieste {

    private int attive;
    private int massimo;

    public ContatoreRichieste(int massimo) {
        this.attive = 0;
        this.massimo = massimo;
    }

    public synchronized boolean entra(){

        if(massimo > attive){
            attive++;
            return true;
        }else {
            return false;
        }
    }

    public synchronized void esci(){
        if(attive > 0) {
            attive--;
        }
    }
}
