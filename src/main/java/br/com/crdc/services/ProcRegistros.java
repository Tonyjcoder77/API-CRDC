package br.com.crdc.services;

import br.com.crdc.modelo.CreditInfo;

public class ProcRegistros {

    public CreditInfo processar(String linha, ProcessaReg processaReg){

        return processaReg.trataReg(linha);
    }
}
