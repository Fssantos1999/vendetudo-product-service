package br.com.vendetudo.marketplace.modules.user.Entity;
import br.com.vendetudo.marketplace.modules.externalapi.viacep.ViaCepResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "accounts")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String cep;
    private String password;
    private LocalDate birthDate;
    private char gender;
    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "via_cep_response_id")
    private ViaCepResponse viaCepResponse;

    public UserEntity() {
    }

    public UserEntity(Long id, String name, String email, String cep, String password, LocalDate birthDate, char gender, ViaCepResponse viaCepResponse) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cep = cep;
        this.password = password;
        this.birthDate = birthDate;
        this.gender = gender;
        this.viaCepResponse = viaCepResponse;
    }


    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public ViaCepResponse getViaCepResponse() {
        return viaCepResponse;
    }

    public void setViaCepResponse(ViaCepResponse viaCepResponse) {
        this.viaCepResponse = viaCepResponse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
