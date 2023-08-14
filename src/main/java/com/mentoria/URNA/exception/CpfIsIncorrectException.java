package com.mentoria.URNA.exception;

public class CpfIsIncorrectException extends RuntimeException{

    public CpfIsIncorrectException() {
        super("Cpf inválido");
    }
}
