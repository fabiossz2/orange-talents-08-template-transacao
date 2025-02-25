package br.com.zupacademy.fabio.transacao.transacoescartao;

public class EstabelecimentoForm {

    private String nome;
    private String cidade;
    private String endereco;

    public Estabelecimento toModel() {
        return new Estabelecimento(nome, cidade, endereco);
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

}
