package br.com.vendetudo.marketplace.modules.user.Repository;

import br.com.vendetudo.marketplace.modules.user.DTO.UserDTO;
import br.com.vendetudo.marketplace.modules.user.Entity.UserEntity;
import br.com.vendetudo.marketplace.modules.user.Mapper.UserMapper;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {
    @Autowired
    EntityManager entityManager;
    @Autowired
    private UserMapper userMapper;


    @Test
    void findByEmail() {
    }

    private UserEntity createUser(UserDTO data) {
        UserEntity newUser = userMapper.userDtoToUser(data);
        return newUser;
    }

}