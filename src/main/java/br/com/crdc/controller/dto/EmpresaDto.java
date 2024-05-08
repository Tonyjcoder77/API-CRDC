package br.com.crdc.controller.dto;

import br.com.crdc.modelo.Empresa;
import br.com.crdc.modelo.Transacao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmpresaDto {

	private Long id;
	private String razao;
	private String identificador;
	private List<Transacao> transacao = new ArrayList<>();

	public EmpresaDto(Empresa empresa) {
		this.id = empresa.getId();
		this.razao = empresa.getRazao();
		this.identificador = empresa.getIdentificador();
		this.transacao = empresa.getTransacao();
	}

	public Long getId() {
		return id;
	}

	public String getRazao() {
		return razao;
	}

	public String getIdentificador() {
		return identificador;
	}


	public static List<EmpresaDto> converter(List<Empresa> empresa) {
		return empresa.stream().map(EmpresaDto::new).collect(Collectors.toList());
	}
}
