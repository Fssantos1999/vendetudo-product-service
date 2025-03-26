package br.com.vendetudo.marketplace.modules.produto.ProductDto;
import br.com.vendetudo.marketplace.modules.produto.Enums.ProductTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductDto {

    private String productName;
    private String description;
    private ProductTypeEnum type;
    private Integer quantity;
    private String brand;
    private LocalDate releaseDate;
    private boolean isAvailable = true;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal price;
    private Long id;

    public ProductDto(Long id, String productName, String description,
                         ProductTypeEnum type, BigDecimal price, Integer quantity, String brand, LocalDate releaseDate, boolean isAvailable) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
        this.releaseDate = releaseDate;
        this.isAvailable = isAvailable;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductDto() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductTypeEnum getType() {
        return type;
    }

    public void setType(ProductTypeEnum type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }



}
