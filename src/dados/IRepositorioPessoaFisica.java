package dados;

import beans.PessoaFisica;

public interface IRepositorioPessoaFisica {
    PessoaFisica buscarPessoaFisica(String cpf);

    boolean cadastrar(PessoaFisica pessoa);

    void remover(String cpf);

    boolean existe(String cpf);

    void salvarPessoaFisica();
}
