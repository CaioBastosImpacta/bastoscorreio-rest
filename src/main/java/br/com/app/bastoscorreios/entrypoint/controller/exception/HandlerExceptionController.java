package br.com.app.bastoscorreios.entrypoint.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.app.bastoscorreios.entrypoint.exception.RequisicaoInvalidaException;
import br.com.app.bastoscorreios.entrypoint.model.response.MensagemModelResponse;

@ControllerAdvice
public class HandlerExceptionController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MensagemModelResponse> handleAllExceptions(Exception exception) {
		
		var mensagemModelResponse = new MensagemModelResponse();
		mensagemModelResponse.setCodigoStatus(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
		mensagemModelResponse.setMensagem("Erro interno na aplicação");
		
		return new ResponseEntity<MensagemModelResponse>(mensagemModelResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(RequisicaoInvalidaException.class)
	public ResponseEntity<MensagemModelResponse> handleInvalidRequest(Exception exception) {
		
		var mensagemModelResponse = new MensagemModelResponse();
		mensagemModelResponse.setCodigoStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
		mensagemModelResponse.setMensagem(exception.getMessage());
		
		return new ResponseEntity<MensagemModelResponse>(mensagemModelResponse, HttpStatus.BAD_REQUEST);
	}
}
