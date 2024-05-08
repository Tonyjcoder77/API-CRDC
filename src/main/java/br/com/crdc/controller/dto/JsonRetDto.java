package br.com.crdc.controller.dto;

import br.com.crdc.modelo.Transacao;

import java.util.List;
import java.util.stream.Collectors;

public class JsonRetDto {

	private String status;
	private String message;
	private JsonRetTrn data;

	public JsonRetDto(String status, String message, JsonRetTrn data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public JsonRetTrn getData() {
		return data;
	}
}
