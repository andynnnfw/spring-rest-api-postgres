package com.api_banco.postgreSQL.exception;

public class RecursoNaoEcontradoException extends RuntimeException{
    public RecursoNaoEcontradoException(String mensagem){
        super(mensagem);
    }


}