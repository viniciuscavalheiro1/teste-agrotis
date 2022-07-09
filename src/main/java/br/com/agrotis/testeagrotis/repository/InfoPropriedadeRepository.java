package br.com.agrotis.testeagrotis.repository;

import br.com.agrotis.testeagrotis.model.InfoPropriedade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoPropriedadeRepository extends JpaRepository<InfoPropriedade, Long> {

}
