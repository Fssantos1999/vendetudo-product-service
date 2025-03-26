package br.com.vendetudo.marketplace.modules.produto.Exception;

import java.math.BigDecimal;

public class InvalidPriceException extends RuntimeException {
    public InvalidPriceException(BigDecimal price) {
        super("Preço inválido: " + price + ". O preço deve ser maior que zero.");
    }
}