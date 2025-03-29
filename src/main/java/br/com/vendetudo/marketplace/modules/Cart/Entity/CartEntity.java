package br.com.vendetudo.marketplace.modules.Cart.Entity;
import br.com.vendetudo.marketplace.modules.Cart.Enums.CartStatusEnum;
import br.com.vendetudo.marketplace.modules.produto.Entity.ProductEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Entity
public class CartEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_cart")
    private CartStatusEnum status;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant lastUpdatedAt ;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductEntity> product;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HistoricCartProduct> productCarts;
//    @OneToMany
//    private Set <UserEntity> userEntity;

    public CartEntity() {
    }

    public CartEntity(Long id, CartStatusEnum status,
                      Instant createdAt, Instant lastUpdatedAt, List<ProductEntity> product, List<HistoricCartProduct> productCarts) {
        this.id = id;
        this.status = status;
        this.createdAt = createdAt;
        this.lastUpdatedAt = lastUpdatedAt;
        this.product = product;
        this.productCarts = productCarts;
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

    public List<ProductEntity> getProduct() {
        return product;
    }

    public void setProduct(List<ProductEntity> product) {
        this.product = product;
    }

    public List<HistoricCartProduct> getProductCarts() {
        return productCarts;
    }

    public void setProductCarts(List<HistoricCartProduct> productCarts) {
        this.productCarts = productCarts;
    }
}
