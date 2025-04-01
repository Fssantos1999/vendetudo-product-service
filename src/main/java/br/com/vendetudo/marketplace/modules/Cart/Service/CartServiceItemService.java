package br.com.vendetudo.marketplace.modules.Cart.Service;
import br.com.vendetudo.marketplace.modules.Cart.Dto.CartDto;
import br.com.vendetudo.marketplace.modules.Cart.Entity.CartItem;
import br.com.vendetudo.marketplace.modules.produto.ProductDto.ProductDetailsForTheCartItemDto;
import java.math.BigDecimal;
import java.util.List;

public interface CartServiceItemService {

    CartDto addItemToCart(Long cart,ProductDetailsForTheCartItemDto productDetailsForTheCartItemDto, int quantity);

    void removeItemFromCart(CartDto cart, CartItem cartItem);

    CartDto updateItemQuantity(CartDto cart, CartItem cartItem, int newQuantity);

    BigDecimal calculateItemTotal(CartItem cartItem);
    List<CartItem> getCartItems(CartDto cart);

}
