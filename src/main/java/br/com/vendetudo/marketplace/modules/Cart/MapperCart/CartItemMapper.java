package br.com.vendetudo.marketplace.modules.Cart.MapperCart;
import br.com.vendetudo.marketplace.modules.Cart.Dto.CartItemDto;
import br.com.vendetudo.marketplace.modules.Cart.Entity.CartItem;
import br.com.vendetudo.marketplace.modules.produto.ProductDto.ProductDetailsForTheCartItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = ProductDetailsForTheCartItemDto.class)
public interface CartItemMapper {

    @Mapping(target = "cart",ignore = true)
    @Mapping(target = "product", source = "productDto")
    CartItem toEntity(CartItemDto dto);

    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "productDto", source = "product")
    CartItemDto toDto(CartItem entity);

    List<CartItem> toEntityList(List<CartItemDto> dtos);
    List<CartItemDto> toDtoList(List<CartItem> entities);


}
