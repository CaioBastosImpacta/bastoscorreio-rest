package br.com.app.bastoscorreios.entrypoint.mapper;

import br.com.app.bastoscorreios.entrypoint.model.response.EnderecoModelResponse;
import br.com.app.bastoscorreios.usecase.domain.response.EnderecoDomainResponse;

public class EnderecoMapperDomainToModelResponse {

	public static EnderecoModelResponse converter(EnderecoDomainResponse enderecoDomainResponse) {
		
		EnderecoModelResponse enderecoModelResponse = new EnderecoModelResponse();
		enderecoModelResponse.setCep(enderecoDomainResponse.getCep());
		enderecoModelResponse.setLogradouro(enderecoDomainResponse.getLogradouro());
		enderecoModelResponse.setComplemento(enderecoDomainResponse.getComplemento());
		enderecoModelResponse.setBairro(enderecoDomainResponse.getBairro());
		enderecoModelResponse.setLocalidade(enderecoDomainResponse.getLocalidade());
		enderecoModelResponse.setUf(enderecoDomainResponse.getUf());
		enderecoModelResponse.setIbge(enderecoDomainResponse.getIbge());
		enderecoModelResponse.setGia(enderecoDomainResponse.getGia());
		enderecoModelResponse.setDdd(enderecoDomainResponse.getDdd());
		enderecoModelResponse.setSiafi(enderecoDomainResponse.getSiafi());
		
		return enderecoModelResponse;
	}	
}
