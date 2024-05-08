package br.com.crdc.controller.form;

import br.com.crdc.modelo.Empresa;
import br.com.crdc.modelo.Transacao;
import br.com.crdc.repository.TransacaoRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizacaoTransacaoForm {

    @NotNull @NotEmpty
    private String tipo;
    @NotNull @NotEmpty
    private Double valor;
    @NotNull @NotEmpty
    private Integer contaOrigem;
    @NotNull @NotEmpty
    private Integer contaDestino;
    @NotNull @NotEmpty
    private Empresa empresa;


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public void setContaOrigem(Integer contaOrigem) {this.contaOrigem = contaOrigem;}
    public void setContaDestino(Integer contaDestino) {this.contaDestino = contaDestino;}
    public Transacao atualizar(Long id, TransacaoRepository transacaoRepository) {
        Transacao tr =  transacaoRepository.getOne(id);
        tr.setTipo(this.tipo);
        tr.setValor(this.valor);
        tr.setContaOrigem(this.contaOrigem);
        tr.setContaDestino(this.contaDestino);
        tr.setEmpresa(this.empresa);
        return tr;
    }

}
