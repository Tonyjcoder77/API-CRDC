package br.com.crdc.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Empresa extends CreditInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String razao;
    private String identificador;
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transacao> transacoes = new ArrayList<>();


    public Long getId() {
        return id;
    }
    public String getRazao() {
        return razao;
    }
    public String getIdentificador() {
        return identificador;
    }

    public List<Transacao> getTransacao() {
        return transacoes;
    }



    public void setId(Long id) {this.id = id;}
    public void setRazao(String razao) {this.razao = razao;}
    public void setIdentificador(String identificador) {this.identificador = identificador;}
    public void setTransacoes(List<Transacao> transacoes) {this.transacoes = transacoes;}

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
        Empresa other = (Empresa) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
