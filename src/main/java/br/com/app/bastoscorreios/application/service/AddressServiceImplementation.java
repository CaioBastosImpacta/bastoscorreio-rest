package br.com.app.bastoscorreios.application.service;

import br.com.app.bastoscorreios.application.domains.AddressDomain;
import br.com.app.bastoscorreios.application.ports.inbound.AddressServicePort;
import br.com.app.bastoscorreios.application.ports.outbound.AddressCorreiosApiPort;
import br.com.app.bastoscorreios.application.service.utils.AddressUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Classe de serviço que contêm as regras de negócio da aplicação. É a camada
 * mais interna e ela implementa o contrato da porta de entrada do 'inbound' e é
 * responsável por se comunicar com os dados através do contrato da porta do 'outbound'.
 *
 * @author Caio Henrique Bastos
 */
@AllArgsConstructor
@Service
public class AddressServiceImplementation extends AddressServiceTemplateMethod implements AddressServicePort {

    AddressCorreiosApiPort addressCorreiosApiPort;

    @Override
    public AddressDomain getAdressByZipCodeRestTemplate(String zipcode, String type) {

        validateFormatZipcode(zipcode);

        AddressDomain addressResponseByCorreio =
                addressCorreiosApiPort.getAdressByZipCodeInCorreiosApiRestTemplate(zipcode);

        AddressUtils.validationCorreioResponseNull(addressResponseByCorreio);

        return addressResponseByCorreio;
    }

    @Override
    void validateFormatZipcode(String zipcode) {
        AddressUtils.validationDiferentRegexZipcode(zipcode);
    }
}
