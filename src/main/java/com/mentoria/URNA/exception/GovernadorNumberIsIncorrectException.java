package com.mentoria.URNA.exception;

public class GovernadorNumberIsIncorrectException extends RuntimeException{
    public GovernadorNumberIsIncorrectException() {
        super("Numero do governador inválido");
    }
}
