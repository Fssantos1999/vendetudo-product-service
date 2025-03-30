package br.com.vendetudo.marketplace.modules.Cart.Service;

import br.com.vendetudo.marketplace.modules.Cart.Dto.CartDto;
import br.com.vendetudo.marketplace.modules.Cart.Dto.CartItemDto;
import br.com.vendetudo.marketplace.modules.Cart.Entity.CartItem;
import br.com.vendetudo.marketplace.modules.Cart.MapperCart.CartItemMapper;
import br.com.vendetudo.marketplace.modules.Cart.Repository.ItemCartRepository;
import br.com.vendetudo.marketplace.modules.produto.ProductDto.ProductDetailsForTheCartItemDto;
import br.com.vendetudo.marketplace.modules.produto.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class CartItemServiceImplements implements CartServiceItemService {
    private final ProductRepository productRepository;
    private final ItemCartRepository itemCartRepository;
    private final  CartItemMapper cartItemMapper;
    private  CartItemDto carts;

    @Autowired
    public CartItemServiceImplements(ProductRepository productRepository, ItemCartRepository itemCartRepository, CartItemMapper cartItemMapper) {
        this.productRepository = productRepository;
        this.itemCartRepository = itemCartRepository;
        this.cartItemMapper = cartItemMapper;
    }


    @Override
    public CartDto addItemToCart(CartDto cart, ProductDetailsForTheCartItemDto product, int quantity) {
        return null;
    }

    @Override
    public void removeItemFromCart(CartDto cart, CartItem cartItem) {

    }

    @Override
    public CartDto updateItemQuantity(CartDto cart, CartItem cartItem, int newQuantity) {
        return null;
    }

    @Override
    public BigDecimal calculateItemTotal(CartItem cartItem) {
        return null;
    }
}


