package br.com.vendetudo.marketplace.modules.produto.Service;

import br.com.vendetudo.marketplace.modules.produto.Entity.ProductEntity;
import br.com.vendetudo.marketplace.modules.produto.Enums.ProductTypeEnum;
import br.com.vendetudo.marketplace.modules.produto.MapperProduct.ProductMapper;
import br.com.vendetudo.marketplace.modules.produto.ProductDto.ProductDto;
import br.com.vendetudo.marketplace.modules.produto.Repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplementTest {
    @InjectMocks
    private ProductServiceImplement service; //! INJECT MOCK POR QUE E  A CLASSE QUE VAMOS TRABALHAR
    @Mock
    private ProductRepository repository;  //! MOCK POR QUE SAO CLASSES QUE FORAM INJETADAS NO SERVICE
    @Mock
    ProductMapper mapper;


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












}
