package br.com.app.bastoscorreios.adapters.inbound.controllers;

import br.com.app.bastoscorreios.adapters.inbound.models.AddressModelResponse;
import br.com.app.bastoscorreios.adapters.inbound.validations.AddressValidator;
import br.com.app.bastoscorreios.application.domains.AddressDomain;
import br.com.app.bastoscorreios.application.ports.inbound.AddressServicePort;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Classe de controller para receber as requisições para obter os dados
 * relacionados a endereço em diversos clients.
 *
 * @author Caio Henrique Bastos
 */
@AllArgsConstructor
@RestController
@RequestMapping("/bts-correios/v1/addresses")
public class AddressController {

    AddressServicePort addressServicePort;
    ModelMapper modelMapper;

    @GetMapping("/{zipCode}")
    public ResponseEntity<AddressModelResponse> getAddressByZipcodeRestTemplate(@PathVariable String zipCode,
                                                                                @RequestParam String type) {

        AddressValidator.validate(type);
        AddressDomain addressDomain = addressServicePort.getAdressByZipCodeRestTemplate(zipCode, type);
        AddressModelResponse addressModelResponse = modelMapper.map(addressDomain, AddressModelResponse.class);

        return ResponseEntity.ok(addressModelResponse);
    }
}
