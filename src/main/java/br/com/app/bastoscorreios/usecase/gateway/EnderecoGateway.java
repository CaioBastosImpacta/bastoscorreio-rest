package br.com.app.bastoscorreios.usecase.gateway;

import br.com.app.bastoscorreios.usecase.domain.response.EnderecoDomainResponse;

public interface EnderecoGateway {

	EnderecoDomainResponse getEnderecoComCep(String cep);
}
