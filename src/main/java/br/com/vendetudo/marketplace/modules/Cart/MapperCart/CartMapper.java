package br.com.vendetudo.marketplace.modules.Cart.MapperCart;

import br.com.vendetudo.marketplace.modules.Cart.Dto.CartDto;
import br.com.vendetudo.marketplace.modules.Cart.Entity.CartEntity;
import br.com.vendetudo.marketplace.modules.Cart.Entity.HistoricCartProduct;
import br.com.vendetudo.marketplace.modules.produto.MapperProduct.ProductMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, HistoricCartProductMapper.class})
public interface CartMapper {

    @Mapping(target = "productsDto", source = "product")
    @Mapping(target = "productCartsDto", source = "productCarts")
    CartDto toDto(CartEntity entity);

    @Mapping(target = "product", source = "productsDto")
    @Mapping(target = "productCarts", source = "productCartsDto")
    CartEntity toEntity(CartDto dto);

    List<CartEntity> toEntityList(List<CartDto> dtos);
    List<CartDto> toDtoList(List<CartEntity> entities);

    void updateEntityFromDto(CartDto dto, @MappingTarget CartEntity entity);

}
