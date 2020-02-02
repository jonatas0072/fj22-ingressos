package br.com.caelum.ingresso.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Permissao implements GrantedAuthority {

    public static final Permissao COMPRADOR = new Permissao("COMPRADOR");
    public static final Permissao ADMIN = new Permissao("ADMIN");

    private static final long serialVersionUID = -2107346964953180644L;

    @Id
    private String nome;

    public Permissao(String nome) {
        this.nome = nome;
    }

    public Permissao() {

    }

    @Override
    public String getAuthority() {
        return nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
