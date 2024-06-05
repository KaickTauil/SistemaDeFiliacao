package br.com.fetese.projetofetese.excecoes;

import java.io.IOException;

public class SaveException extends IOException {

    public SaveException(String msg){
        super(msg);
    }
}
