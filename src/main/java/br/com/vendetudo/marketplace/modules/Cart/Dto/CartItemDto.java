package br.com.vendetudo.marketplace.modules.Cart.Dto;



import br.com.vendetudo.marketplace.modules.produto.ProductDto.ProductDetailsForTheCartItemDto;

import java.math.BigDecimal;
import java.time.Instant;

public class CartItemDto {
    private Long id;
    private ProductDetailsForTheCartItemDto productDto;
    private int quantity;
    private BigDecimal totalprice;
    private Instant createdAt;
    private Instant updatedAt;

    public CartItemDto() {
    }

    public CartItemDto(Long id, ProductDetailsForTheCartItemDto productDto, int quantity, BigDecimal totalprice, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.productDto = productDto;
        this.quantity = quantity;
        this.totalprice = totalprice;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductDetailsForTheCartItemDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDetailsForTheCartItemDto productDto) {
        this.productDto = productDto;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
