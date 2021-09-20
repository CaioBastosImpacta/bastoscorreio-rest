package br.com.app.bastoscorreios.adapters.inbound.models;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe de modelo de resposta da aplicação para exibir os dados.
 *
 * @author Caio Henrique Bastos
 */
@Getter
@Setter
public class AddressModelResponse {

    private String zipCode;
    private String publicPlace;
    private String district;
    private String city;
    private String state;
    private String ddd;
}
