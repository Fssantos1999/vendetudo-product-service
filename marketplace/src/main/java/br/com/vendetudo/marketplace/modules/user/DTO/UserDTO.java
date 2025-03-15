package br.com.vendetudo.marketplace.modules.user.DTO;
import br.com.vendetudo.marketplace.modules.externalapi.viacep.ViaCepResponse;
import java.time.LocalDate;

public class UserDTO {
    private String name;
    private String email;
    private LocalDate birthDate;
    private char gender;
    private ViaCepResponse viaCepResponse;
    private String cep;
    private Long id;

    public UserDTO() {
    }

    public UserDTO(String name, String email, LocalDate birthDate, char gender, ViaCepResponse viaCepResponse, String cep, Long id) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.gender = gender;
        this.viaCepResponse = viaCepResponse;
        this.cep = cep;
        this.id = id;
    }

    public UserDTO(String name, String email, char gender,Long id) {
        this.name = name;
        this.email = email;
        this.gender = gender;
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

    public ViaCepResponse getViaCepResponse() {
        return viaCepResponse;
    }

    public void setViaCepResponse(ViaCepResponse viaCepResponse) {
        this.viaCepResponse = viaCepResponse;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
