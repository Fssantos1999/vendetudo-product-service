package br.com.vendetudo.marketplace.modules.user.DTO;


import java.time.LocalDate;

public class UpdateUserDto {
private String name ;
private String email;
private LocalDate birthDate;

    public UpdateUserDto(String name, String email, LocalDate birthDate) {

        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public UpdateUserDto() {
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
}
