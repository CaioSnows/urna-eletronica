package com.mentoria.URNA.exception;

public class PrefeitoNumberIsIncorrectException extends RuntimeException {
    public PrefeitoNumberIsIncorrectException() {
        super("Numero do prefeito inválido");
    }
}
