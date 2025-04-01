package br.com.vendetudo.marketplace.modules.Cart.Service;

import br.com.vendetudo.marketplace.modules.Cart.Dto.CartDto;
import br.com.vendetudo.marketplace.modules.user.DTO.UserDTO;

public interface CartService {
    CartDto createCart(Long userId);
    CartDto getCart(Long userId);
    void clearCart(Long userId);
}


