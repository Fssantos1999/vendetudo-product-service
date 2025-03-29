package br.com.vendetudo.marketplace.modules.Cart.Dto;

import java.time.Instant;
import java.util.List;


public class CartDto {
    private Long id;
    private String status;
    private Instant createdAt;
    private Instant lastUpdatedAt;
    private Long userId;
    private List<CartItemDto> cartItemDtoList;

    public CartDto() {
    }

    public CartDto(Long id, String status, Instant createdAt, Instant lastUpdatedAt, Long userId, List<CartItemDto> cartItemDtoList) {
        this.id = id;
        this.status = status;
        this.createdAt = createdAt;
        this.lastUpdatedAt = lastUpdatedAt;
        this.userId = userId;
        this.cartItemDtoList = cartItemDtoList;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<CartItemDto> getCartItemDtoList() {
        return cartItemDtoList;
    }

    public void setCartItemDtoList(List<CartItemDto> cartItemDtoList) {
        this.cartItemDtoList = cartItemDtoList;
    }
}
