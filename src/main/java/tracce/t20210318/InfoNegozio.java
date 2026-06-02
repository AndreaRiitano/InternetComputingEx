package tracce.t20210318;

public class InfoNegozio {

    private  String idNegozio;
    private String host;

    public InfoNegozio(String idNegozio, String host){
        this.idNegozio = idNegozio;
        this.host = host;
    }

    public String getIdNegozio(){
        return this.idNegozio;
    }

    public String getHost(){
        return this.host;
    }

    public String toString(){
        return this.idNegozio + " " + this.host;
    }
}
