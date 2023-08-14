package com.mentoria.URNA.exception;

public class CandidatoAlreadyRegisterException extends RuntimeException{
    public CandidatoAlreadyRegisterException() {
        super("Candidato já cadastrado");
    }
}
