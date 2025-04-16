package br.com.vendetudo.marketplace.modules.produto.Service;
import br.com.vendetudo.marketplace.modules.produto.Entity.ProductEntity;
import br.com.vendetudo.marketplace.modules.produto.Enums.ProductTypeEnum;
import br.com.vendetudo.marketplace.modules.produto.ProductDto.ProductDto;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(Long id, ProductDto dto);
    void deleteProduct(Long id);
    List<ProductEntity> getProductsByType(ProductTypeEnum type);
    ProductDto getProductById(Long id);
    ProductDto deactivateProduct(Long id,Boolean status);
    ProductDto addProductQuantity(Long id , Integer quantity);
    List<ProductDto> getLowStockProducts(Integer threshold);
    ProductDto  updateProductPrice(Long productId, BigDecimal newPrice);


}
