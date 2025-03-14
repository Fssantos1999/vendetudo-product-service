package br.com.vendetudo.marketplace.modules.user.Service;
import br.com.vendetudo.marketplace.modules.externalapi.viacep.Controller.BuscarCepApi;
import br.com.vendetudo.marketplace.modules.externalapi.viacep.ViaCepResponse;
import br.com.vendetudo.marketplace.modules.user.DTO.UserDTO;
import br.com.vendetudo.marketplace.modules.user.Entity.UserEntity;
import br.com.vendetudo.marketplace.modules.user.Mapper.UserMapper;
import br.com.vendetudo.marketplace.modules.user.Repository.UserRepository;
import br.com.vendetudo.marketplace.modules.user.exceptions.EmailAlreadyRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private BuscarCepApi buscarCepApi;

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
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return  ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public UserDTO update() {
        return null;
    }


    @Override
    public List<UserEntity> listarUsuarios() {
        return List.of();
    }







}
