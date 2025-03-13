package br.com.vendetudo.marketplace.modules.Adress.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ViaCepResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep ;
    private String bairro;
    private String localidade;
    private String estado;
    private String regiao;
    private int ddd;

    public ViaCepResponse(String cep,  String bairro, String localidade, String estado, String regiao, int ddd) {
        this.cep = cep;

        this.bairro = bairro;
        this.localidade = localidade;
        this.estado = estado;
        this.regiao = regiao;
        this.ddd = ddd;
    }

    public ViaCepResponse() {

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

    public String getEstado() {
        return estado;
    }

    public String getRegiao() {
        return regiao;
    }

    public int getDdd() {
        return ddd;
    }
}
