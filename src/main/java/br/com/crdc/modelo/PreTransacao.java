package br.com.crdc.modelo;

import br.com.crdc.controller.dto.TransacaoDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class PreTransacao extends CreditInfo {

    private String tipo;
    private String valor;
    private String contaOrigem;
    private String contaDestino;

    public String getTipo() {
        return tipo;
    }
    public String getValor() {
        return valor;
    }
    public String getContaOrigem() {
        return contaOrigem;
    }
    public String getContaDestino() {
        return contaDestino;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
    public void setContaOrigem(String contaOrigem) {
        this.contaOrigem = contaOrigem;
    }
    public void setContaDestino(String contaDestino) {
        this.contaDestino = contaDestino;
    }

    public static List<Transacao> converter(List<PreTransacao> preTransacoes) {
        List<Transacao> trs = new ArrayList<>();
        for(PreTransacao ptrs: preTransacoes) {
            Transacao tr = new Transacao();
            tr.setTipo(ptrs.getTipo());
            tr.setValor(Double.valueOf(ptrs.getValor()));
            tr.setContaOrigem(Integer.valueOf(ptrs.getContaOrigem()));
            tr.setContaDestino(Integer.valueOf(ptrs.getContaDestino()));
            trs.add(tr);
        }
        return trs;
    }


//    public static List<TransacaoDto> converter(List<Transacao> transacoes) {
//        return transacoes.stream().map(TransacaoDto::new).collect(Collectors.toList());
//    }

}
