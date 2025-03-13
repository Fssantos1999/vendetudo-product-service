package br.com.vendetudo.marketplace.modules.Adress.Entity;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name = "viacep",url ="viacep.com.br/ws/")
public interface buscarCep {

    @GetMapping("{cep}/json")
    ViaCepResponse buscarcep(@PathVariable("cep")String cep);


}
