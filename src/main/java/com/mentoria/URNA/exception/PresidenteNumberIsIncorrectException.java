package com.mentoria.URNA.exception;

public class PresidenteNumberIsIncorrectException extends RuntimeException{
    public PresidenteNumberIsIncorrectException() {
        super("Numero do presidente inválido");
    }
}
