package br.com.zupacademy.fabio.transacao.transacoescartao;

public class CartaoForm {
    private String id;
    private String email;

    public Cartao toModel() {
        return new Cartao(id, email);
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
