package br.com.vendetudo.marketplace.modules.produto.Service;

import br.com.vendetudo.marketplace.modules.produto.Entity.ProductEntity;
import br.com.vendetudo.marketplace.modules.produto.Exception.ProductIsDesactivateException;
import br.com.vendetudo.marketplace.modules.produto.Exception.ProductNotFoundException;
import br.com.vendetudo.marketplace.modules.produto.Exception.QuantityLimitException;
import br.com.vendetudo.marketplace.modules.produto.MapperProduct.ProductMapper;
import br.com.vendetudo.marketplace.modules.produto.ProductDto.ProductDto;
import br.com.vendetudo.marketplace.modules.produto.Repository.ProductRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductServiceImplement implements ProductService {


    ProductRepository productRepository;
    ProductMapper productMapper;

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
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException();
        }
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDto> getProductsByType(String type) {
        return List.of();
    }

    @Override
    public ProductDto getProductById(Long id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        return productMapper.toDto(productEntity);
    }

    @Override
    public ProductDto applyDiscountToProduct(Long id, BigDecimal discount) {
        return null;
    }

    @Override
    public Boolean deactivateProduct(Long id, Boolean status) {
        ProductEntity productDto = productRepository.findById(id).orElseThrow(() ->new RuntimeException("product not found"));
        ProductDto dto =    productMapper.toDto(productDto);
        dto.setAvailable(status);
        productRepository.save(productDto);
        return   status;
    }

    @Transactional
    @Override
    public ProductDto addProductQuantity(Long id, Integer quantity) {
        if(quantity <= 0){
            throw  new RuntimeException("A quantidade deve ser maior que 0");
        }
        ProductEntity updatedProduct = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com ID: " + id));
        if(!updatedProduct.isAvailable()){
            throw  new ProductIsDesactivateException();
        }
        productRepository.addQuantity(id, quantity);
        return productMapper.toDto(updatedProduct);
    }

    public Map<Long, ProductDto> getProductsByBrand(String brand) {
        return productRepository.findByBrand(brand).stream()
                .map(productMapper::toDto)
                .collect(Collectors.toMap(ProductDto::getId, productDto->productDto));
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
