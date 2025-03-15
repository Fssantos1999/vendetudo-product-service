package br.com.vendetudo.marketplace.modules.user.Service;
import br.com.vendetudo.marketplace.modules.user.DTO.UserDTO;

import java.util.List;

public interface UserService {
        UserDTO create(UserDTO user);
        void  delete(Long id);
        UserDTO  update(Long id, UserDTO user);
        List <UserDTO> listarUsuarios();
        UserDTO  findUserById(Long id);
}
