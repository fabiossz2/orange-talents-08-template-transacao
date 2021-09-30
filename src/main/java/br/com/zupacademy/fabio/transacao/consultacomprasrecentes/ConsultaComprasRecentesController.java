package br.com.zupacademy.fabio.transacao.consultacomprasrecentes;

import br.com.zupacademy.fabio.transacao.transacoescartao.CartaoRespository;
import br.com.zupacademy.fabio.transacao.transacoescartao.Transacao;
import br.com.zupacademy.fabio.transacao.transacoescartao.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ConsultaComprasRecentesController {

    @Autowired
    private CartaoRespository cartaoRespository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @GetMapping
    @RequestMapping("/cartoes/{id}/compras")
    public ResponseEntity<List<TransacaoDto>> consultaComprasRecentes(@PathVariable(name = "id") String idDoCartao) {
        cartaoRespository.findById(idDoCartao)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartão não encontrado."));
        final List<Transacao> transacoes = transacaoRepository.findLastThenTransactions(idDoCartao);
        final List<TransacaoDto> transacaoDtoList = transacoes.stream().map(TransacaoDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(transacaoDtoList);
    }
}
