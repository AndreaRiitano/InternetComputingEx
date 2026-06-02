package tracce.t20210318;

public class MainClient {
    public static void main(String[] args) {
        Client client = new Client("localhost");
        client.inviaRichiesta("Smartphone",2, 140.0);
    }
}
