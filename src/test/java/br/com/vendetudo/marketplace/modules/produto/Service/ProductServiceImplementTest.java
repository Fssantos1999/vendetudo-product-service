package br.com.vendetudo.marketplace.modules.produto.Service;

import br.com.vendetudo.marketplace.modules.produto.Entity.ProductEntity;
import br.com.vendetudo.marketplace.modules.produto.Enums.ProductTypeEnum;
import br.com.vendetudo.marketplace.modules.produto.Exception.ProductIsDesactivateException;
import br.com.vendetudo.marketplace.modules.produto.Exception.ProductNotFoundException;
import br.com.vendetudo.marketplace.modules.produto.MapperProduct.ProductMapper;
import br.com.vendetudo.marketplace.modules.produto.ProductDto.ProductDto;
import br.com.vendetudo.marketplace.modules.produto.Repository.ProductRepository;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import static  org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplementTest {
    @InjectMocks
    private ProductServiceImplement service;

    @Mock
    private ProductRepository repository;

    @Mock
    private ProductMapper mapper;

    private ProductDto productDto;
    private ProductEntity productEntity;


    @BeforeEach
    void setUp() {//Arrange

        productDto = new ProductDto(
                2L,
                "Chuteira Nike",
                "Tênis Esportivo",
                ProductTypeEnum.CLOTHING,
                BigDecimal.valueOf(250.00),
                23,
                "Nike",
                LocalDate.of(2025, 5, 23),
                true
        );

        productEntity = new ProductEntity(
                1L,
                "Nike Rosa",
                "Tênis Rosa",
                ProductTypeEnum.CLOTHING,
                BigDecimal.valueOf(250.00),
                23,
                "Nike",
                LocalDate.of(2025, 5, 23),
                true
        );
    }


    @Test
    void deveCriarUmProduto() {

        when(mapper.toEntity(productDto)).thenReturn(productEntity);
        when(repository.save(productEntity)).thenReturn(productEntity);
        when(mapper.toDto(productEntity)).thenReturn(productDto);


        ProductDto savedProduct = service.createProduct(productDto);

        assertNotNull(savedProduct);
        assertEquals(productDto.getId(), savedProduct.getId());

    }

    @Test
    @DisplayName(" lança uma exceção se algum dos campos for nullo")
    void deveLancarExcecaoSeAlgumCampoObrigatorioDoProdutoForNulo() {
        productDto.setProductName(null);
        when(mapper.toEntity(productDto)).thenThrow(new IllegalArgumentException("Produto não pode ser nulo"));
        assertThrows(IllegalArgumentException.class, () -> service.createProduct(productDto));
    }


    @Test
    @DisplayName("lança uma exceção se o produto estiver desativado")
    void atualizarProdutoDeveLancarExcecaoSeProdutoEstiverDesativado() {
        productEntity.setAvailable(false);
        productDto.setAvailable(false);
        productEntity.setProductName("teste");
        productDto.setProductName("teste");
        when(repository.findById(2L)).thenReturn(Optional.of(productEntity));
        assertThrows(ProductIsDesactivateException.class, () -> service.updateProduct(2L, productDto));
    }










}


















