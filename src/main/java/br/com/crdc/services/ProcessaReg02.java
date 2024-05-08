package br.com.crdc.services;

import br.com.crdc.modelo.CreditInfo;
import br.com.crdc.modelo.Empresa;
import br.com.crdc.modelo.PreTransacao;
import br.com.crdc.modelo.Transacao;

public class ProcessaReg02 implements ProcessaReg {
    @Override
    public PreTransacao trataReg(String linha){
        PreTransacao preTransacao = new PreTransacao();
        preTransacao.setTipo(linha.substring(3,4));
        preTransacao.setValor(linha.substring(4,20).replaceAll("_",""));
        preTransacao.setContaOrigem(linha.substring(20,36).replaceAll("_",""));
        preTransacao.setContaDestino(linha.substring(36,52).replaceAll("_",""));
        return preTransacao;
    }
}
