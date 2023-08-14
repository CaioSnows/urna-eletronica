package com.mentoria.URNA.models.repository;

import com.mentoria.URNA.models.entities.Eleitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EleitorRepository extends JpaRepository<Eleitor, Long> {

    public boolean findByCpf(String cpf);

}
