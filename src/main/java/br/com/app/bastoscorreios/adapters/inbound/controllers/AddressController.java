package br.com.app.bastoscorreios.adapters.inbound.controllers;

import br.com.app.bastoscorreios.adapters.inbound.models.AddressModelResponse;
import br.com.app.bastoscorreios.application.domains.AddressDomain;
import br.com.app.bastoscorreios.application.ports.inbound.AddressServicePort;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/bts-correios/v1/addresses")
public class AddressController {

    AddressServicePort addressServicePort;
    ModelMapper modelMapper;

    @GetMapping("/{zipCode}/resttemplate")
    public ResponseEntity<AddressModelResponse> getAddressByZipcodeRestTemplate(@PathVariable String zipCode) {
        AddressDomain addressDomain = addressServicePort.getAdressByZipCodeRestTemplate(zipCode);
        AddressModelResponse addressModelResponse = modelMapper.map(addressDomain, AddressModelResponse.class);

        return ResponseEntity.ok(addressModelResponse);
    }
}
