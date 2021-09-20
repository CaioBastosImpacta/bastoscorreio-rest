package br.com.app.bastoscorreios.application.ports.inbound;

import br.com.app.bastoscorreios.application.domains.AddressDomain;

/**
 * Interface responsável por ser o contrato da porta de entrada da camada de 'inbound'
 * com a camada de serviço onde estão as regras de negócio.
 *
 * @author Caio Henrique Bastos
 */
public interface AddressServicePort {

    /**
     * Método responsável por buscar os dados de endereço de acordo com o CEP
     * informado e o client é o RestTemplate.
     *
     * @param zipcode {@code String}
     *      - cep a receber no parametro de entrada.
     * @param type {@code String}
     *      - tipo da chamada para saber qual client irá chamar
     * @return {@code AddressDomain}
     *      - Retorna os dados de endereço da busca.
     */
    AddressDomain getAdressByZipCodeRestTemplate(String zipcode, String type);
}
