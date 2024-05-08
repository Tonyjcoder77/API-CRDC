package br.com.crdc.controller.form;

import br.com.crdc.modelo.Empresa;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EmpresaForm {

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

    public Empresa converter() {
        Empresa ep =  new Empresa();
        ep.setRazao(this.razao);
        ep.setIdentificador(this.identificador);
        return ep;
    }

}
