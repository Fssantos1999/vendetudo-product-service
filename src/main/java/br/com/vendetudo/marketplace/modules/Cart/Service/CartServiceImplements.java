package br.com.vendetudo.marketplace.modules.Cart.Service;
import br.com.vendetudo.marketplace.modules.Cart.Dto.CartDto;
import br.com.vendetudo.marketplace.modules.Cart.Entity.CartEntity;
import br.com.vendetudo.marketplace.modules.Cart.MapperCart.CartMapper;
import br.com.vendetudo.marketplace.modules.Cart.Repository.CartRepository;
import br.com.vendetudo.marketplace.modules.user.DTO.UserDTO;
import br.com.vendetudo.marketplace.modules.user.Entity.UserEntity;
import br.com.vendetudo.marketplace.modules.user.Repository.UserRepository;
import br.com.vendetudo.marketplace.modules.user.exceptions.UserNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImplements implements  CartService {
    private final CartRepository cartRepository ;
    private final CartMapper cartMapper;
    private UserRepository userRepository;
    private UserDTO userDTO;
    private CartDto cartDto;

    @Autowired
    public CartServiceImplements(CartRepository cartRepository, CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
    }

    @Override
    public CartDto createCart(Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(UserNotFound::new);
        Optional <CartEntity>existingCart = cartRepository.findByUserId(userId);
        if (existingCart.isPresent()) {
            return cartMapper.toDto(existingCart.get());
        }
        CartEntity cart = new CartEntity();
        cart.setUser(user);
        cartRepository.save(cart);
        return cartMapper.toDto(cart);
    }

    @Override
    public CartDto getCart(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFound();
        }
        return  cartRepository.findByUserId(userId).map(cartMapper::toDto).orElseGet(()->createCart(userId));
    }

    @Override
    public void clearCart(Long userId) {

    }
}
