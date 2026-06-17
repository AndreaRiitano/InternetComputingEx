package esercizio1.marmellataREST;

import java.io.Serializable;

public class VenditaResponseDTO implements Serializable {

    private String message;

    public VenditaResponseDTO(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
