package br.com.zupacademy.fabio.transacao.transacoescartao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Repository
public interface CartaoRespository extends CrudRepository<Cartao, String> {
    Optional<Cartao> findByNumero(@NotBlank String numero);
}
