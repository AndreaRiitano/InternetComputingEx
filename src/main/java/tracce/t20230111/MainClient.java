package tracce.t20230111;

public class MainClient {

    public static void main(String[] args) {

        Client cliente = new Client("localhost");
        Misura m= cliente.richiediMisura("S1");
        System.out.println(m);
    }
}
