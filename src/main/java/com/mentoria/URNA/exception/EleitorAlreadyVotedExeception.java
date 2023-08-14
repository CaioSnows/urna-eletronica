package com.mentoria.URNA.exception;

public class EleitorAlreadyVotedExeception extends RuntimeException{
    public EleitorAlreadyVotedExeception(){
        super("Eleitor já votou");
    }
}
