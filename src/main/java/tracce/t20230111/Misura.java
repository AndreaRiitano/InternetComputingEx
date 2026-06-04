package tracce.t20230111;

import java.io.Serializable;

public class Misura implements Serializable {

    private String idSensore;
    private double valoreMisurato;
    private long timestamp;

    public Misura(String idSensore, double valoreMisurato, long timestamp) {
        this.idSensore = idSensore;
        this.valoreMisurato = valoreMisurato;
        this.timestamp = timestamp;
    }

    public String getIdSensore() {
        return idSensore;
    }

    public double getValoreMisurato() {
        return valoreMisurato;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String toString() {
        return idSensore + "\t" + valoreMisurato + "\t" + timestamp;
    }
}
