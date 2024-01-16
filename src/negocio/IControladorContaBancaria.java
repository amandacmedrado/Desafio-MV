package negocio;

import beans.ContaBancaria;

public interface IControladorContaBancaria {
    boolean cadastrarConta (ContaBancaria conta);
    ContaBancaria buscarContaBancaria ( String idConta);
    void removerConta  (String idConta);
    void transferir(double valortransferencia, ContaBancaria contaOrigem, ContaBancaria contaDestino);
    void atualizaSaldo (ContaBancaria conta, double saldo);
}
