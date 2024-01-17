package negocio;

import beans.ContaBancaria;
import beans.PessoaFisica;
import beans.PessoaJuridica;

public interface IFachada {

    void cadastrarPessoaFisica (PessoaFisica pessoa);
    void cadastrarPessoaJuridica (PessoaJuridica pessoa);
    void cadastrarConta (ContaBancaria conta);
    PessoaFisica buscarPessoaFisica ( String cpf);
    PessoaJuridica buscarPessoaJuridica (String cnpj);
    ContaBancaria buscarContaBancaria ( String idCliente);
    void removerPessoaFisica (String cpf);
    void removerPessoaJuridica (String cnpj);
    void removerConta  (String idCliente);
    void transferir(double valortransferencia, ContaBancaria contaOrigem, ContaBancaria contaDestino);
    void atualizaSaldo( ContaBancaria conta, double saldo);
}
