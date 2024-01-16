package dados;

import beans.PessoaJuridica;

public interface IRepositorioPessoaJuridica {
    PessoaJuridica buscarPessoaJuridica(String cnpj);

    boolean cadastrar(PessoaJuridica pessoa);

    void remover(String cnpj);

    boolean existe(String cnpj);

    void salvarPessoaJuridica();
}
