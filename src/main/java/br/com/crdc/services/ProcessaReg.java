package br.com.crdc.services;

import br.com.crdc.modelo.CreditInfo;

public interface ProcessaReg {

    public abstract CreditInfo trataReg(String linha);

}
