package br.com.vendetudo.marketplace.modules.produto.Exception;

public class ProductIsDesactivateException extends  RuntimeException{
    public ProductIsDesactivateException() {
        super("Produto Indisponível");
    }
}
