package com.mentoria.URNA.exception;

import org.springframework.util.StringUtils;

public class EntityDoesNotExistException extends RuntimeException {
    public EntityDoesNotExistException(String entity) {
        super(String.format("O candidato não a %s inválido", StringUtils.capitalize(entity)));
    }
}
