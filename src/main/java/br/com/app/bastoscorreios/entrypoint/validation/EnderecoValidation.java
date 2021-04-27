package br.com.app.bastoscorreios.entrypoint.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.app.bastoscorreios.entrypoint.exception.RequisicaoInvalidaException;

public class EnderecoValidation {

	public static void validate(String cep) {
		
		validaCepTamanho(cep);
	}
	
	private static void validaCepTamanho(String cep) {
		
		Boolean resultado = true;
		
		Pattern patternCep = Pattern.compile("^(([0-9]{2}\\.[0-9]{3}-[0-9]{3})|([0-9]{2}[0-9]{3})-[0-9]{3})|([0-9]){8}))$");
		Matcher matcherCep = patternCep.matcher(cep);
		resultado = matcherCep.find();
		
		if(!resultado) {
			throw new RequisicaoInvalidaException("O Cep deve conter tamanho 8");
		}
		
	}
	
}
