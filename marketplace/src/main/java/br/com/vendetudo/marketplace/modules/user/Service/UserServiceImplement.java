package br.com.vendetudo.marketplace.modules.user.Service;
import br.com.vendetudo.marketplace.modules.externalapi.viacep.Controller.BuscarCepApi;
import br.com.vendetudo.marketplace.modules.externalapi.viacep.ViaCepResponse;
import br.com.vendetudo.marketplace.modules.user.DTO.UserDTO;
import br.com.vendetudo.marketplace.modules.user.Entity.UserEntity;
import br.com.vendetudo.marketplace.modules.user.Mapper.UserMapper;
import br.com.vendetudo.marketplace.modules.user.Repository.UserRepository;
import br.com.vendetudo.marketplace.modules.user.exceptions.EmailAlreadyRegisteredException;
import br.com.vendetudo.marketplace.modules.user.exceptions.EmptyListExceptions;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserServiceImplement implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BuscarCepApi buscarCepApi;

    @Autowired
    public UserServiceImplement(UserRepository userRepository, UserMapper userMapper, BuscarCepApi buscarCepApi) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.buscarCepApi = buscarCepApi;
    }

    @Override
    public UserDTO create(UserDTO userDTO) {
        ViaCepResponse viaCepResponse = buscarCepApi.buscarcep(userDTO.getCep());
        userDTO.setViaCepResponse(viaCepResponse);
        UserEntity userEntity = userMapper.userDtoToUser(userDTO);
        if (userRepository.findByEmail(userEntity.getEmail()).isPresent()) {
            throw new EmailAlreadyRegisteredException();
        }

        viaCepResponse.setUserEntity(userEntity);
        UserEntity savedUser = userRepository.save(userEntity);
        return userMapper.userToUserDto(savedUser);
    }

    @Override
    public ResponseEntity<UserDTO> delete(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public UserDTO update(Long id, UserDTO user) {
     UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
       userMapper.dtoParaUsuarioAtualizado(user, userEntity);
        userRepository.save(userEntity);
       return userMapper.userToUserDto(userEntity);

    }

    @Override
    public List<UserDTO> listarUsuarios() {
        List listarUsuarios = userMapper.userToUserDto(userRepository.findAll());
        if (listarUsuarios.isEmpty()) {
            throw new EmptyListExceptions();
        }
        return listarUsuarios;
    }


}
