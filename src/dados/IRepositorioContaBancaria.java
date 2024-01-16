package dados;

import beans.ContaBancaria;

public interface IRepositorioContaBancaria {
    ContaBancaria buscarConta(String idConta);

    boolean cadastrar(ContaBancaria conta);

    void remover(String idConta);

    boolean existe(String idConta);

    void salvarConta();

    void atualizaSaldo(ContaBancaria conta, double saldo);

}
