package br.com.app.bastoscorreios.dataprovider.mapper;

import br.com.app.bastoscorreios.dataprovider.entity.response.EnderecoEntityResponse;
import br.com.app.bastoscorreios.usecase.domain.response.EnderecoDomainResponse;

public class EnderecoMapperEntityToDomain {

	public static EnderecoDomainResponse converter(EnderecoEntityResponse enderecoEntityResponse) {
		
		EnderecoDomainResponse enderecoDomainResponse = new EnderecoDomainResponse();
		enderecoDomainResponse.setCep(enderecoEntityResponse.getCep());
		enderecoDomainResponse.setLogradouro(enderecoEntityResponse.getLogradouro());
		enderecoDomainResponse.setComplemento(enderecoEntityResponse.getComplemento());
		enderecoDomainResponse.setBairro(enderecoEntityResponse.getBairro());
		enderecoDomainResponse.setLocalidade(enderecoEntityResponse.getLocalidade());
		enderecoDomainResponse.setUf(enderecoEntityResponse.getUf());
		enderecoDomainResponse.setIbge(enderecoEntityResponse.getIbge());
		enderecoDomainResponse.setGia(enderecoEntityResponse.getGia());
		enderecoDomainResponse.setDdd(enderecoEntityResponse.getDdd());
		enderecoDomainResponse.setSiafi(enderecoEntityResponse.getSiafi());
		
		return enderecoDomainResponse;
	}

}
