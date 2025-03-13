package br.com.vendetudo.marketplace.modules.externalapi.viacep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import br.com.vendetudo.marketplace.modules.externalapi.viacep.ViaCepResponse;

@RestController
public class ViaCepService {

    @Autowired
    private buscarCep buscarCepService;

    @GetMapping("/{cep}")
    public ResponseEntity<ViaCepResponse>getcep(@PathVariable String cep){
        ViaCepResponse viacep = buscarCepService.buscarcep(cep);
        return viacep != null ? ResponseEntity.ok().body(viacep) : ResponseEntity.badRequest().build();
    }

}
