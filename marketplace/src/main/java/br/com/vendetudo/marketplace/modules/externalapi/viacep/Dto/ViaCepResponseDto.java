package br.com.vendetudo.marketplace.modules.externalapi.viacep.Dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ViaCepResponseDto {
    private String cep;
    private String bairro;
    private String localidade;
    private String uf; // Ajustado para coincidir com a resposta do ViaCEP
    private int ddd;

    public ViaCepResponseDto(String cep, String bairro, String localidade, String uf, int ddd) {
        this.cep = cep;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.ddd = ddd;
    }
    public ViaCepResponseDto() {
    }

    public String getCep() {
        return cep;
    }
    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public int getDdd() {
        return ddd;
    }
}
