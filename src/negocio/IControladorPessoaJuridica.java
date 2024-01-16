package negocio;

import beans.PessoaJuridica;

public interface IControladorPessoaJuridica {
    boolean cadastrarPessoaJuridica (PessoaJuridica pessoa);
    PessoaJuridica buscarPessoaJuridica (String cnpj);
    void removerPessoaJuridica (String cnpj);

}
