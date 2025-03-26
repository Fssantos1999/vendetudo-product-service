package br.com.vendetudo.marketplace.modules.produto.Exception;

public class QuantityLimitException extends  RuntimeException{
    public QuantityLimitException() {
        super("Quantidade inválida, adicione uma  quantidade maior que 0");
    }
}
