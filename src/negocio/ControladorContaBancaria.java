package negocio;

import beans.ContaBancaria;
import dados.IRepositorioContaBancaria;
import dados.RepositorioContaBancaria;

public class ControladorContaBancaria implements IControladorContaBancaria{
    private IRepositorioContaBancaria repositorio;

    public ControladorContaBancaria() {
        this.repositorio = RepositorioContaBancaria.getInstance();
    }

    @Override
    public boolean cadastrarConta(ContaBancaria conta) {
        boolean resposta = false;

        if (conta == null) {
            System.out.println("PARAMETRO INVALIDO");
        } else {

            if (!(this.repositorio.existe(conta.getIdConta()))) {

                this.repositorio.cadastrar(conta);

                resposta = true;
                System.out.println("Conta cadastrada com sucesso!!");
            } else {

                System.out.println("Conta não cadastrada!!");

            }
        }

        return resposta;
    }

    @Override
    public ContaBancaria buscarContaBancaria(String idConta) {
        ContaBancaria conta= null;
        if (this.repositorio.buscarConta(idConta) == null) {
            System.out.println("Conta não existe");
        } else {
            conta = repositorio.buscarConta(idConta);
        }
        return conta;
    }

    @Override
    public void removerConta(String idConta) {
        boolean x = false;
        while (x == false) {

            if (idConta != null) {
                this.repositorio.remover(idConta);
                x = true;
                System.out.println("Conta removida com sucesso!");
            } else {
                System.out.println("ID INVALIDO");
            }
        }

    }
    @Override
    public void transferir(double valortransferencia, ContaBancaria contaOrigem, ContaBancaria contaDestino) {
        double valorSaidaOrigem = contaOrigem.getSaldoAtual() - valortransferencia;

        if (valorSaidaOrigem >= 0) {
            contaOrigem.setMovimentacoesDebito();
            atualizaSaldo(contaOrigem, valorSaidaOrigem);
            double valorEntradaDestino = contaDestino.getSaldoAtual() + valortransferencia;
            contaDestino.setMovimentacoesCredito();
            atualizaSaldo(contaDestino, valorEntradaDestino);
        }
        else
            System.out.println(" Saldo da Conta Origem de número" + contaOrigem.getNumeroConta() + "está insuficiente.");
    }

    @Override
    public void atualizaSaldo(ContaBancaria conta, double saldo) {
        repositorio.atualizaSaldo(conta, saldo);
    }
}
