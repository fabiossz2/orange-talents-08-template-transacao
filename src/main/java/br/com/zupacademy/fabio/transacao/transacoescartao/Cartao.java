package br.com.zupacademy.fabio.transacao.transacoescartao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Cartao {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @NotBlank
    @Column(nullable = false)
    private String numero;

    @Email
    @Column(nullable = false)
    private String email;

    @Deprecated
    protected Cartao() {
    }

    public Cartao(@NotBlank String numero, @Email String email) {
        this.numero = numero;
        this.email = email;
    }
}
