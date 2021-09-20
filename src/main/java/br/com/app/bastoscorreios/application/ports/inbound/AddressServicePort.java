package br.com.app.bastoscorreios.application.ports.inbound;

import br.com.app.bastoscorreios.application.domains.AddressDomain;

public interface AddressServicePort {

    AddressDomain getAdressByZipCodeRestTemplate(String zipcode);
}
