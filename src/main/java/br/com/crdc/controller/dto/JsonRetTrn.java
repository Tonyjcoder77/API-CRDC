package br.com.crdc.controller.dto;

import java.util.List;

public class JsonRetTrn {

	private List<TransacaoDto> transactions;

	public JsonRetTrn(List<TransacaoDto> transactions) {
		this.transactions = transactions;
	}

	public List<TransacaoDto> getTransactions() {
		return transactions;
	}
}
