package com.mentoria.URNA.exception;

public class EleitorAlreadyRegisterException extends RuntimeException{

    public EleitorAlreadyRegisterException() {
        super("Eleitor já cadastrado");
    }
}
