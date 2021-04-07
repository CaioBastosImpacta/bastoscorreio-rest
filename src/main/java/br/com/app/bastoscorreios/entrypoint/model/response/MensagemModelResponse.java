package br.com.app.bastoscorreios.entrypoint.model.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(SnakeCaseStrategy.class)
public class MensagemModelResponse {

	private String codigoStatus;
	private String mensagem;
	
	public String getCodigoStatus() {
		return this.codigoStatus;
	}
	
	public void setCodigoStatus(String codigoStatus) {
		this.codigoStatus = codigoStatus;
	}

	public String getMnesagem() {
		return this.mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
