package br.com.agrotis.testeagrotis.repository;

import br.com.agrotis.testeagrotis.model.Fazenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FazendaRepository extends JpaRepository<Fazenda, Long> {

}
