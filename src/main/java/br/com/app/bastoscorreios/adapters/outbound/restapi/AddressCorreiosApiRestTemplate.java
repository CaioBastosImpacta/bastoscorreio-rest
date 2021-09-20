package br.com.app.bastoscorreios.adapters.outbound.restapi;

import br.com.app.bastoscorreios.adapters.outbound.entities.AddressEntity;
import br.com.app.bastoscorreios.application.domains.AddressDomain;
import br.com.app.bastoscorreios.application.ports.outbound.AddressCorreiosApiPort;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Component
public class AddressCorreiosApiRestTemplate implements AddressCorreiosApiPort {

    private static final String URL_CEP = "https://viacep.com.br/ws/";
    private static final String FORMAT_JSON = "/json";

    RestTemplate restTemplate;
    ModelMapper modelMapper;

    @Override
    public AddressDomain getAdressByZipCodeInCorreiosApiRestTemplate(String zipcode) {
        String url = createUrlCorreio(zipcode);

        ResponseEntity<AddressEntity> addressEntity = restTemplate.getForEntity(url, AddressEntity.class);

        return modelMapper.map(addressEntity.getBody(), AddressDomain.class);
    }

    private String createUrlCorreio(String zipcode) {
        return URL_CEP + zipcode + FORMAT_JSON;
    }
}
