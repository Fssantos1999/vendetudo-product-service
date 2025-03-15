package br.com.vendetudo.marketplace.modules.user.Service;
import br.com.vendetudo.marketplace.modules.externalapi.viacep.Controller.BuscarCepApi;
import br.com.vendetudo.marketplace.modules.externalapi.viacep.ViaCepResponse;
import br.com.vendetudo.marketplace.modules.user.DTO.UpdateUserDto;
import br.com.vendetudo.marketplace.modules.user.DTO.UserDTO;
import br.com.vendetudo.marketplace.modules.user.Entity.UserEntity;
import br.com.vendetudo.marketplace.modules.user.Mapper.UserMapper;
import br.com.vendetudo.marketplace.modules.user.Repository.UserRepository;
import br.com.vendetudo.marketplace.modules.user.exceptions.EmailAlreadyRegisteredException;
import br.com.vendetudo.marketplace.modules.user.exceptions.EmptyListExceptions;
import br.com.vendetudo.marketplace.modules.user.exceptions.UserNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


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
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFound();
        }
        userRepository.deleteById(id);
    }

    @Override
    public void update(Long id, UpdateUserDto user) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFound();
        }
        UserEntity userEntity = userRepository.findById(id).orElseThrow(UserNotFound::new);
        userMapper.dtoParaUsuarioAtualizado(user, userEntity);
        userRepository.save(userEntity);
    }

    @Override
    public List<UserDTO> listarUsuarios() {
        List listaUsuarios = userMapper.userToUserDto(userRepository.findAll());
        if (listaUsuarios.isEmpty()) {
            throw new EmptyListExceptions();
        }
        return listaUsuarios;
    }

    @Override
    public UserDTO findUserById(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow(UserNotFound::new);
        return  userMapper.userToUserDto(user);

    }


}
