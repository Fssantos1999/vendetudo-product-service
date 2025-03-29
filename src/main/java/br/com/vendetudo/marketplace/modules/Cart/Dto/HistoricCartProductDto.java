package br.com.vendetudo.marketplace.modules.Cart.Dto;

import br.com.vendetudo.marketplace.modules.Cart.Entity.CartEntity;
import br.com.vendetudo.marketplace.modules.produto.Entity.ProductEntity;

import java.math.BigDecimal;
import java.time.Instant;

public class HistoricCartProductDto {
    private Long id;
    private ProductEntity product;
    private CartEntity cart;
    private int quantity;
    private BigDecimal totalprice;
    private Instant createdAt;
    private Instant updatedAt;

    public HistoricCartProductDto(Long id, ProductEntity product,
                                  CartEntity cart, int quantity,
                                  BigDecimal totalprice, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.product = product;
        this.cart = cart;
        this.quantity = quantity;
        this.totalprice = totalprice;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public HistoricCartProductDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public CartEntity getCart() {
        return cart;
    }

    public void setCart(CartEntity cart) {
        this.cart = cart;
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
