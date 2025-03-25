package br.com.vendetudo.marketplace.modules.produto.Service;

import br.com.vendetudo.marketplace.modules.produto.Entity.ProductEntity;
import br.com.vendetudo.marketplace.modules.produto.Enums.ProductTypeEnum;
import br.com.vendetudo.marketplace.modules.produto.MapperProduct.ProductMapper;
import br.com.vendetudo.marketplace.modules.produto.ProductDto.ProductDto;
import br.com.vendetudo.marketplace.modules.produto.Repository.ProductRepository;
import org.h2.util.ScriptReader;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplementTest {
    @InjectMocks
    private ProductServiceImplement service; // Classe a ser testada

    @Mock
    private ProductRepository repository; // Mock do repositório

    @Mock
    private ProductMapper mapper; // Mock do mapper

    private ProductDto productDto;
    private ProductEntity productEntity;
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImplementTest.class);


    @BeforeEach
    void setUp() {
        productDto = new ProductDto(1L, "Nike", "Tenis Rosa", ProductTypeEnum.CLOTHING,
                BigDecimal.valueOf(250.00), 23, "Adidas",
                LocalDate.of(2025, 5, 23), true);

        productEntity = new ProductEntity(1L, "Nike", "Tenis Rosa", ProductTypeEnum.CLOTHING,
                BigDecimal.valueOf(250.00), 23, "Adidas",
                LocalDate.of(2025, 5, 23), true);
    }



    @Test
    void deveAtualizarProduto() {
        //*PRODUTO ATUAL NA ENTIDADE ADIDAS E TENIS BRANCO
        ProductEntity entity = new ProductEntity(1L,
                "Adidas", "Tenis Branco", ProductTypeEnum.CLOTHING,
                BigDecimal.valueOf(25000), 23, "Adidas",
                LocalDate.of(2025, 5, 23), true);
        //*PRODUTO DEPOIS DE ATUALIZADO DEVE CONTERR TENIS ROSA E NIKE
        ProductDto dtos = new ProductDto(1L,
                "Nike", "Tenis Rosa", ProductTypeEnum.CLOTHING,
                BigDecimal.valueOf(25000), 23, "Adidas",
                LocalDate.of(2025, 5, 23), true);

        System.out.println("Antes da atualização: " + entity.getProductName() + " " + entity.getDescription());

        // 🔹🔹🔹🔹 Mockando a busca no banco
        when(repository.findById(1L)).thenReturn(Optional.of(entity)); //!deve retornar um optional pq o findbyid espera um optional

        //!🔹🔹🔹 🔹 Simulando a atualização da entidade
            doAnswer(invocation -> {
                ProductDto dtoArg = invocation.getArgument(0);
                ProductEntity entityArg = invocation.getArgument(1);

                // !Atualizando os valores manualmente
                entityArg.setProductName(dtoArg.getProductName());
                entityArg.setDescription(dtoArg.getDescription());
                entityArg.setAvailable(dtoArg.isAvailable());

                return null;
            }).when(mapper).parcialUpdateProducts(any(ProductDto.class), any(ProductEntity.class));

        // !🔹🔹🔹🔹 Mock do save() para garantir que a entidade atualizada seja retornada
        when(repository.save(any(ProductEntity.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // *🔹 🔹🔹🔹QUANDO FEITO MAPPER DA ENTIDADE  DEVE ME RETORNAR UM DTO
        when(mapper.toDto(any(ProductEntity.class))).thenReturn(dtos);


        ProductDto imprimir = service.updateProduct(1L, dtos);

        // 🔹🔹🔹🔹 DEBUGA
        System.out.println("Depois da atualização: " + entity.getProductName() + " " + entity.getDescription());
        System.out.println("Retorno do método: " + imprimir.getProductName() + " " + imprimir.getDescription());

        // 🔹🔹🔹🔹 NAO PODE ME RETORNAR NULO E TEM QUE ME RETORNAR UM NIKE E  TENIS ROSA
        assertNotNull(imprimir, "O retorno do updateProduct não pode ser nulo");
        assertEquals("Nike", imprimir.getProductName());
        assertEquals("Tenis Rosa", imprimir.getDescription());
        assertTrue(imprimir.isAvailable());

        // 🔹🔹🔹🔹 Verificações dos mocks para ver see esta sendo salvo no bd
        verify(repository).findById(1L);
        verify(mapper).parcialUpdateProducts(dtos, entity);
        verify(repository).save(entity);
        verify(mapper).toDto(entity);
    }


    @Test
    void deveCriarUmProduto() {
        // Configuração dos mocks
        when(mapper.toEntity(productDto)).thenReturn(productEntity);
        when(repository.save(productEntity)).thenReturn(productEntity);
        when(mapper.toDto(productEntity)).thenReturn(productDto);

        // Executa o método a ser testado
        ProductDto savedProduct = service.createProduct(productDto);

        // Verificações
        assertNotNull(savedProduct); // Verifica se não é null
        assertEquals(productDto, savedProduct); // Verifica se o retorno é correto

        // Garante que os métodos foram chamados
        verify(mapper).toEntity(productDto);
        verify(repository).save(productEntity);
        verify(mapper).toDto(productEntity);


    }

}
