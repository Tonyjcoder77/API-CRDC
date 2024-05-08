package br.com.crdc.services;

import br.com.crdc.modelo.CreditInfo;
import br.com.crdc.modelo.Empresa;

public class ProcessaReg01 implements ProcessaReg {
    @Override
    public Empresa trataReg(String linha){
        Empresa empresa = new Empresa();
        empresa.setRazao(linha.substring(3,33).replaceAll("_",""));
        empresa.setIdentificador(linha.substring(33,47).replaceAll("_",""));
        return empresa;
    }
}
