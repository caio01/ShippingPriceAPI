package com.practicaltest.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShippingPrice {

    private Zipcode cep;
    private String rua;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String frete;

    public ShippingPrice(Zipcode cep, String rua, String complemento, String bairro,
                         String cidade, String estado, String frete) {
        this.cep = cep;
        this.rua = rua;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.frete = frete;
    }

}
