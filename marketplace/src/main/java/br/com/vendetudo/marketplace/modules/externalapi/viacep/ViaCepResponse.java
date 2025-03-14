package br.com.vendetudo.marketplace.modules.externalapi.viacep;
import br.com.vendetudo.marketplace.modules.user.Entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

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
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
     private UserEntity  userEntity;

    public ViaCepResponse(Long id, String cep, String bairro, String localidade, String estado, String regiao, int ddd, UserEntity userEntity) {
        this.id = id;
        this.cep = cep;
        this.bairro = bairro;
        this.localidade = localidade;
        this.estado = estado;
        this.regiao = regiao;
        this.ddd = ddd;
        this.userEntity = userEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
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
