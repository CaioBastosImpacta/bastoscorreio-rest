package br.com.app.bastoscorreios.application.domains;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe de modelo de dominio da aplicação. É a classe com os dados mais interno na aplicação.
 */
@Getter
@Setter
public class AddressDomain {

    private String zipCode;
    private String publicPlace;
    private String district;
    private String city;
    private String state;
    private String ddd;
}
