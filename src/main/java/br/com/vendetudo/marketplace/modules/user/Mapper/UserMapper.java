package br.com.vendetudo.marketplace.modules.user.Mapper;
import br.com.vendetudo.marketplace.modules.user.DTO.UpdateUserDto;
import br.com.vendetudo.marketplace.modules.user.DTO.UserDTO;
import br.com.vendetudo.marketplace.modules.user.Entity.UserEntity;
import org.mapstruct.*;
import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "viaCepResponse", source = "viaCepResponse")
    UserDTO userToUserDto(UserEntity user);

    @InheritInverseConfiguration
    UserEntity userDtoToUser(UserDTO userDto);

    @IterableMapping(elementTargetType = UserDTO.class)
    List<UserDTO> userToUserDto(List<UserEntity> user);

    @IterableMapping(elementTargetType = UserEntity.class)
    List<UserEntity> userDtoToUserEntity(List<UserDTO> userDTOS);


    @Mapping(target = "viaCepResponse", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "gender", ignore = true)
    @Mapping(target = "cep", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void dtoParaUsuarioAtualizado(UpdateUserDto updateUserDto, @MappingTarget UserEntity userEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "viaCepResponse", ignore = true)
    @Mapping(target = "gender", ignore = true)
    @Mapping(target = "cep", ignore = true)
    UserEntity toEntity(UpdateUserDto updateUserDto);

    UpdateUserDto toDto(UserEntity userEntity);
}

