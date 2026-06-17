package esercizio1.marmellataREST;

import java.io.Serializable;

public class MiglioreResponseDTO implements Serializable {

    private String tipoMarmellata;
    private double importo;

    public MiglioreResponseDTO(String tipoMarmellata, double importo) {
        this.tipoMarmellata = tipoMarmellata;
        this.importo = importo;
    }
    public String getTipoMarmellata() {
        return tipoMarmellata;
    }
    public void setTipoMarmellata(String tipoMarmellata) {
        this.tipoMarmellata = tipoMarmellata;

    }
    public double getImporto() {
        return importo;
    }
    public void setImporto(double importo) {
        this.importo = importo;
    }
}
