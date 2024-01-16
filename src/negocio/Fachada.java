package negocio;

import beans.ContaBancaria;
import beans.PessoaFisica;
import beans.PessoaJuridica;

public class Fachada implements IFachada{
    private IControladorContaBancaria controladorContaBancaria;
    private IControladorPessoaFisica controladorPessoaFisica;
    private IControladorPessoaJuridica controladorPessoaJuridica;
    private static Fachada instance;


    public Fachada() {
        this.controladorContaBancaria = new ControladorContaBancaria();
        this.controladorPessoaFisica = new ControladorPessoaFisica();
        this.controladorPessoaJuridica = new ControladorPessoaJuridica();
    }

    public static Fachada getInstance() {
        if (instance == null) {
            instance = new Fachada();
        }
        return instance;
    }

    @Override
    public void cadastrarPessoaFisica(PessoaFisica pessoa) {
        controladorPessoaFisica.cadastrarPessoaFisica(pessoa);
    }

    @Override
    public void cadastrarPessoaJuridica(PessoaJuridica pessoa) {
        controladorPessoaJuridica.cadastrarPessoaJuridica(pessoa);
    }

    @Override
    public void cadastrarConta(ContaBancaria conta) {
        controladorContaBancaria.cadastrarConta(conta);
    }

    @Override
    public PessoaFisica buscarPessoaFisica(String cpf) {
        return controladorPessoaFisica.buscarPessoaFisica(cpf);
    }

    @Override
    public PessoaJuridica buscarPessoaJuridica(String cnpj) {
        return controladorPessoaJuridica.buscarPessoaJuridica(cnpj);
    }

    @Override
    public ContaBancaria buscarContaBancaria(String idConta) {
        return controladorContaBancaria.buscarContaBancaria(idConta);
    }

    @Override
    public void removerPessoaFisica(String cpf) {
        controladorPessoaFisica.removerPessoaFisica(cpf);
    }

    @Override
    public void removerPessoaJuridica(String cnpj) {
        controladorPessoaJuridica.removerPessoaJuridica(cnpj);

    }

    @Override
    public void removerConta(String idConta) {
        controladorContaBancaria.removerConta(idConta);

    }

    @Override
    public void transferir(double valortransferencia, ContaBancaria contaOrigem, ContaBancaria contaDestino) {
        controladorContaBancaria.transferir(valortransferencia, contaOrigem, contaDestino);
    }

    @Override
    public void atualizaSaldo(ContaBancaria conta, double saldo) {

    }
}
