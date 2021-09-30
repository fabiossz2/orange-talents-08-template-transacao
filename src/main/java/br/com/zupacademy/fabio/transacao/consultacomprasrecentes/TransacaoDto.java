package br.com.zupacademy.fabio.transacao.consultacomprasrecentes;

import br.com.zupacademy.fabio.transacao.transacoescartao.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoDto {
    private final BigDecimal valor;
    private final LocalDateTime efetivadaEm;
    private final String estabelecimento;
    private final String endereco;
    private final String cidade;

    public TransacaoDto(Transacao transacao) {
        this.valor = transacao.getValor();
        this.efetivadaEm = transacao.getEfetivadaEm();
        this.estabelecimento = transacao.getEstabelecimento().getNome();
        this.endereco = transacao.getEstabelecimento().getEndereco();
        this.cidade = transacao.getEstabelecimento().getCidade();
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCidade() {
        return cidade;
    }
}
