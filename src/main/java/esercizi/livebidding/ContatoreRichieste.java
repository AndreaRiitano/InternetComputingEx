package esercizi.livebidding;

public class ContatoreRichieste {

    private int contatore;

    public ContatoreRichieste(int contatore) {
        this.contatore = contatore;
    }

    public int getContatore() {
        return contatore;
    }
    public void setContatore(int contatore) {
        this.contatore = contatore;
    }

    public synchronized  boolean entra (){

        if(contatore>0){
            contatore--;
            return true;
        }else{
            return false;
        }
    }

    public synchronized void esci(){
        contatore++;
    }
}
