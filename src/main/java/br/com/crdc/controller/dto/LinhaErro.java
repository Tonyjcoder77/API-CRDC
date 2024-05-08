package br.com.crdc.controller.dto;

import java.util.List;

public class LinhaErro {

	private List<LinhaDto> lines;

	public LinhaErro(List<LinhaDto> lines) {

		this.lines = lines;
	}

	public List<LinhaDto> getLines() {

		return lines;
	}
}
