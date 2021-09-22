package br.com.app.bastoscorreios.adapters.inbound.validations;

import br.com.app.bastoscorreios.adapters.exception.BadRequestException;

import java.util.Optional;

/**
 * Classe responsável por realizar as validações do tipo da busca do endereço.
 *
 * @author Caio Henrique Bastos
 */
public class AddressValidator {

    public static void validate(String type) {
        Optional<String> responseTypeClient = AddressTypeEnum.verifyTypeValid(type);

        if (responseTypeClient.isEmpty()) {
            throw new BadRequestException("O tipo da requisição está inválida, é necessário corrigir.");
        }
    }
}
