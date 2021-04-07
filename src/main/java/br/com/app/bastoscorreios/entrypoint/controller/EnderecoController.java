package br.com.app.bastoscorreios.entrypoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.bastoscorreios.entrypoint.mapper.EnderecoMapperDomainToModelResponse;
import br.com.app.bastoscorreios.entrypoint.model.response.EnderecoModelResponse;
import br.com.app.bastoscorreios.entrypoint.validation.EnderecoValidation;
import br.com.app.bastoscorreios.usecase.domain.response.EnderecoDomainResponse;
import br.com.app.bastoscorreios.usecase.service.EnderecoService;

@RestController
@RequestMapping(value = "/bastoscorreio/v1")
public class EnderecoController {
	
	@Autowired
	EnderecoService enderecoService;
	
	@GetMapping("/cep/{cep}")
	public ResponseEntity<EnderecoModelResponse> getEnderecoComCep(@PathVariable String cep) {
		
		EnderecoValidation.validate(cep);
		EnderecoDomainResponse enderecoDomainResponse = enderecoService.getEnderecoComCep(cep);
		
		EnderecoModelResponse enderecoModelResponse = EnderecoMapperDomainToModelResponse.converter(enderecoDomainResponse);		
		
		return ResponseEntity.ok(enderecoModelResponse);
	}

}
