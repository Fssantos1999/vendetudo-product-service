package br.com.vendetudo.marketplace.modules.produto.MapperProduct;
import br.com.vendetudo.marketplace.modules.produto.Entity.ProductEntity;
import br.com.vendetudo.marketplace.modules.produto.ProductDto.ProductDetailsForTheCartItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel="spring")
public interface ProductDetailMapper {


    @Mapping(target = "isAvailable", ignore = true)
    ProductDetailsForTheCartItemDto toDto(ProductEntity entity);

    @Mapping(target = "type", ignore = true)
    @Mapping(target = "releaseDate", ignore = true)
    @Mapping(target = "description", ignore = true)
    ProductEntity toEntity(ProductDetailsForTheCartItemDto dto);





}


