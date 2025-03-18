package br.com.vendetudo.marketplace.modules.produto.Exception;

import br.com.vendetudo.marketplace.modules.produto.Entity.ProductEntity;

public class ProductNotFound extends RuntimeException{
    public ProductNotFound(String message) {
        super(message);
    }

    public ProductNotFound() {
        super("Produto não encontrado ");
    }
}
