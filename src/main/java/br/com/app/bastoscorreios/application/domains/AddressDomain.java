package br.com.app.bastoscorreios.application.domains;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDomain {

    private String zipCode;
    private String publicPlace;
    private String district;
    private String city;
    private String state;
    private String additionalDetails;
}
