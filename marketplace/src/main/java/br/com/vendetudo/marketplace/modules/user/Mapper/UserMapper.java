package br.com.vendetudo.marketplace.modules.user.Mapper;
import br.com.vendetudo.marketplace.modules.user.DTO.UserDTO;
import br.com.vendetudo.marketplace.modules.user.Entity.UserEntity;
import org.mapstruct.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
//    @Mapping(target = "birthDate", source = "user.birthDate", qualifiedByName = "convertDate")

    @Mapping(target = "viaCepResponse", source = "viaCepResponse") // Mapeia o endereço
    UserDTO userToUserDto(UserEntity user);;

    @InheritInverseConfiguration
    UserEntity userDtoToUser(UserDTO userDto);

    @IterableMapping(elementTargetType = UserDTO.class)
    List<UserDTO> userToUserDto(List<UserEntity> user);

    @Named("convertDate")
    static String convertDate(Date date){
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }



}
