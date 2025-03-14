package br.com.vendetudo.marketplace.modules.user.DTO;

import br.com.vendetudo.marketplace.modules.externalapi.viacep.ViaCepResponse;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

public class UserDTO {
        private Long id;
        private String name;
        private String email;
        private String password;
        private LocalDate birthDate;
        private char gender;
        private List<ViaCepResponse> viaCepResponseList;

        public UserDTO() {
        }

        public List<ViaCepResponse> getViaCepResponseList() {
            return viaCepResponseList;
        }

        public void setViaCepResponseList(List<ViaCepResponse> viaCepResponseList) {
            this.viaCepResponseList = viaCepResponseList;
        }

        public UserDTO(Long id, String name, String email, String password, LocalDate birthDate, char gender, List<ViaCepResponse> viaCepResponseList) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.password = password;
            this.birthDate = birthDate;
            this.gender = gender;
            this.viaCepResponseList = viaCepResponseList;
        }

        public UserDTO(Long id, String name, String email, String password, LocalDate birthDate, char gender) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.password = password;
            this.birthDate = birthDate;
            this.gender = gender;
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
