package br.com.vendetudo.marketplace.modules.produto.Exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException() {
        super("Produto não encontrado ");
    }
}
