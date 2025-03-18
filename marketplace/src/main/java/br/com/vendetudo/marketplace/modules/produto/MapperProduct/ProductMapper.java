package br.com.vendetudo.marketplace.modules.produto.MapperProduct;

import br.com.vendetudo.marketplace.modules.produto.Entity.ProductEntity;
import br.com.vendetudo.marketplace.modules.produto.ProductDto.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductEntity toEntity(ProductDto productDto);
    ProductDto toDto(ProductEntity productEntity);

}
