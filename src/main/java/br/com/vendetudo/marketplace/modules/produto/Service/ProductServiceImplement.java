package br.com.vendetudo.marketplace.modules.produto.Service;
import br.com.vendetudo.marketplace.modules.produto.Entity.ProductEntity;
import br.com.vendetudo.marketplace.modules.produto.Enums.ProductTypeEnum;
import br.com.vendetudo.marketplace.modules.produto.Exception.ProductIsDesactivateException;
import br.com.vendetudo.marketplace.modules.produto.Exception.ProductNotFoundException;
import br.com.vendetudo.marketplace.modules.produto.Exception.ProductWithThisBrandNotExistException;
import br.com.vendetudo.marketplace.modules.produto.MapperProduct.ProductMapper;
import br.com.vendetudo.marketplace.modules.produto.ProductDto.ProductDto;
import br.com.vendetudo.marketplace.modules.produto.Repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.text.ListFormat;
import java.util.List;
import java.util.Locale;
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
    public ProductDto createProduct(ProductDto create) {
        ProductEntity product = productMapper.toEntity(create);
        ProductEntity savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }
    @Override
    public ProductDto updateProduct(Long id, ProductDto dto) {
        ProductEntity entity = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        if (!entity.isAvailable()) {
            throw new ProductIsDesactivateException();
        }
        productMapper.parcialUpdateProducts(dto,entity);
        productRepository.save(entity);
        return productMapper.toDto(entity);
    }

    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException();
        }
        productRepository.deleteById(id);
    }

    @Override
    public List <ProductEntity> getProductsByType(ProductTypeEnum type) {
        if(productRepository.filterByType(type).isEmpty()){
            throw new RuntimeException("Este tipo de produto nao foi encontrado");
        }
        return productRepository.filterByType(type);
    }


    @Override
    public ProductDto getProductById(Long id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        return productMapper.toDto(productEntity);
    }

    @Override
    public ProductDto deactivateProduct(Long id, Boolean status) {
        ProductEntity productDto = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        ProductDto dto = productMapper.toDto(productDto);
        dto.setAvailable(status);
        productRepository.save(productDto);
        return dto;
    }

    @Transactional
    @Override
    public ProductDto addProductQuantity(Long id, Integer quantity) {
        ProductEntity updatedProduct = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com ID: " + id));
        if (quantity <= 0) {
            throw new RuntimeException("A quantidade deve ser maior que 0");
        }
        if (!updatedProduct.isAvailable()) {
            throw new ProductIsDesactivateException();
        }
        productRepository.addQuantity(id, quantity);
        return productMapper.toDto(updatedProduct);
    }

    public Map<Long, ProductDto> getProductsByBrand(String brand) {
         if(productRepository.findByBrandEqualsIgnoreCase(brand).isEmpty()){
            throw new ProductWithThisBrandNotExistException();
        }
        return productRepository.findByBrandEqualsIgnoreCase(brand).stream()
                .map(productMapper::toDto)
                .collect(Collectors.toMap(ProductDto::getId, productDto -> productDto));
    }

    @Override
    public List<ProductDto> getLowStockProducts(int threshold) {
        return List.of();
    }

    @Override
    public ProductDto updateProductPrice(Long productId, BigDecimal newPrice) {
        if (!productRepository.existsById(productId)) {
            throw new ProductNotFoundException();
        }
        if (newPrice.compareTo(BigDecimal.ZERO) <=0) {
            throw new RuntimeException("valor nao pode ser zero");
        }
        ProductEntity entity = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("error"));
        return productMapper.toDto(entity);
    }
}
