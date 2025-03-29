package br.com.vendetudo.marketplace.modules.Cart.Dto;

import br.com.vendetudo.marketplace.modules.Cart.Entity.HistoricCartProduct;
import br.com.vendetudo.marketplace.modules.Cart.Enums.CartStatusEnum;
import br.com.vendetudo.marketplace.modules.produto.Entity.ProductEntity;
import br.com.vendetudo.marketplace.modules.produto.ProductDto.ProductDto;
import br.com.vendetudo.marketplace.modules.user.Entity.UserEntity;

import java.time.Instant;
import java.util.List;

public class CartDto {
    private Long id;
    private CartStatusEnum status;
    private Instant createdAt;
    private Instant lastUpdatedAt;
    private List<ProductDto> productsDto;
    private List<HistoricCartProductDto> productCartsDto;

    public CartDto() {
    }

    public CartDto(Long id, CartStatusEnum status, Instant createdAt, Instant lastUpdatedAt, List<ProductDto> productsDto, List<HistoricCartProductDto> productCartsDto) {
        this.id = id;
        this.status = status;
        this.createdAt = createdAt;
        this.lastUpdatedAt = lastUpdatedAt;
        this.productsDto = productsDto;
        this.productCartsDto = productCartsDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CartStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CartStatusEnum status) {
        this.status = status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Instant lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public List<ProductDto> getProductsDto() {
        return productsDto;
    }

    public void setProductsDto(List<ProductDto> productsDto) {
        this.productsDto = productsDto;
    }

    public List<HistoricCartProductDto> getProductCartsDto() {
        return productCartsDto;
    }

    public void setProductCartsDto(List<HistoricCartProductDto> productCartsDto) {
        this.productCartsDto = productCartsDto;
    }
}
