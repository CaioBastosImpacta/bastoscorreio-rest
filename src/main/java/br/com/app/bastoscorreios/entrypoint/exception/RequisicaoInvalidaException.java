package br.com.app.bastoscorreios.entrypoint.exception;

public class RequisicaoInvalidaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public RequisicaoInvalidaException(String message) {
		super(message);
	}
}
