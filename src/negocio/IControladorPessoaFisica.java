package negocio;

import beans.PessoaFisica;

public interface IControladorPessoaFisica {
    boolean cadastrarPessoaFisica (PessoaFisica pessoa);
    PessoaFisica buscarPessoaFisica ( String cpf);
    void removerPessoaFisica (String cpf);
}
