package br.com.app.bastoscorreios.application.service;

import br.com.app.bastoscorreios.application.domains.AddressDomain;
import br.com.app.bastoscorreios.application.exception.BadBusyException;
import br.com.app.bastoscorreios.application.exception.NoContentDataException;
import br.com.app.bastoscorreios.application.ports.inbound.AddressServicePort;
import br.com.app.bastoscorreios.application.ports.outbound.AddressCorreiosApiPort;
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
public class AddressServiceImplementation implements AddressServicePort {

    AddressCorreiosApiPort addressCorreiosApiPort;

    @Override
    public AddressDomain getAdressByZipCodeRestTemplate(String zipcode, String type) {

        if (!zipcode.matches("^([0-9]{8})|[0-9]{5}-[0-9]{3}$")) {
            throw new BadBusyException("O CEP informado está com o formato incorreto.");
        }

        AddressDomain addressResponseByCorreio =
                addressCorreiosApiPort.getAdressByZipCodeInCorreiosApiRestTemplate(zipcode);

        if (addressResponseByCorreio.getZipCode() == null) {
            throw new NoContentDataException();
        }

        return addressResponseByCorreio;
    }
}
