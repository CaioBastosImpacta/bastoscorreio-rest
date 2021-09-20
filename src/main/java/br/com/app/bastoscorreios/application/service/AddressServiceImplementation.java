package br.com.app.bastoscorreios.application.service;

import br.com.app.bastoscorreios.application.domains.AddressDomain;
import br.com.app.bastoscorreios.application.ports.inbound.AddressServicePort;
import br.com.app.bastoscorreios.application.ports.outbound.AddressCorreiosApiPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AddressServiceImplementation implements AddressServicePort {

    AddressCorreiosApiPort addressCorreiosApiPort;

    @Override
    public AddressDomain getAdressByZipCodeRestTemplate(String zipcode) {
        return addressCorreiosApiPort.getAdressByZipCodeInCorreiosApiRestTemplate(zipcode);
    }
}
