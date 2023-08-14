package com.mentoria.URNA.models.repository;

import com.mentoria.URNA.models.entities.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Long> {

}
