package br.com.vendetudo.marketplace.modules.user.Service;
import br.com.vendetudo.marketplace.modules.user.DTO.UserDTO;
import br.com.vendetudo.marketplace.modules.user.Entity.UserEntity;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface UserService {
    UserDTO create(UserDTO user);
    ResponseEntity <UserDTO>delete(Long id);
    UserDTO update();
    List<UserEntity> listarUsuarios();

}
