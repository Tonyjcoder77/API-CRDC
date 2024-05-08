package br.com.crdc.controller.dto;

import br.com.crdc.modelo.Transacao;

import java.util.List;
import java.util.stream.Collectors;

public class LinhaDto {

	private Integer linha;
	private String campo;
	private String mensagem;

	public LinhaDto(Integer linha, String campo, String mensagem) {
		this.linha = linha;
		this.campo = campo;
		this.mensagem = mensagem;
	}

	public Integer getLinha() {
		return linha;
	}

	public String getCampo() {
		return campo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setLinha(Integer linha) {
		this.linha = linha;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
