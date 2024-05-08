package br.com.crdc.modelo;

import javax.persistence.*;

@Entity
public class Transacao extends CreditInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private Double valor;
    private Integer contaOrigem;
    private Integer contaDestino;
    @ManyToOne
    private Empresa empresa;


    public Long getId() {
        return id;
    }
    public String getTipo() {
        return tipo;
    }
    public Double getValor() {
        return valor;
    }
    public Integer getContaOrigem() {
        return contaOrigem;
    }
    public Integer getContaDestino() {
        return contaDestino;
    }

    public Empresa getEmpresa() {
        return empresa;
    }


    public void setId(Long id) {
        this.id = id;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public void setContaOrigem(Integer contaOrigem) {
        this.contaOrigem = contaOrigem;
    }
    public void setContaDestino(Integer contaDestino) {
        this.contaDestino = contaDestino;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Transacao other = (Transacao) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
