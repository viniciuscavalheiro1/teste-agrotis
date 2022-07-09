package br.com.agrotis.testeagrotis.repository;

import br.com.agrotis.testeagrotis.model.Laboratorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratorioRepository extends JpaRepository<Laboratorio, Long> {

}
