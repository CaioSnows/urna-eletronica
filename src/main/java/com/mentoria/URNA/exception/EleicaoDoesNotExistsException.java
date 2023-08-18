package com.mentoria.URNA.exception;

public class EleicaoDoesNotExistsException extends RuntimeException {

    public EleicaoDoesNotExistsException(){
        super("Eleição não existe");
    }
}
