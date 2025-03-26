package br.com.vendetudo.marketplace.modules.produto.MapperProduct;
import br.com.vendetudo.marketplace.modules.produto.Entity.ProductEntity;
import br.com.vendetudo.marketplace.modules.produto.ProductDto.ProductDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductEntity toEntity(ProductDto productDto);

    ProductDto toDto(ProductEntity productEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void parcialUpdateProducts(ProductDto productDto, @MappingTarget ProductEntity productEntity);


    List<ProductDto> listToDto(List<ProductEntity>entities);

    List<ProductEntity> listToEntitie(List<ProductDto>dtoslist);

}
