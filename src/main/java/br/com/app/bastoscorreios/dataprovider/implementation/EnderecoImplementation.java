package br.com.app.bastoscorreios.dataprovider.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.app.bastoscorreios.dataprovider.entity.response.EnderecoEntityResponse;
import br.com.app.bastoscorreios.dataprovider.mapper.EnderecoMapperEntityToDomain;
import br.com.app.bastoscorreios.usecase.domain.response.EnderecoDomainResponse;
import br.com.app.bastoscorreios.usecase.gateway.EnderecoGateway;

@Component
public class EnderecoImplementation implements EnderecoGateway {

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public EnderecoDomainResponse getEnderecoComCep(String cep) {
		
		String url = montaUrlCorreio(cep);
		
		ResponseEntity<EnderecoEntityResponse> enderecoEntityResponse =
				this.restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<EnderecoEntityResponse>() {
				});
		
		return EnderecoMapperEntityToDomain.converter(enderecoEntityResponse.getBody());
	}

	private String montaUrlCorreio(String cep) {
		
		String url = new StringBuilder()
				.append("https://viacep.com.br/ws/")
				.append(cep)
				.append("/json").toString();
		
		return url;
	}	
}
