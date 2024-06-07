package br.com.fetese.projetofetese.excecoes;

import org.aspectj.bridge.IMessage;

public class ResourceNotFoudException extends RuntimeException{

    public ResourceNotFoudException(String msg){
        super(msg);
    }
}
