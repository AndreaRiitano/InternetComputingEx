package esercizio1.marmellataREST;

import org.apache.catalina.SessionIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.io.Serializable;

@RestController
@RequestMapping("/aziende")
public class VenditeController implements Serializable {


    @Autowired
    private VenditeService service;

    @PostMapping("/{idAzienda}/vendite")
    public VenditaResponseDTO salvaIncasso(@PathVariable int idAzienda, @RequestBody VenditaRequestDTO venditaRequestDTO) {

        service.registraIncasso(idAzienda, venditaRequestDTO.getTipoMarmellata(), venditaRequestDTO.getImporto());
        VenditaResponseDTO risposta = new VenditaResponseDTO("Incasso registrato con successo");
        return risposta;
    }

}
