package br.com.vendetudo.marketplace.modules.produto.Exception;

public class QuantityLimitException extends  RuntimeException{
    public QuantityLimitException() {
        super("Quantidade inválida para adicionar uma quantidade de produtos a quantidade tem que ser maior que 0");
    }
}
