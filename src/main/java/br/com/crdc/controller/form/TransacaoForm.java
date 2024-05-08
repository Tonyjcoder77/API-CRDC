package br.com.crdc.controller.form;

import br.com.crdc.modelo.Empresa;
import br.com.crdc.modelo.Transacao;
import br.com.crdc.repository.EmpresaRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TransacaoForm {
    @NotNull @NotEmpty
    private String tipo;
    @NotNull
    private Double valor;
    @NotNull
    private Integer contaOrigem;
    @NotNull
    private Integer contaDestino;

    //@NotNull @NotEmpty
    //private Empresa empresa;

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setValor(Double valor) {this.valor = valor; }
    public void setContaOrigem(Integer contaOrigem) {this.contaOrigem = contaOrigem; }
    public void setContaDestino(Integer contaDestino) {this.contaDestino = contaDestino; }

    //public void setEmpresa(Empresa empresa) {
    //    this.empresa = empresa;
    //}

    public Transacao converter(Long id, EmpresaRepository empresaRepository) {
        Empresa ep =  empresaRepository.getOne(id);
        Transacao tr =  new Transacao();
        tr.setTipo(this.tipo);
        tr.setValor(this.valor);
        tr.setContaOrigem(this.contaOrigem);
        tr.setContaDestino(this.contaDestino);
        tr.setEmpresa(ep);
        return tr;
    }

}
