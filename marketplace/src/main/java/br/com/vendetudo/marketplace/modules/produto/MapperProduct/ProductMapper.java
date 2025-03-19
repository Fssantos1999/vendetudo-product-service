package br.com.vendetudo.marketplace.modules.produto.MapperProduct;
import br.com.vendetudo.marketplace.modules.produto.Entity.ProductEntity;
import br.com.vendetudo.marketplace.modules.produto.ProductDto.ProductDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductEntity toEntity(ProductDto productDto);

    ProductDto toDto(ProductEntity productEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void parcialUpdateProducts(ProductDto productDto, @MappingTarget ProductEntity productEntity);

    @Mapping(target = "quantity", expression = "java( productDto.getQuantity() + productEntity.getQuantity() )")
    void addQuantity(ProductDto productDto, @MappingTarget ProductEntity productEntity);


}
