package br.com.crdc.repository;

import br.com.crdc.modelo.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    @Query(value = "Select MAX(id) from Empresa", nativeQuery = true)
    Long findMaxValue();

}
