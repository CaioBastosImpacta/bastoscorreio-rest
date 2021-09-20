package br.com.app.bastoscorreios.adapters.inbound.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressModelResponse {

    private String zipCode;
    private String publicPlace;
    private String number;
    private String district;
    private String city;
    private String state;
    private String additionalDetails;
}
