package br.com.vendetudo.marketplace.modules.produto.Entity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Table(name = "products")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String productName;
    private String description;
    private String type;
    private Integer quantity;
    private String brand;
    private LocalDate releaseDate;
    private boolean IsAvailable = false ;

    public Product() {
    }

    public Product(Long id, String productName, String description, String type, Integer quantity, String brand, LocalDate releaseDate, boolean isAvailable) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
        return IsAvailable;
    }

    public void setAvailable(boolean available) {
        IsAvailable = available;
    }
}
