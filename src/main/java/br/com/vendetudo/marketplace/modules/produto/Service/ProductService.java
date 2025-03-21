package br.com.vendetudo.marketplace.modules.produto.Service;

import br.com.vendetudo.marketplace.modules.produto.Entity.ProductEntity;
import br.com.vendetudo.marketplace.modules.produto.ProductDto.ProductDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(Long id, ProductDto dto);
    void deleteProduct(Long id);
    List<ProductDto> getProductsByType(String type);
    ProductDto getProductById(Long id);
    ProductDto applyDiscountToProduct(Long id, BigDecimal discount);
    ProductDto deactivateProduct(Long id,Boolean status);
    ProductDto addProductQuantity(Long id , Integer quantity);
    List<ProductDto> getProductsOnSale();
    List<ProductDto> getLowStockProducts(int threshold);
    ProductDto  updateProductPrice(Long productId, BigDecimal newPrice);

}
