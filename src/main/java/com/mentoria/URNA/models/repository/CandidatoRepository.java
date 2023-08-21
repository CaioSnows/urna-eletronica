package com.mentoria.URNA.models.repository;

import com.mentoria.URNA.models.entities.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

    @Query(value = "SELECT * FROM tabela_candidato c WHERE c.cargo = :cargo ORDER BY c.numero_de_votos DESC LIMIT 1", nativeQuery = true)
    Candidato findTopByCargoOrderByNumeroDeVotosDesc(@Param("cargo") String cargo);
}
