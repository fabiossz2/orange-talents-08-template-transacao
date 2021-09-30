package br.com.zupacademy.fabio.transacao.transacoescartao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @NotBlank
    @Column(nullable = false)
    private String idMensagem;

    @Positive
    private BigDecimal valor;

    @NotNull
    @Valid
    @JoinColumn(name = "estabelecimento_id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Estabelecimento estabelecimento;

    @NotNull
    @Valid
    @JoinColumn(name = "cartao_id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Cartao cartao;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime efetivadaEm;

    @Deprecated
    protected Transacao() {
    }

    public Transacao(@NotBlank String idMensagem, @Positive BigDecimal valor, @NotNull @Valid Estabelecimento estabelecimento,
                     @NotNull @Valid Cartao cartao, @NotNull LocalDateTime efetivadaEm) {
        this.idMensagem = idMensagem;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }
}
