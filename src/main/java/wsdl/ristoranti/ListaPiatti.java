package wsdl.ristoranti;

import java.io.Serializable;
import java.util.LinkedList;

public class ListaPiatti implements Serializable {

    private LinkedList<Piatto> listaPiatti;

    public ListaPiatti(LinkedList<Piatto> listaPiatti){
        this.listaPiatti = listaPiatti;
    }
    public LinkedList<Piatto> getListaPiatti(){
        return this.listaPiatti;
    }
}
