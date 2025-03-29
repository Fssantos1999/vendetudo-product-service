package br.com.vendetudo.marketplace.modules.Cart.MapperCart;
import br.com.vendetudo.marketplace.modules.Cart.Dto.CartItemDto;
import br.com.vendetudo.marketplace.modules.Cart.Entity.CartItem;
import br.com.vendetudo.marketplace.modules.produto.MapperProduct.ProductMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public interface CartItemMapper {

    @Mapping(target = "product", source = "productDto")
    CartItem toEntity(CartItemDto dto);

    @Mapping(target = "productDto", source = "product")
    CartItemDto toDto(CartItem entity);

    List<CartItem> toEntityList(List<CartItemDto> dtos);
    List<CartItemDto> toDtoList(List<CartItem> entities);
}
