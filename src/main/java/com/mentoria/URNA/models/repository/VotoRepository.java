package com.mentoria.URNA.models.repository;

import com.mentoria.URNA.models.entities.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VotoRepository extends JpaRepository<Voto, Long> {

}
