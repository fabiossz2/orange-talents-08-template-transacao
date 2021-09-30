package br.com.zupacademy.fabio.transacao.transacoescartao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Repository
public interface TransacaoRepository extends CrudRepository<Transacao, String> {

    @Query(value = "SELECT * FROM transacao t " +
            "INNER JOIN cartao c " +
            "ON t.cartao_id = c.id " +
            "ORDER BY t.efetivada_em DESC " +
            "LIMIT 10", nativeQuery = true)
    List<Transacao> findLastThenTransactions(@NotBlank @Param("id") String idDoCartao);
}
