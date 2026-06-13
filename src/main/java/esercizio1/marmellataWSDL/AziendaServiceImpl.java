package esercizio1.marmellataWSDL;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

@WebService(endpointInterface ="azienda.AziendaService" )
public class AziendaServiceImpl implements AziendaService {

    private Map<Integer, HashMap<String, Double>> database = new HashMap<>();

    @Override
    public void Vendita(int idAzienda, String tipoMarmellata, double importo) {
        
    }

    @Override
    public IncassoProdotto MaggioreIncasso(int idAzienda) {
        return null;
    }
}
