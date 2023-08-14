package com.mentoria.URNA.models.repository;

import com.mentoria.URNA.models.entities.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

}
