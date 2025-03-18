package br.com.vendetudo.marketplace.modules.produto.Service;

import br.com.vendetudo.marketplace.modules.produto.ProductDto.ProductDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(Long id);
    void deleteProduct(Long id);
    List<ProductDto> getProductsByType(String type);
    ProductDto getProductById(Long id);
    ProductDto applyDiscountToProduct(Long id, BigDecimal discount);
    Boolean deactivateProduct(Long id);
    ProductDto addProductQuantity(Long id , int quantity);
    Map<Long,ProductDto> getProductsByBrand(String brand);
    List<ProductDto> getProductsOnSale();
    List<ProductDto> getLowStockProducts(int threshold);
    ProductDto  updateProductPrice(Long productId, BigDecimal newPrice);

}
