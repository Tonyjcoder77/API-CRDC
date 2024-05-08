package br.com.crdc.controller.dto;

public class JsonRetErro2 {

	private String status;
	private String message;

	public JsonRetErro2(String status, String message) {
		this.status = status;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

}
