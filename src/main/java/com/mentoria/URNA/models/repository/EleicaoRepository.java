package com.mentoria.URNA.models.repository;

import com.mentoria.URNA.models.entities.Eleicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EleicaoRepository extends JpaRepository<Eleicao, Long> {
    @Query(value = "SELECT * FROM tabela_eleicao e WHERE e.ano = :ano", nativeQuery = true)
    Eleicao findByAno(@Param("ano") String ano);
}
