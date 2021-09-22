package br.com.app.bastoscorreios.application.service.utils;

import br.com.app.bastoscorreios.application.domains.AddressDomain;
import br.com.app.bastoscorreios.application.exception.BadBusyException;
import br.com.app.bastoscorreios.application.exception.NoContentDataException;
import org.springframework.util.StringUtils;

public class AddressUtils {

    public static void validationDiferentRegexZipcode(String zipcode) {
        if (!zipcode.matches("^([0-9]{8})|[0-9]{5}-[0-9]{3}$")) {
            throw new BadBusyException("O CEP informado está com o formato incorreto.");
        }
    }

    public static void validationCorreioResponseNull(AddressDomain addressResponseByCorreio) {
        if (StringUtils.hasLength(addressResponseByCorreio.getZipCode())) {
            throw new NoContentDataException();
        }
    }
}
