package esercizio1.marmellataREST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenditeService {

    @Autowired
    private VenditaRepository repository;

    public void registraIncasso(int idAzienda, String tipoMarmellata, double importo) {
        repository.registraVendita(idAzienda, tipoMarmellata, importo);
    }
}
