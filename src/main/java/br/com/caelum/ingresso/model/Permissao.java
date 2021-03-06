package br.com.caelum.ingresso.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Permissao implements GrantedAuthority {

    public static final Permissao COMPRADOR = new Permissao("COMPRADOR");
    public static final Permissao ADMIN = new Permissao("ADMIN");

    @Id
    private String nome;

    private Permissao(String nome) {
        this.nome = nome;
    }

    /**
     * @deprecated hibernate only
     */
    public Permissao() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getAuthority() {
        return nome;
    }
}