package br.com.vendetudo.marketplace.modules.user.Service;
import br.com.vendetudo.marketplace.modules.user.DTO.UserDTO;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface UserService {
    UserDTO create(UserDTO user);
    ResponseEntity <UserDTO>delete(Long id);
    UserDTO  update(Long id, UserDTO user);
    List <UserDTO> listarUsuarios();

}
