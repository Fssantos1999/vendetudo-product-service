package br.com.vendetudo.marketplace.modules.externalapi.viacep.Service;

import br.com.vendetudo.marketplace.modules.externalapi.viacep.Dto.ViaCepResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {
    private static final String URL = "https://viacep.com.br/ws/{cep}/json/";

    public ViaCepResponseDto buscarCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(URL, ViaCepResponseDto.class, cep);
    }
}
