package br.com.vendetudo.marketplace.Mapper;

import br.com.vendetudo.marketplace.modules.user.DTO.UserDTO;
import br.com.vendetudo.marketplace.modules.user.Entity.UserEntity;
import br.com.vendetudo.marketplace.modules.user.Mapper.UserMapper;
import br.com.vendetudo.marketplace.modules.user.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testUserDtoToUserEntity() {
        UserDTO dto = new UserDTO();
        dto.setName("João");
        dto.setEmail("joao@email.com");

        // Chama o método para mapear o DTO para a entidade
        UserEntity entity = userMapper.userDtoToUser(dto);

        // Verifica se a conversão foi feita corretamente
        assertNotNull(entity);
        assertEquals(dto.getName(), entity.getName());
        assertEquals(dto.getEmail(), entity.getEmail());
    }
}
