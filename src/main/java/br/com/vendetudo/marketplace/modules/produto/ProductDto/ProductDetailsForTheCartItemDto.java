package br.com.vendetudo.marketplace.modules.produto.ProductDto;

import java.math.BigDecimal;

public class ProductDetailsForTheCartItemDto {
    private Long id;
    private String productName;
    private String brand;
    private Integer quantity;
    private BigDecimal price;
    private boolean isAvailable = true;
    public ProductDetailsForTheCartItemDto(Long id, String productName, String brand, Integer quantity, BigDecimal price, boolean isAvailable) {
        this.id = id;
        this.productName = productName;
        this.brand = brand;
        this.quantity = quantity;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
