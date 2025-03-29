package br.com.vendetudo.marketplace.modules.Cart.Repository;

import br.com.vendetudo.marketplace.modules.Cart.Entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCartRepository extends JpaRepository<CartItem,Long> {
}
