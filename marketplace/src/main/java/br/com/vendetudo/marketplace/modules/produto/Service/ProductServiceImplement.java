package br.com.vendetudo.marketplace.modules.produto.Service;

import br.com.vendetudo.marketplace.modules.produto.Entity.ProductEntity;
import br.com.vendetudo.marketplace.modules.produto.Enums.ProductTypeEnum;
import br.com.vendetudo.marketplace.modules.produto.Exception.ProductNotFound;
import br.com.vendetudo.marketplace.modules.produto.MapperProduct.ProductMapper;
import br.com.vendetudo.marketplace.modules.produto.ProductDto.ProductDto;
import br.com.vendetudo.marketplace.modules.produto.Repository.ProductRepository;
import br.com.vendetudo.marketplace.modules.user.exceptions.UserNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductServiceImplement implements  ProductService{


    ProductRepository productRepository;
    ProductMapper productMapper ;

    @Autowired
    public ProductServiceImplement(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public ProductDto updateProduct(Long id) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        if(!productRepository.existsById(id)){
            throw  new ProductNotFound();
        }
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDto> getProductsByType(String type) {
        return List.of();
    }

    @Override
    public ProductDto getProductById(Long id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(ProductNotFound::new);
        return  productMapper.toDto(productEntity);
    }

    @Override
    public ProductDto applyDiscountToProduct(Long id, BigDecimal discount) {
        return null;
    }

    @Override
    public Boolean deactivateProduct(Long id) {
        return null;
    }

    @Override
    public ProductDto addProductQuantity(Long id, int quantity) {
        return null;
    }

    @Override
    public Map<Long, ProductDto> getProductsByBrand(String brand) {
        return Map.of();
    }


    @Override
    public List<ProductDto> getProductsOnSale() {
        return List.of();
    }

    @Override
    public List<ProductDto> getLowStockProducts(int threshold) {
        return List.of();
    }

    @Override
    public ProductDto updateProductPrice(Long productId, BigDecimal newPrice) {
        return null;
    }
}
