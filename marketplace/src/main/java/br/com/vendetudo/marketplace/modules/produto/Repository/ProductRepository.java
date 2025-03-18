package br.com.vendetudo.marketplace.modules.produto.Repository;

import br.com.vendetudo.marketplace.modules.produto.Entity.ProductEntity;
import br.com.vendetudo.marketplace.modules.user.DTO.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

@Query("select u from ProductEntity u where u.brand = ?1")
List <ProductEntity> findByBrand(String brand);

}
