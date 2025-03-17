package br.com.vendetudo.marketplace.modules.produto.Entity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String productName;
    private String description;
    private String type;
    private BigDecimal price;
    private Integer quantity;
    private String brand;
    private LocalDate releaseDate;
    private boolean IsAvailable = false ;
    public Product() {
    }

    public Product(Long id, String productName, String description,
                   String type, BigDecimal price, Integer quantity, String brand, LocalDate releaseDate, boolean isAvailable) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
        this.releaseDate = releaseDate;
        IsAvailable = isAvailable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
        return IsAvailable;
    }

    public void setAvailable(boolean available) {
        IsAvailable = available;
    }
}
