package br.com.crdc.controller.dto;

public class JsonRetErro1 {

	private String status;
	private String message;
	private LinhaErro linhaErro;
	public JsonRetErro1(String status, String message, LinhaErro linhaErro) {
		this.status = status;
		this.message = message;
		this.linhaErro = linhaErro;
	}

	public String getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public LinhaErro getLinhaErro() {return linhaErro;}

}
