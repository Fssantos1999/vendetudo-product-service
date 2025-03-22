package br.com.vendetudo.marketplace.modules.produto.Exception;

public class ProductWithThisBrandNotExistException extends  RuntimeException {

    public ProductWithThisBrandNotExistException() {
        super("Produto não encontrado com esta marca");
    }
}
