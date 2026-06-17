package esercizio1.marmellataREST;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class VenditaRepository {

    private Map<Integer, Map<String, Double>> aziende = new HashMap<>();

    public void registraVendita(int idAzienda, String tipoMarmellata, double importo){

        aziende.putIfAbsent(idAzienda, new HashMap<>());
        Map<String, Double> vendite = aziende.get(idAzienda);
        vendite.put(tipoMarmellata, vendite.getOrDefault(tipoMarmellata, 0.0) + importo);
    }
}
