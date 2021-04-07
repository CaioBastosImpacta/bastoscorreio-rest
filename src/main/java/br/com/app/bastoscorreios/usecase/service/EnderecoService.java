package br.com.app.bastoscorreios.usecase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.bastoscorreios.usecase.domain.response.EnderecoDomainResponse;
import br.com.app.bastoscorreios.usecase.gateway.EnderecoGateway;

@Service
public class EnderecoService {

	@Autowired
	EnderecoGateway enderecoGateway;

	public EnderecoDomainResponse getEnderecoComCep(String cep) {
		return enderecoGateway.getEnderecoComCep(cep);
	}
}
