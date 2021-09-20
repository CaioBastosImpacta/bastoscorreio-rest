package br.com.app.bastoscorreios.application.ports.outbound;

import br.com.app.bastoscorreios.application.domains.AddressDomain;

public interface AddressCorreiosApiPort {

    AddressDomain getAdressByZipCodeInCorreiosApiRestTemplate(String zipcode);
}
