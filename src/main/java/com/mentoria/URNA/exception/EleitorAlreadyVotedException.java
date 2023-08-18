package com.mentoria.URNA.exception;

public class EleitorAlreadyVotedException extends RuntimeException{
    public EleitorAlreadyVotedException(){
        super("Eleitor já votou");
    }
}
