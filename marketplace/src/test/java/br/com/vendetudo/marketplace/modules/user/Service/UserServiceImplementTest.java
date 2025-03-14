package br.com.vendetudo.marketplace.modules.user.Service;

import br.com.vendetudo.marketplace.MarketplaceApplication;
import br.com.vendetudo.marketplace.modules.user.DTO.UserDTO;
import br.com.vendetudo.marketplace.modules.user.Entity.UserEntity;
import br.com.vendetudo.marketplace.modules.user.Mapper.UserMapper;
import br.com.vendetudo.marketplace.modules.user.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@SpringBootTest(classes = MarketplaceApplication.class)

class UserServiceImplementTest {

    @InjectMocks
    private UserServiceImplement userService;

    @Mock
    private UserMapper userMapper;

    @Mock
    private UserRepository userRepository;

    private UserDTO userDTO;
    private UserEntity userEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Setup de dados simulados
        userDTO = new UserDTO();
        userDTO.setEmail("test@example.com");
        userDTO.setName("Test User");

        userEntity = new UserEntity();
        userEntity.setEmail("test@example.com");
        userEntity.setName("Test User");
    }

    @Test
    void create_shouldCreateUser() {
        // Configuração do mock
        when(userMapper.userDtoToUser(userDTO)).thenReturn(userEntity);
        when(userRepository.save(userEntity)).thenReturn(userEntity);

        // Chamando o método de serviço
        UserDTO createdUser = userService.create(userDTO);

        // Verificando se o método do mapper e do repositório foram chamados corretamente
        verify(userMapper, times(1)).userDtoToUser(userDTO);
        verify(userRepository, times(1)).save(userEntity);

        // Verificando se o retorno está correto
        assertNotNull(createdUser);
        assertEquals(userDTO.getEmail(), createdUser.getEmail());
        assertEquals(userDTO.getName(), createdUser.getName());
    }
}
