package br.com.vendetudo.marketplace.modules.produto.Service;
import br.com.vendetudo.marketplace.modules.produto.Entity.ProductEntity;
import br.com.vendetudo.marketplace.modules.produto.Enums.ProductTypeEnum;
import br.com.vendetudo.marketplace.modules.produto.Exception.*;
import br.com.vendetudo.marketplace.modules.produto.MapperProduct.ProductMapper;
import br.com.vendetudo.marketplace.modules.produto.ProductDto.ProductDto;
import br.com.vendetudo.marketplace.modules.produto.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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
            throw new ProductNotFoundException();
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
                .orElseThrow(ProductNotFoundException::new);
        if (quantity <= 0) {
            throw new QuantityLimitException();
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
        List <ProductEntity> listEntity =   productRepository.listProductWithLowQuantityInStock(threshold);

        return productMapper.listToDto(listEntity);
    }

    @Override
    public ProductDto updateProductPrice(Long productId, BigDecimal newPrice) {

        ProductEntity productEntity = productRepository.findById(productId)
                .orElseThrow(ProductNotFoundException::new);
        if (newPrice.compareTo(BigDecimal.ZERO) <=0) {
            throw new InvalidPriceException(newPrice);
        }
        if (!productEntity.isAvailable()){
            throw  new ProductIsDesactivateException();
        }
        productEntity.setPrice(newPrice);
        productRepository.save(productEntity);
        return productMapper.toDto(productEntity);
    }
}
