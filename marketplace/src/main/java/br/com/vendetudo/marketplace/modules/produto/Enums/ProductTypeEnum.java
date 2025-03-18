package br.com.vendetudo.marketplace.modules.produto.Enums;

public enum ProductTypeEnum {
    TECH("Tecnologia"),
    CONSUMABLE("Consumivel"),
    CLEANING("Limpeza"),
    VEHICLES("Veiculos"),
    CLOTHING("Roupa"),
    KITCHEN("Cozinha");

    String value;

    ProductTypeEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}
