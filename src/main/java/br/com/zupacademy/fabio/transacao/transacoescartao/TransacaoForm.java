package br.com.zupacademy.fabio.transacao.transacoescartao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoForm {
    private String id;
    private BigDecimal valor;
    private EstabelecimentoForm estabelecimento;
    private CartaoForm cartao;
    private LocalDateTime efetivadaEm;

    public Transacao toModel(CartaoRespository cartaoRespository) {
        final Estabelecimento estabelecimento = this.estabelecimento.toModel();
        final Cartao cartao = cartaoRespository.findByNumero(this.cartao.getId()).orElse(this.cartao.toModel());
        return new Transacao(id, valor, estabelecimento, cartao, efetivadaEm);
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoForm getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoForm getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

}
