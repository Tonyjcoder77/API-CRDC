package br.com.crdc.controller.form;

import br.com.crdc.modelo.Empresa;
import br.com.crdc.repository.EmpresaRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizacaoEmpresaForm {
    @NotNull @NotEmpty
    private String razao;
    @NotNull @NotEmpty
    private String identificador;

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Empresa atualizar(Long id, EmpresaRepository empresaRepository) {
        Empresa en =  empresaRepository.getOne(id);
        en.setRazao(this.razao);
        en.setIdentificador(this.identificador);
        return en;
    }

}
