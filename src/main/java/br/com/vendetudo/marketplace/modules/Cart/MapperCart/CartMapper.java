package br.com.vendetudo.marketplace.modules.Cart.MapperCart;
import br.com.vendetudo.marketplace.modules.Cart.Dto.CartDto;
import br.com.vendetudo.marketplace.modules.Cart.Entity.CartEntity;
import br.com.vendetudo.marketplace.modules.user.Mapper.UserMapper;
import org.mapstruct.*;

import java.util.List;


@Mapper(componentModel = "spring", uses = {UserMapper.class, CartItemMapper.class})
public interface CartMapper {

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "cartItemDtoList", source = "cartItems")
    CartDto toDto(CartEntity entity);

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "cartItems", source = "cartItemDtoList")
    CartEntity toEntity(CartDto dto);

    List<CartEntity> toEntityList(List<CartDto> dtos);
    List<CartDto> toDtoList(List<CartEntity> entities);
}
