package br.com.vendetudo.marketplace.modules.produto.Repository;

import br.com.vendetudo.marketplace.modules.produto.Entity.ProductEntity;
import br.com.vendetudo.marketplace.modules.user.DTO.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    @Query("select u from ProductEntity u where lower(u.brand) = lower(?1)")
    List<ProductEntity> findByBrandEqualsIgnoreCase(@Param("brand") String brand);

    @Modifying
    @Query("UPDATE ProductEntity p SET p.quantity = p.quantity + :quantity WHERE p.id = :id")
    void addQuantity(@Param("id") Long id, @Param("quantity") Integer quantity);

    boolean existsByBrand(String brand);

    @Query("SELECT p FROM ProductEntity p where p.isAvailable IS TRUE ")
    List<ProductEntity> listProductStatusIfValueIsTrue();

}
