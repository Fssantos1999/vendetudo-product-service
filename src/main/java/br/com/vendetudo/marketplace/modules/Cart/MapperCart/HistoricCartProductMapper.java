package br.com.vendetudo.marketplace.modules.Cart.MapperCart;

import br.com.vendetudo.marketplace.modules.Cart.Dto.CartDto;
import br.com.vendetudo.marketplace.modules.Cart.Dto.HistoricCartProductDto;
import br.com.vendetudo.marketplace.modules.Cart.Entity.CartEntity;
import br.com.vendetudo.marketplace.modules.Cart.Entity.HistoricCartProduct;
import br.com.vendetudo.marketplace.modules.produto.MapperProduct.ProductMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HistoricCartProductMapper {

    @Mapping(target = "cart", source = "cartDto")
    @Mapping(target = "product", source = "productDto")
    HistoricCartProduct toEntity(HistoricCartProductDto dto);

    @Mapping(target = "cartDto", source = "cart")
    @Mapping(target = "productDto", source = "product")
    HistoricCartProductDto toDto(HistoricCartProduct entity);

    List<HistoricCartProduct> toEntityList(List<HistoricCartProductDto> dtos);
    List<HistoricCartProductDto> toDtoList(List<HistoricCartProduct> entities);



}
