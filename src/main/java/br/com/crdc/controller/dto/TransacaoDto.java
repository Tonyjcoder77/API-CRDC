package br.com.crdc.controller.dto;

import br.com.crdc.modelo.Empresa;
import br.com.crdc.modelo.Transacao;

import java.util.List;
import java.util.stream.Collectors;

public class TransacaoDto {

	private String tipo;
	private Double valor;
	private Integer contaOrigem;
	private Integer contaDestino;

	public TransacaoDto(Transacao transacao) {
		this.tipo = transacao.getTipo();
		this.valor = transacao.getValor();
		this.contaOrigem = transacao.getContaOrigem();
		this.contaDestino = transacao.getContaDestino();
	}

	public String getTipo() {
		return tipo;
	}
	public Double getValor() {
		return valor;
	}
	public Integer getContaOrigem() {
		return contaOrigem;
	}
	public Integer getContaDestino() { return contaDestino;}

	public static List<TransacaoDto> converter(List<Transacao> transacoes) {
		return transacoes.stream().map(TransacaoDto::new).collect(Collectors.toList());
	}
}
