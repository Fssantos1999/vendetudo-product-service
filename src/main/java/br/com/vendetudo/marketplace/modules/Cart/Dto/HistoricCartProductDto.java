package br.com.vendetudo.marketplace.modules.Cart.Dto;
import br.com.vendetudo.marketplace.modules.produto.ProductDto.ProductDto;

import java.math.BigDecimal;
import java.time.Instant;

public class HistoricCartProductDto {
    private Long id;
    private ProductDto productDto;
    private CartDto cartDto;
    private int quantity;
    private BigDecimal totalprice;
    private Instant createdAt;
    private Instant updatedAt;

    public HistoricCartProductDto() {
    }

    public HistoricCartProductDto(Long id, ProductDto productDto, CartDto cartDto, int quantity, BigDecimal totalprice, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.productDto = productDto;
        this.cartDto = cartDto;
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

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public CartDto getCartDto() {
        return cartDto;
    }

    public void setCartDto(CartDto cartDto) {
        this.cartDto = cartDto;
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
