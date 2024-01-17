package negocio;

import beans.ContaBancaria;

public interface IControladorContaBancaria {
    boolean cadastrarConta (ContaBancaria conta);
    ContaBancaria buscarContaBancaria ( String idCliente);
    void removerConta  (String idCliente);
    void transferir(double valortransferencia, ContaBancaria contaOrigem, ContaBancaria contaDestino);
    void atualizaSaldo (ContaBancaria conta, double saldo);
}
