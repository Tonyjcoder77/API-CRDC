package br.com.crdc.modelo;

import javax.persistence.*;
import java.util.List;


public class FileData {

    private Empresa empresa;
    private List<PreTransacao> preTransacoes;

    public FileData(Empresa empresa, List<PreTransacao> preTransacoes) {
        this.empresa = empresa;
        this.preTransacoes = preTransacoes;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<PreTransacao> getPreTransacoes() {
        return preTransacoes;
    }

    public void setPreTransacoes(List<PreTransacao> preTransacoes) {
        this.preTransacoes = preTransacoes;
    }
}
