package dados;

import beans.ContaBancaria;

public interface IRepositorioContaBancaria {
    ContaBancaria buscarConta(String idCliente);

    boolean cadastrar(ContaBancaria conta);

    void remover(String idCliente);

    boolean existe(String idCliente);

    void salvarConta();

    void atualizaSaldo(ContaBancaria conta, double saldo);

}
