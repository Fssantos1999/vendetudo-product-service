package br.com.vendetudo.marketplace.modules.user.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import br.com.vendetudo.marketplace.modules.user.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class UserServiceImplementTest {

    @Mock
    private UserRepository userRepository; // Mock do repositório (não será testado)

    @InjectMocks
    private UserServiceImplement userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void validaCpf_CpfValido_NaoDeveLancarExcecao() {
        String cpf = "12345678900"; // CPF válido

        assertDoesNotThrow(() -> userService.validaCpf(cpf));
    }

    @Test
    void validaCpf_CpfComMaisDe11Digitos_DeveLancarExcecao() {
        String cpf = "123456789001"; // 12 dígitos

        assertThrows(RuntimeException.class, () -> userService.validaCpf(cpf));
    }

    @Test
    void validaCpf_CpfComLetras_DeveLancarExcecao() {
        String cpf = "12345A78900";

        assertThrows(RuntimeException.class, () -> userService.validaCpf(cpf));
    }

    @Test
    void validaCpf_CpfVazio_DeveLancarExcecao() {
        String cpf = ""; // String vazia

        assertThrows(RuntimeException.class, () -> userService.validaCpf(cpf));
    }

    @Test
    void validaCpf_CpfComCaracteresEspeciais_DeveLancarExcecao() {
        String cpf = "123.456.789-00";

        assertThrows(RuntimeException.class, () -> userService.validaCpf(cpf));
    }

    @Test
    void validaCpf_CpfNulo_DeveLancarExcecao() {
        assertThrows(RuntimeException.class, () -> userService.validaCpf(null));
    }
}
