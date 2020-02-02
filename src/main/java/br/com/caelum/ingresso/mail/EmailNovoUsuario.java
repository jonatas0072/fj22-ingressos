package br.com.caelum.ingresso.mail;

import br.com.caelum.ingresso.model.Token;

public class EmailNovoUsuario implements Email {

    private final Token token;

    public EmailNovoUsuario(Token token) {
        this.token = token;
    }

    @Override
    public String getTo() {
        return token.getEmail();
    }

    @Override
    public String getBody() {
        StringBuilder body = new StringBuilder("<html>");
        body.append("<body>");
        body.append("<h2>Seja Bem Vindo<h2>");
        body.append(String.format("Acesso o <a href=%s>link</a> para criar seu login no sistema de ingressos.", makeURL() ));
        body.append("</body>");
        body.append("</html>");
        
        return body.toString();
    }

    private Object makeURL() {
        return String.format("http://localhost:8080/usuario/validade?uuid=%s", token.getUuid());
    }

    @Override
    public String getSuject() {
        return "Cadastro Sistema de Ingressos" ;
    }

}
