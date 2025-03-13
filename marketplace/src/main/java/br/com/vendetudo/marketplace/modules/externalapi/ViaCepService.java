package br.com.vendetudo.marketplace.modules.Adress.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ViaCepService {

    @Autowired
    private buscarCep viacep;

    @GetMapping("/{cep}")
    public ResponseEntity<ViaCepResponse>getcep(@PathVariable String cep){

        ViaCepResponse viaCepResponse = viacep.buscarcep(cep);
        return viaCepResponse != null ? ResponseEntity.ok().body(viaCepResponse) : ResponseEntity.badRequest().build();

    }

}
