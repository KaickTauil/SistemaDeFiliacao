package br.com.fetese.projetofetese.entidades;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
public abstract class  Usuario implements Serializable {

    private static final long serialVersionUID = 1L;



    private String email;
    private String senha;


    public Usuario(){}


    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;

    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
