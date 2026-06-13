package esercizio1.marmellataWSDL;

import javax.jws.*;

@WebService
public interface AziendaService {

    @WebMethod
    void Vendita(int idAzienda, String tipoMarmellata, double importo);

    @WebMethod
    IncassoProdotto MaggioreIncasso(int idAzienda);
}
