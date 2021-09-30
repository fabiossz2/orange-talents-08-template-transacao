package br.com.zupacademy.fabio.transacao.transacoescartao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class ListenerDeTransacao {

    private final Logger logger = LoggerFactory.getLogger(ListenerDeTransacao.class);

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private CartaoRespository cartaoRespository;

    @KafkaListener(topics = "${spring.kafka.topic.transacoes}")
    @Transactional
    public void consume(TransacaoForm transacaoForm) {
        try {
            Transacao transacao = transacaoForm.toModel(cartaoRespository);
            transacaoRepository.save(transacao);
            logger.info(String.format("Leitura Transação - idMensagem: %s  idTransacao: %s valor: %.2f realiza com sucesso.",
                    transacaoForm.getId(), transacao.getId(), transacaoForm.getValor()));
        } catch (Exception ex) {
            logger.error(String.format("Erro ao realizar a leitura das transações - Mensagem do Erro: %s - Classe do Erro: %s",
                    ex.getMessage(), ex.getClass()));
        }
    }
}
