package br.com.crdc.repository;

import br.com.crdc.modelo.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    @Query(value = "Select MAX(id) from Transacao", nativeQuery = true)
    Long findMaxValue();

}

