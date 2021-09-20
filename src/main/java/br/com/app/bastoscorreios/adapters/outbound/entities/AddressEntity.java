package br.com.app.bastoscorreios.adapters.outbound.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class AddressEntity {

    @JsonProperty("cep")
    private String zipCode;

    @JsonProperty("logradouro")
    private String publicPlace;

    @JsonProperty("complemento")
    private String additionalDetails;

    @JsonProperty("bairro")
    private String district;

    @JsonProperty("localidade")
    private String city;

    @JsonProperty("uf")
    private String state;

    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
}
