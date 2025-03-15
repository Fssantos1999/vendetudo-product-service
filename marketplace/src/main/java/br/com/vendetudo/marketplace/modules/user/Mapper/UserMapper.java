package br.com.vendetudo.marketplace.modules.user.Mapper;
import br.com.vendetudo.marketplace.modules.user.DTO.UserDTO;
import br.com.vendetudo.marketplace.modules.user.Entity.UserEntity;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring")

public interface UserMapper {

    @Mapping(target = "viaCepResponse", source = "viaCepResponse")
    UserDTO userToUserDto(UserEntity user); // Converte Entidade → DTO

    @InheritInverseConfiguration
    UserEntity userDtoToUser(UserDTO userDto); // Converte DTO → Entidade

    @IterableMapping(elementTargetType = UserDTO.class)
    List<UserDTO> userToUserDto(List<UserEntity> user);

    //* atualização parcial do usuario
   @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void dtoParaUsuarioAtualizado(UserDTO userDTO, @MappingTarget UserEntity userEntity); //! atualizar usuario





}
