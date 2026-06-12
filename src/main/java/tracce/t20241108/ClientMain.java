package tracce.t20241108;

public class ClientMain {
    public static void main(String[] args) {

        Client client = new Client("1", "239.255.0.1");
        client.avviaRicezioneMulti();
        client.inviaRichiesta("EUR", "USD", 100);
    }
}
